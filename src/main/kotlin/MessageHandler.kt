fun handleMessage(inputMessage: String, chatId: String): String {
    return when(inputMessage){
        "/aboba" -> {
            val calculated = 2 * 5
            "aboba aboba + $calculated"
        }

        else -> "unknown command"
    }
}