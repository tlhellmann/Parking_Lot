fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()

    val basePrice = when(price){
        in (-999_999_999_999..0)        -> 0
        in (1_000_000..999_999_999_999) -> 1_000_000
        else                            -> price
    }
    val house = when(rooms){
        in (-999_999..1)    ->  Cabin(rooms, basePrice, 1.0f)
        in (2..3)           ->  Bungalow(rooms, basePrice, 1.2f)
        4                   ->  Cottage(rooms, basePrice, 1.25f)
        in (5..7)           ->  Mansion(rooms, basePrice, 1.4f)
        in (8..999_999)     ->  Palace(rooms, basePrice, 1.6f)
        else                ->  House(rooms, basePrice, 1.0f)
    }
    println(house.finalPrice())
}

open class House(val rooms: Int, val basePrice: Int, val coeff: Float) {
    fun finalPrice(): Int {
        return (basePrice * coeff).toInt()
    }
}

class Cabin(rooms: Int, basePrice: Int, coeff: Float): House(rooms, basePrice, coeff){
}
class Bungalow(rooms: Int, basePrice: Int, coeff: Float): House(rooms, basePrice, coeff){
}
class Cottage(rooms: Int, basePrice: Int, coeff: Float): House(rooms, basePrice, coeff){
}
class Mansion(rooms: Int, basePrice: Int, coeff: Float): House(rooms, basePrice, coeff){
}
class Palace(rooms: Int, basePrice: Int, coeff: Float): House(rooms, basePrice, coeff){
}