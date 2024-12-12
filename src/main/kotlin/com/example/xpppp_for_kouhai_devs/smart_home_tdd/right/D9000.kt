package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right
//ディスプレイD9000のクラスを宣言し、実装してください。
//D9000クラスはアキラくんの家に必要なインターフェースを継承してください。

class D9000: InfoDisplay {
   override fun displayBulbWarning() {
        print("電球が切れそうです")
    }
}