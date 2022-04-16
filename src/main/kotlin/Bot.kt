import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class Bot(
    val callback: (Update?) -> String,
) : TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return TelegramCredentials.TOKEN
    }

    override fun getBotUsername(): String {
        return TelegramCredentials.NAME
    }

    override fun onUpdateReceived(update: Update?) {
        sendMsg(update!!.message.chatId.toString(), callback(update))
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