package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right

class S9000 : Switch {
    private var counter = 0
    override val isOnTimesCounter: Int
        get() = counter

    override fun isOn(): Boolean {
        counter++
        return true
    }

    override fun isOnCounterReset() {
        counter = 0
    }
}