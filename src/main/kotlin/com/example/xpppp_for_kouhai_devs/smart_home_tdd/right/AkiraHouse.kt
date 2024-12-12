package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right

import java.util.Timer
import kotlin.concurrent.schedule

interface Bulb {
    fun turnOn()
    fun turnOff()
    fun updateUsage(count: Int)
    fun bulbWarningReset()
    val bulbWarning: Boolean
}

interface Switch {
    fun isOn(): Boolean
    fun isOnCounterReset()
    val isOnTimesCounter: Int
}

interface InfoDisplay {
    fun displayBulbWarning()
}

interface BulbTimer{
    fun autoTurnOffBulb(bulb: Bulb)
}

class AkiraHouse(
    private val bulb: Bulb,
    private val switch: Switch,
    private val infoDisplay: InfoDisplay,
    private val bulbTimer: BulbTimerImpl
) : SmartHome {
    override fun run() {
        lighting(bulb, switch)
        bulb.updateUsage(switch.isOnTimesCounter)
        if (bulb.bulbWarning) {
            infoDisplay.displayBulbWarning()
        }
    }

    private fun lighting(bulb: Bulb, switch: Switch) {
        if (switch.isOn()) {
            bulb.turnOn()
            bulbTimer.autoTurnOffBulb(bulb)
        } else {
            bulb.turnOff()
        }
    }

    override fun resetBulb() {
        switch.isOnCounterReset()
        bulb.bulbWarningReset()
    }
}
