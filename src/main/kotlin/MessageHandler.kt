import kotlin.random.Random

fun handleMessage(inputMessage: String, chatId: String): String {
    val args = inputMessage.split(" ")
    return when (args[0]) {
        "/roll" -> if(args.size>1){
            "Шанс того, что ${args[1]}: ${Random.nextInt(1, 100)}%"
        } else{
            "Недостаточно аргументов"
        }
        else -> "Неизвестная команда"
    }
}