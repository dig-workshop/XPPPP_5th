package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right

interface SmartHome{
    fun run()
    fun resetBulb()
}
//SmartHomeのインターフェースを宣言してください。
//main関数はスマートホームに必要な部品のインスタンスを作成し、アキラくんの家に依存を注入する。
//  ↓６行目から１３行目までのコメントアウトを解除してから始めてください
fun main(){
    //現状はクラスが宣言されていないのでエラーが出ていますが正しく実装できればエラーはなくなるはずです。
    val bulb = B9000()
    val switch = S9000()
    val infoDisplay = D9000()
    val bulbTImer = BulbTimerImpl()
    val smartHome = AkiraHouse(bulb, switch, infoDisplay, bulbTImer)
    smartHome.run()
}
