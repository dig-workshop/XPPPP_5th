package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.Switch

class SpySwitch : Switch {
    private var counter = 0
    override val isOnTimesCounter: Int
        get() = counter

    var isOnWasCalled: Boolean = false
    override fun isOn(): Boolean {
        isOnWasCalled = true
        return isOnWasCalled
    }

    var isOnCounterResetWasCalled: Boolean = false
    override fun isOnCounterReset(){
        isOnCounterResetWasCalled = true
    }
}