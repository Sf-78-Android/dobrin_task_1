package log

class LoggerImpl : Logger {
    private val messages : MutableList<String> = mutableListOf()

    override fun logMessage(msg: String) {
       messages.add(msg)
    }

    override fun printLog() {
        println(messages.joinToString("\n"))
    }
}