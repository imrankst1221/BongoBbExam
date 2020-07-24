package singleton_pattern

import common.model.Car
import common.model.Plain

object VehicleInstance {
    lateinit var car: Car
    lateinit var plain: Plain
    val instance: VehicleInstance by lazy(LazyThreadSafetyMode.PUBLICATION) { VehicleInstance }
}