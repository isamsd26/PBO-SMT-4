fun main(args: Array<String>) {
    val cetakbuku1 = Buku(BukuDemo.buku1[0].toString(),BukuDemo.buku1[1].toString(),BukuDemo.buku1[2].toString(),BukuDemo.buku1[3].toString())
    val cetakbuku2 = Buku(BukuDemo.buku2[0],BukuDemo.buku2[1],BukuDemo.buku2[2],BukuDemo.buku2[3])

    cetakbuku1.cetakBuku()
    cetakbuku2.cetakBuku()
}