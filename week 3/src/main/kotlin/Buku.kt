class Buku {
    private var judul = ""
    private var pengarang = ""
    private var penerbit = ""
    private var tahun = ""

    constructor(judul: String, pengarang: String, penerbit: String, tahun: String) {
        this.judul = judul
        this.pengarang = pengarang
        this.penerbit = penerbit
        this.tahun = tahun
    }

    fun cetakBuku(){
        println(judul+", "+pengarang+", "+pengarang+", "+tahun)
    }
}