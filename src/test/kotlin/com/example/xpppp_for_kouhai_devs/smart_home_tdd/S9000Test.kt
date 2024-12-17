package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.S9000
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class S9000Test {
    @Test
    fun ` SwitchのisOnメソッドが実行された回数をswitchIsOnCounterに保存する`(){
        // arrange
        val switch = S9000()

        // act
        switch.isOn()
        switch.isOn()
        switch.isOn()

        // assert
        assertEquals(3, switch.isOnTimesCounter)
    }
}