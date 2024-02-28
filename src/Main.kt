import DataSource.FoodMenuDataSourceImpl
import Utils.IOUtils

open class Restaurant() {
    open val foodData = FoodMenuDataSourceImpl().getFoodList()

    open fun header() {
        println("List Menu Makanan")
        foodData.forEachIndexed { index, data ->
            println("${index + 1}. ${data.name} = Rp ${data.price}/porsi")
        }
    }
}

class Order() : Restaurant() {
    private var userInput1: Int? = null
    private var userInput2: Int? = null
    private var userInput3: Int? = null
    private var userInput4: Int? = null

    fun run() {
        super.header()
        orderChoice()
    }

    private fun orderChoice() {
        println("Pilih Menu Makanan[1][2][3][4][5]")
        userInput1 = IOUtils.getInputInteger()
        userInput1?.let {
            if ((userInput1!! - 1) < foodData.size && (userInput1!! - 1) >= 0) {
                showOrder(userInput1!!)
                payment()
            } else {
                println("Menu ${userInput1!!} tidak ada")
                orderChoice()
            }
        } ?: run {
            println("Input anda salah")
            orderChoice()
        }
    }

    private fun showOrder(choice: Int) {
        println("Kamu memilih menu ${choice}")
        println("Nama Menu : ${foodData[choice - 1].name}")
        println("Harga : ${foodData[choice - 1].price}")
    }

    private fun payment() {
        println("Masukkan Nominal Pembayaran Anda = ")
        userInput2 = IOUtils.getInputInteger()
        userInput2?.let {
            if (userInput2!! >= foodData[userInput1!! - 1].price) {
                println("Terima kasih, Anda berhasil memesan makanan")
                delivery()
            } else {
                println("Maaf pembayaran Anda gagal!")
                payment()
            }
        } ?: run {
            println("Silahkan input nominal uang anda")
            payment()
        }
    }

    private fun delivery() {
        println(
            "Metode Pengiriman Makanan\n" +
                    "1. Take Away\n" +
                    "2. Delivery\n" +
                    "Pilihan anda : "
        )
        userInput3 = IOUtils.getInputInteger()
        userInput3?.let {
            if ((userInput3 == 1) or (userInput3 == 2)) {
                onTheWay(userInput3!!)
            } else {
                println("Maaf metode yang anda pilih tidak ada . . .")
                delivery()
            }
        } ?: run {
            println("Input Anda salah ! coba lagi")
            delivery()
        }
    }

    private fun onTheWay(choice: Int) {
        if (choice == 1) {
            println("Makananmu sedang dimasak (5 detik) . . . . ")
            Thread.sleep(5000)
            println("Makananmu sudah siap! Silakan ambil di resto ya! (5 detik) . . . . ")
            Thread.sleep(5000)
            println("Pesanan selesai! (3 detik) . . . . ")
            Thread.sleep(3000)
        } else if (choice == 2) {
            println("Makananmu sedang dimasak (5 detik) . . . . ")
            Thread.sleep(5000)
            println("Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik) . . . . ")
            Thread.sleep(5000)
            println("Pesanan selesai! (3 detik) . . . . ")
            Thread.sleep(3000)
        }
        looping()
    }

    private fun looping() {
        println(
            "Apakah anda ingin order makanan lagi?\n" +
                    "1. Iya\n" +
                    "2. Tidak\n" +
                    "Pilihan anda : "
        )
        userInput4 = IOUtils.getInputInteger()
        userInput4?.let {
            if (userInput4 == 1) {
                run()
            } else {
                println("Terima kasih atas pesanan anda . . .")
            }
        } ?: run {
            println("Input anda salah")
            looping()
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Order().run()
        }
    }
}