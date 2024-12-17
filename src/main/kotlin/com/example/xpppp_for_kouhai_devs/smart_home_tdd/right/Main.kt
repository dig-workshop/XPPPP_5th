package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right

interface SmartHome{
    fun run()
    fun resetBulb()
}

fun main(){
    val bulb = B9000()
    val switch = S9000()
    val infoDisplay = D9000()
    val bulbTimer = BulbTimerImpl()
    val smartHome = AkiraHouse(bulb, switch, infoDisplay, bulbTimer)
    smartHome.run()
}
