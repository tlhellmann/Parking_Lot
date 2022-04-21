package parking

import java.util.*

class ParkingLot() {
    var nbSpots = 0
    var usedSpots = mutableListOf<Int>()
    var plan = mutableListOf<Car>()
    fun status() {
        if(usedSpots.size == 0) {
            println("Parking lot is empty.")
        }else {
            for(i in usedSpots.sorted()){
                println("$i ${plan[i-1].regNumber} ${plan[i-1].color}")
            }
        }
    }
}
class Car(carRegNb: String, carColor: String) {
    var regNumber = carRegNb
    var color = carColor
    var spot: Int = 0
}

fun carLeaves(spot: Int, parkingLot: ParkingLot): ParkingLot{
    if(spot in parkingLot.usedSpots) {

        for ( car in parkingLot.plan){
            if(car.spot == spot) parkingLot.plan.remove(car)
        }

        parkingLot.usedSpots.remove(spot)
        println("Spot $spot is free.")
    }else  println("There is no car in spot $spot.")
    return parkingLot
}
fun carParks(car: Car, parkingLot: ParkingLot): ParkingLot{
    //Check if there are empty spots:
    if(parkingLot.usedSpots.size == parkingLot.nbSpots){
        println("Sorry, the parking lot is full.")
    }else {
        var freeSpot = 0
        //Give a spot to the new car:
        for (i in (1..parkingLot.nbSpots)) {
            if (i !in parkingLot.usedSpots) {
                freeSpot = i
                break
            }
        }
        parkingLot.usedSpots.add(freeSpot)
        car.spot = freeSpot
        parkingLot.plan.add(car)
//        println("${car.color} car parked in spot ${car.spot}.")
    }
    return parkingLot
}
fun spotByColor(color: String, parkingLot: ParkingLot){
    val col = color.lowercase().replaceFirstChar { it.uppercase() }
    val listOfSpots = mutableListOf<Int>()
    for (car in parkingLot.plan){
        if (car.color == col) listOfSpots.add(car.spot)
    }
    if (listOfSpots.isEmpty()){
        println("No cars with color $color were found.")
    } else println(listOfSpots.joinToString(", "))
}
fun regByColor(color: String, parkingLot: ParkingLot){
    val col = color.lowercase().replaceFirstChar { it.uppercase() }
    val listOfSpots = mutableListOf<String>()
    for (car in parkingLot.plan){
        if (car.color == col) listOfSpots.add(car.regNumber)
    }
    if (listOfSpots.isEmpty()){
        println("No cars with color $color were found.")
    } else println(listOfSpots.joinToString(", "))

}
fun spotByReg(reg: String, parkingLot: ParkingLot){
    val listOfSpots = mutableListOf<Int>()
    for (car in parkingLot.plan){
        if (car.regNumber == reg) listOfSpots.add(car.spot)
    }
    if (listOfSpots.isEmpty()){
        println("No cars with registration number $reg were found.")
    } else println(listOfSpots.joinToString(", "))
}

fun main() {
    //val commandList = listOf<String>("park", "leave", "exit")
    var parkingLot = ParkingLot()
    var exit = false

    while(!exit){
        val command = readLine()!!.split(" ")
        when(command.first()){
            "create"        -> {
                                parkingLot.nbSpots = command.last().toInt()
                                //parkingLot.usedSpots = mutableListOf<Int>()
                                //parkingLot.plan = mutableListOf<Car>()
                                println("Created a parking lot with ${parkingLot.nbSpots} spots.")
                                }
            "status"        ->  if(parkingLot.nbSpots != 0){
                                    parkingLot.status()
                                }else {
                                    println("Sorry, a parking lot has not been created.")
                                }
            "park"          ->  if(parkingLot.nbSpots != 0){
                                    var car =  Car(command[1], command.last().lowercase().replaceFirstChar { it.uppercase() })
                                    parkingLot = carParks(car, parkingLot)
                                    println("${command.last()} car parked in spot ${car.spot}.")
                                }else {
                                    println("Sorry, a parking lot has not been created.")
                                }
            "leave"         ->  if(parkingLot.nbSpots != 0){
                                    parkingLot = carLeaves(command.last().toInt(), parkingLot )
                                }else {
                                    println("Sorry, a parking lot has not been created.")
                                }
            "reg_by_color"  ->  if(parkingLot.nbSpots != 0){
                                    regByColor(command.last(), parkingLot)
                                }else {
                                    println("Sorry, a parking lot has not been created.")
                                }
            "spot_by_color" ->  if(parkingLot.nbSpots != 0){
                                    spotByColor(command.last(), parkingLot)
                                }else {
                                    println("Sorry, a parking lot has not been created.")
                                }

            "spot_by_reg"   ->  if(parkingLot.nbSpots != 0){
                                    spotByReg(command.last(), parkingLot)
                                }else {
                                    println("Sorry, a parking lot has not been created.")
                                }
            "exit"          ->  exit = true
            else            ->  println("Wrong command!")
        }
    }
}
