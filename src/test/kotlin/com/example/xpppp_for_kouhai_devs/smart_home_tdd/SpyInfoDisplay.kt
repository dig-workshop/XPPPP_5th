package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.InfoDisplay

class SpyInfoDisplay : InfoDisplay {
    var displayBulbWarningWasCalled: Boolean = false
    override fun displayBulbWarning() {
        displayBulbWarningWasCalled = true
    }
}