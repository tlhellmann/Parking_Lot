data class Client(val name: String, val age: Int, val balance: Int)

fun main() {
    //implement your code here
    val nameOne = readLine()!!
    val ageOne = readLine()!!.toInt()
    val balanceOne = readLine()!!.toInt()
    val nameTwo = readLine()!!
    val ageTwo = readLine()!!.toInt()
    val balanceTwo = readLine()!!.toInt()

    val personOne = Client(nameOne, ageOne, 0)
    val personTwo = Client(nameTwo, ageTwo, 0)

    println(personOne.equals(personTwo))
}