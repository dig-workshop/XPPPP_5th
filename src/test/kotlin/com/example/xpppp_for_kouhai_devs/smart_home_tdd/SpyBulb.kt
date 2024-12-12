package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.Bulb

class SpyBulb : Bulb {
    override val bulbWarning: Boolean
        get() = bulbWarningResetWasCalled

    var turnOnWasCalled: Boolean = false
    override fun turnOn() {
        turnOnWasCalled = true
    }

    var turnOffWasCalled: Boolean = false
    override fun turnOff() {
        turnOffWasCalled = true
    }

    override fun updateUsage(count: Int) {}
    var bulbWarningResetWasCalled = false

    override fun bulbWarningReset() {
        bulbWarningResetWasCalled = true
    }
}