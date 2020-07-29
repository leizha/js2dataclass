package js2dataclass

class TypeContext {
    val definitions = ArrayList<String>()
    var currentPath = mutableListOf("root")

    fun gen(t: JsType): String? {
        return when (t) {
            is JsInt -> "Int${debugNullable(t.nullable)}"
            is JsStr -> "String${debugNullable(t.nullable)}"
            is JsBool -> "Boolean${debugNullable(t.nullable)}"
            is JsNum -> "Double${debugNullable(t.nullable)}"
            is JsArray -> genArr(t) + debugNullable(t.nullable)
            is JsObj -> genObj(t) + debugNullable(t.nullable)
            is JsAny -> "Any"
            else -> null
        }
    }

    fun genArr(t: JsArray): String {
        return "List<" + gen(t.element) + ">"
    }

    fun genObj(t: JsObj): String {
        // TODO add ancestors on the path if there is a naming conflict
        val name = currentPath.last().capitalize()

        val fieldTypes = t.fields.map { (key, value) ->
            currentPath.add(key)
            val type = gen(value)
            val item = if (type != null) "val $key: $type" else null
            currentPath.removeAt(currentPath.size - 1)
            item
        }.filterNotNull().joinToString(",\n    ")

        definitions.add("""data class $name(
    $fieldTypes
)
""")
        return name
    }
}
