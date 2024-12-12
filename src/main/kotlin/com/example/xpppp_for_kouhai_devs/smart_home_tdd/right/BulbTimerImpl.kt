package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right

import java.util.Timer
import kotlin.concurrent.schedule

class BulbTimerImpl : BulbTimer {
    override fun autoTurnOffBulb(bulb: Bulb) {
        val timer = Timer()
        timer.schedule(1000) {
            bulb.turnOff()
        }
    }
}