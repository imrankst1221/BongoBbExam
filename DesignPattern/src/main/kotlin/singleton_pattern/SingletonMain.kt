package singleton_pattern

import common.model.Car
import common.model.Constants
import common.model.Plain

object SingletonMain {
    @JvmStatic
    fun main(args: Array<String>) {
        VehicleInstance.instance.car = Car(4,1, true)
        VehicleInstance.instance.plain = Plain(12,50, false)

        print("Car details: \n" +
                "Number Of Passengers: "+VehicleInstance.instance.car.getNumberOfWheels() +"\n" +
                "Number Of Wheels: "+VehicleInstance.instance.car.getNumberOfPassengers() +"\n" +
                "Has Gas: "+VehicleInstance.instance.car.hasGas() +"\n" )

        print("Plain details: \n" +
                "Number Of Passengers: "+VehicleInstance.instance.plain.getNumberOfWheels() +"\n" +
                "Number Of Wheels: "+VehicleInstance.instance.plain.getNumberOfPassengers() +"\n" +
                "Has Gas: "+VehicleInstance.instance.plain.hasGas() +"\n" )

    }


}