package common.model

interface Vehicle {
    fun getNumberOfWheels(): Int
    fun getNumberOfPassengers(): Int
    fun hasGas(): Boolean
}