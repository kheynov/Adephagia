import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


fun main() {
    println("Hello World!")
    val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
    try {
        botsApi.registerBot(Bot())
    } catch (e: Exception) {
        println(e.localizedMessage)
    }
}

class Bot : TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return TelegramCredentials.TOKEN
    }

    override fun getBotUsername(): String {
        return TelegramCredentials.NAME
    }

    override fun onUpdateReceived(update: Update?) {
        val message = update!!.message.text
        sendMsg(update.message.chatId.toString(), message)
    }

    @Synchronized
    fun sendMsg(chatId: String?, s: String?) {
        val sendMessage = SendMessage()
        sendMessage.enableMarkdown(true)
        sendMessage.chatId = chatId!!
        sendMessage.text = s!!
        try {
            execute(sendMessage)
        } catch (e: TelegramApiException) {
            println(e.localizedMessage)
        }
    }
}