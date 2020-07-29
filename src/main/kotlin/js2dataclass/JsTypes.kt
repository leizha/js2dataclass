package js2dataclass


interface JsType {
    fun merge(that: JsType): JsType
    fun debugType(): String
}

fun debugNullable(nullable: Boolean): String = if (nullable) "?" else ""

class JsNull : JsType {
    override fun merge(that: JsType) = when (that) {
        is JsNull -> this
        else -> that.merge(this)
    }

    override fun debugType() = "null"
}

class JsEmptyArray : JsType {
    override fun merge(that: JsType) = when (that) {
        is JsEmptyArray -> this
        is JsArray -> that
        else -> JsAny()
    }

    override fun debugType() = "[]unknown"
}

class JsInt(val nullable: Boolean = false) : JsType {
    override fun merge(that: JsType) =
            when (that) {
                is JsInt -> this
                is JsNum -> that
                is JsNull -> JsInt(nullable = true)
                else -> JsAny()
            }

    override fun debugType() = "int${debugNullable(nullable)}"
}

class JsNum(val nullable: Boolean) : JsType {
    override fun merge(that: JsType) =
            when (that) {
                is JsInt, is JsNum -> this
                is JsNull -> JsNum(nullable = true)
                else -> JsAny()
            }

    override fun debugType() = "num${debugNullable(nullable)}"
}

class JsStr(val nullable: Boolean) : JsType {
    override fun merge(that: JsType) =
            when (that) {
                is JsStr -> this
                is JsNull -> JsStr(nullable = true)
                else -> JsAny()
            }

    override fun debugType() = "str${debugNullable(nullable)}"
}

class JsBool(val nullable: Boolean) : JsType {
    override fun merge(that: JsType) =
            when (that) {
                is JsBool -> this
                else -> JsAny()
            }

    override fun debugType() = "bool${debugNullable(nullable)}"
}

class JsObj(val nullable: Boolean, val fields: Map<String, JsType>) : JsType {
    override fun merge(that: JsType) =
            when (that) {
                is JsNull -> JsObj(nullable = true, fields = fields)
                is JsObj -> {
                    val newFields = HashMap<String, JsType>()
                    fields.forEach { (key, value) ->
                        newFields[key] = if (key in that.fields) {
                            value.merge(that.fields[key]!!)
                        } else {
                            value.merge(JsNull())
                        }
                    }
                    that.fields.forEach { (key, value) ->
                        if (key !in fields) {
                            newFields[key] = value.merge(JsNull())
                        }
                    }
                    JsObj(nullable = nullable, fields = newFields)
                }
                else -> JsAny()
            }

    override fun debugType(): String {
        val fieldsType = fields.map { (key, value) -> "${key}: ${value.debugType()}" }.joinToString("; ")
        return "{$fieldsType}${debugNullable(nullable)}"
    }
}

class JsArray(val nullable: Boolean, val element: JsType) : JsType {
    override fun merge(that: JsType) =
            when (that) {
                is JsEmptyArray -> this
                is JsNull -> JsArray(nullable = true, element = element)
                is JsArray -> JsArray(nullable = nullable, element = element.merge(that.element))
                else -> JsAny()
            }

    override fun debugType(): String {
        val elementType = element.debugType()
        return "[]$elementType${debugNullable(nullable)}"
    }
}

class JsAny : JsType {
    override fun merge(that: JsType): JsType = this
    override fun debugType() = "any"
}
