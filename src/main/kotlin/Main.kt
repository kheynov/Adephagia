import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


fun main() {
    println("Hello World!")
    val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
    try {
        botsApi.registerBot(Bot{
            return@Bot handleMessage(it!!.message.text, it.message.chatId.toString())
        })
    } catch (e: Exception) {
        println(e.localizedMessage)
    }
}
