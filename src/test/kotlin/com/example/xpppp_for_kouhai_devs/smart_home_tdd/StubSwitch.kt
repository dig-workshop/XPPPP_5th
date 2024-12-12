package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.Switch

class StubSwitch : Switch {
    var counter: Int = 0
    override val isOnTimesCounter: Int
        get() = counter

    override fun isOn(): Boolean {
        counter++
        return true
    }

    override fun isOnCounterReset() {}
}