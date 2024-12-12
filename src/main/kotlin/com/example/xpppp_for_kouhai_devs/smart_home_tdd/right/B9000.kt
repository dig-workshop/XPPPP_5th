package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right

class B9000 : Bulb {
    private var usageCount = 0
    override val bulbWarning: Boolean
        get() = usageCount > 4

    override fun turnOn() {
        print("照明が点灯しました")
    }

    override fun turnOff() {
        print("照明が消灯しました")
    }

    override fun updateUsage(count: Int) {
        usageCount = count
        println(count)
    }

    override fun bulbWarningReset() {
        usageCount = 0
    }

}