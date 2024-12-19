package com.singlepointsol.vechileimagetextlazyjetpackcompose

data class CarDetails(
    val carImage: Int,
    val carName: String,
    val carTransmission: String,
    val carPower: String,
    val carTorque: String)

fun getAllCarDetails(): ArrayList<CarDetails> {
    return arrayListOf(
        CarDetails(R.drawable.bugattidivo,"Bugatti Divo", "7 Speed Dual-Clutch", "1479 bhp", "1600 Nm"),
        CarDetails(R.drawable.paganihuatya, "Pagani Huayra Codalunga", "7 Speed Auto", "828 bhp", "1100 Nm"),
        CarDetails(R.drawable.mercedesbenzexelero, "Mercedes-Maybach Exelero", "6 Speed", "690 bhp", "1020 Nm"),
        CarDetails(R.drawable.rollsroyceboattail,"Rolls-Royce La Rose Noire Droptail", "ZF 8 Speed Automatic", "563 bhp", "840 Nm")
    )
}