package factory_pattern

import common.model.Constants

object FactoryMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val generalVehicle = VehicleFactory.getInstance(Constants.GENERAL_VEHICLE, 4, 1, true)!!
        val specialVehicle = VehicleFactory.getInstance(Constants.SPECIAL_VEHICLE, 12, 50, false)!!
        print("Car details: \n" +
                "Number Of Passengers: "+generalVehicle.getNumberOfWheels() +"\n" +
                "Number Of Wheels: "+generalVehicle.getNumberOfPassengers() +"\n" +
                "Has Gas: "+generalVehicle.hasGas() +"\n" )

        print("Plain details: \n" +
                "Number Of Passengers: "+specialVehicle.getNumberOfWheels() +"\n" +
                "Number Of Wheels: "+specialVehicle.getNumberOfPassengers() +"\n" +
                "Has Gas: "+specialVehicle.hasGas() +"\n" )

    }
}