## Written test for Bongo’s Android Developer position.

### Problem: 
Explain the design pattern used in following: 

```
Interface Vehicle  
int set_num_of_wheels()
int set_num_of_passengers() 
boolean has_gas() 
```


 a) Explain how you can use the pattern to create car and plane class? 
 
 ### Factory design Pattern
 
 ```
 object VehicleFactory {
    fun getInstance(type: String, numberOfWheels: Int, numberOfPassengers: Int, hasGas: Boolean): Vehicle?{
        when (type){
            Constants.GENERAL_VEHICLE -> return Car(numberOfWheels, numberOfPassengers, hasGas)
            Constants.SPECIAL_VEHICLE -> return Plain(numberOfWheels, numberOfPassengers, hasGas)
            else -> return null
        }
    }
}

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
 ```
 
 b) Use a different design pattern for this solution.
 
 ### Singleton design pattern
 
 ```
object VehicleInstance {
    lateinit var car: Car
    lateinit var plain: Plain
    val instance: VehicleInstance by lazy(LazyThreadSafetyMode.PUBLICATION) { VehicleInstance }
}

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
 ```
 
