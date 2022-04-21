import java.lang.NumberFormatException

fun isNumber(input: String): Any{
    var response: Any
    try {
        response = input.toInt()
    }
    catch(e: NumberFormatException){
        response = input
    }
    return response
} // write this function
