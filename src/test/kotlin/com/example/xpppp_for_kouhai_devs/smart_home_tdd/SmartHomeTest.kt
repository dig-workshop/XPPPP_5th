package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.AkiraHouse
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.B9000
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.BulbTimerImpl
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.S9000
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.SmartHome
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class SmartHomeTest {
    @Test
    fun `SmartHomeがSwitchのisOnを正しく呼んでいる`() {
        // arrange
        val bulb = SpyBulb()
        val spySwitch = SpySwitch()
        val infoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(bulb, spySwitch, infoDisplay, bulbTImer)

        // act
        smartHouse.run()

        // assert
        assertTrue(spySwitch.isOnWasCalled)
    }

    @Test
    fun `switchIsOnCounterが5になったら、bulbWarningをtrueにする`() {
        val bulb = B9000()
        val stubSwitch = StubSwitch()
        val infoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(bulb, stubSwitch, infoDisplay, bulbTImer)

        // act
        stubSwitch.counter = 4
        assertFalse(bulb.bulbWarning)
        smartHouse.run()

        // assert
        assertTrue(bulb.bulbWarning)
    }

    @Test
    fun `bulbWarningがtrueの時、システムを起動するとD9000に「電球を交換してください」と表示する`() {
        // arrange
        val stubBulb = StubBulb()
        val spySwitch = SpySwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(stubBulb, spySwitch, spyInfoDisplay, bulbTImer)

        // act
        smartHouse.run()

        // assert
        assertTrue(spyInfoDisplay.displayBulbWarningWasCalled)
    }

    @Test
    fun `Bulbを交換したら、isOnCounterResetをよぶ`(){
        // arrange
        val stubBulb = StubBulb()
        val spySwitch = SpySwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(stubBulb, spySwitch, spyInfoDisplay, bulbTImer)

        // act
        smartHouse.resetBulb()

        // assert
        assertTrue(spySwitch.isOnCounterResetWasCalled)
    }

    @Test
    fun `Bulbを交換したら、isOnTimesCounterが0になる`(){
        // arrange
        val stubBulb = StubBulb()
        val switch = S9000()
        val spyInfoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(stubBulb, switch, spyInfoDisplay, bulbTImer)

        // act
        smartHouse.run()

        // assert
        assertEquals(1,switch.isOnTimesCounter)

        // act
        smartHouse.resetBulb()

        // assert
        assertEquals(0,switch.isOnTimesCounter)
    }

    @Test
    fun `Bulbを交換したら、bulbWarningがfalseになる`(){
        // arrange
        val spyBulb = SpyBulb()
        val spySwitch = SpySwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(spyBulb, spySwitch, spyInfoDisplay, bulbTImer)

        // act
        smartHouse.resetBulb()

        // assert
        assertTrue(spyBulb.bulbWarningResetWasCalled)
    }

    @Test
    fun `smartHouse起動すると、【照明を点灯しました】が表示される`(){
        // arrange
        val spyBulb = SpyBulb()
        val stubSwitch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(spyBulb, stubSwitch, spyInfoDisplay, bulbTImer)

        // act
        smartHouse.run()

        // assert
        assertTrue(spyBulb.turnOnWasCalled)
    }

    @Test
    fun `smartHouse起動後、10秒経過すると【照明を点灯しました】が表示される`(){
        // arrange
        val spyBulb = SpyBulb()
        val stubSwitch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val bulbTImer = BulbTimerImpl()
        val smartHouse: SmartHome = AkiraHouse(spyBulb, stubSwitch, spyInfoDisplay, bulbTImer)

        // act
        smartHouse.run()
        Thread.sleep(1001)

        // assert
        assertTrue(spyBulb.turnOffWasCalled)
    }
}