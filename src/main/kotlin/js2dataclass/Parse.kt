package js2dataclass

fun parse(x: dynamic): JsType {
    return when {
        isNull(x) -> JsNull()

        isString(x) -> JsStr(nullable = false)
        isNumber(x) -> JsNum(nullable = false)
        isInteger(x) -> JsInt(nullable = false)

        isObject(x) -> {
            val fields = entries(x).map { (key, value) ->
                (key as String) to parse(value)
            }.toMap()
            JsObj(nullable = false, fields = fields)
        }

        isArray(x) -> {
            val xs = elements(x)
            if (xs.isEmpty()) {
                JsEmptyArray()
            } else {
                var element = parse(xs[0])
                for (i in 1 until xs.size) {
                    element = element.merge(parse(xs[i]))
                }
                JsArray(nullable = false, element = element)
            }
        }

        else -> {
            console.log(x)
            error("unknown js type")
        }
    }
}
