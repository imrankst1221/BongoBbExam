package factory_pattern

import common.model.Car
import common.model.Constants
import common.model.Plain
import common.model.Vehicle

object VehicleFactory {
    fun getInstance(type: String, numberOfWheels: Int, numberOfPassengers: Int, hasGas: Boolean): Vehicle?{
        when (type){
            Constants.GENERAL_VEHICLE -> return Car(numberOfWheels, numberOfPassengers, hasGas)
            Constants.SPECIAL_VEHICLE -> return Plain(numberOfWheels, numberOfPassengers, hasGas)
            else -> return null
        }
    }
}