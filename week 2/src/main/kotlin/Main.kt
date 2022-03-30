class MobilDemo2 {
    // static == companion
    private var statusMobil = false
    private  var gigiMobil = 0
    fun hidupkanMobil(){
        if (statusMobil==false){
            println("Mobil Hidup")
            statusMobil = true
        }else{
            println("Mobil Sudah Hidup")
        }
    }
    fun matikanMobil(){
        if (statusMobil==false){
            println("Mobil Sudah Mati")
        }else{
            println("Mobil Mati")
            statusMobil = false
        }
    }

    fun ubahGigi(gigi: Int){
        gigiMobil = gigi
        println("gigi mobil sekarang : "+gigiMobil )
    }

    fun getgigi():Int{
        return gigiMobil
    }
}