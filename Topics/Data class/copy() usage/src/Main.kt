// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    // implement your code here
    val height = readLine()!!.toInt()
    val lengthOne = readLine()!!.toInt()
    val lengthTwo = readLine()!!.toInt()
    val width = readLine()!!.toInt()
    val boxOne = Box(height, lengthOne, width)
    val boxTwo = boxOne.copy(length = lengthTwo)

    println("Box(height=${boxOne.height}, length=${boxOne.length}, width=${boxOne.width})")
    println("Box(height=${boxTwo.height}, length=${boxTwo.length}, width=${boxTwo.width})")
}