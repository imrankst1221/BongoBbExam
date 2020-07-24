package common.model

class Plain constructor( private val numberOfWheel: Int,
                         private val numberOfPassenger: Int,
                         private val hasGas: Boolean): Vehicle{


    override fun getNumberOfWheels(): Int {
        return numberOfWheel
    }

    override fun getNumberOfPassengers(): Int {
        return numberOfPassenger
    }

    override fun hasGas(): Boolean {
        return hasGas
    }
}