package js2dataclass

fun isArray(x: dynamic) = js("!!x && x.constructor === Array") as Boolean
fun isObject(x: dynamic) = js("!!x && x.constructor === Object") as Boolean
fun isNumber(x: dynamic) = js("typeof x === 'number'") as Boolean
fun isInteger(x: dynamic) = js("Number.isInteger(x)") as Boolean
fun isString(x: dynamic) = js("typeof x === 'string'") as Boolean
fun isNull(x: dynamic) = js("x === null") as Boolean

fun entries(x: dynamic) = js("Object.entries(x)") as Array<Array<Any>>
fun elements(x: dynamic) = x as Array<Any>
