package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.Bulb
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.Switch

class StubBulb : Bulb {
    override val bulbWarning: Boolean
        get() = true

    override fun turnOn() {}

    override fun turnOff() {}

    override fun updateUsage(count: Int) {}

    override fun bulbWarningReset() {}


}