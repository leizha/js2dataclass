package js2dataclass

import org.w3c.dom.HTMLTextAreaElement
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Json

fun main(args: Array<String>) {
    console.log("hello world")
    
    window.addEventListener("load", {
        document.getElementById("buttongen")!!.addEventListener("click", {
            val input = (document.getElementById("textinput") as HTMLTextAreaElement).value
            console.log("input", input)
            val parsed: Json = JSON.parse(input)
            val root = parse(parsed)
            val ctx = TypeContext()
            ctx.gen(root)

            val output = ctx.definitions.joinToString("\n")
            document.getElementById("codeoutput")!!.textContent = output
        })
    })
}
