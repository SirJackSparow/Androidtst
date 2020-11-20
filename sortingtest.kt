fun main() {
    sorting(arrayOf(4, 9, 7, 5, 8, 9, 3))
}

fun sorting(numbers: Array<Int>) {
    var n = 0
    var temp = 0
    var jumlahswap = 0
    var nomor = 1
    while (n <= numbers.size - 2) {
        if (numbers[n] > numbers[n + 1]) {
            temp = numbers[n]
            numbers[n] = numbers[n + 1]
            numbers[n + 1] = temp

            print("$nomor. [${numbers[n]},${numbers[n + 1]}] -> ")

            for (x in numbers) {
                print("$x ")
            }
            println()
            n = 0
            nomor +=1
            jumlahswap += 1
        } else {
            n += 1
        }

    }

    println()

    print("Jumlah swap: $jumlahswap")

}

