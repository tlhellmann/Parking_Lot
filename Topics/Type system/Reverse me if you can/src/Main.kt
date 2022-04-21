fun reverse(input: Int?): Int {
        when(input){
        null -> return -1
        else -> {
            val charArray: CharArray = input!!.toString().toCharArray()
            charArray.reverse()
            val output2: Int = charArray.joinToString("").toInt()
            return output2
            }
        }
}
