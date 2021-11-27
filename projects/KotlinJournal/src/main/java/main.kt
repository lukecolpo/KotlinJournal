fun main() {
    val diary = Diary()
    var choice = ""

    // main loop
    while (choice != "4") {
        diary.printHomeScreen()
        println()
        println("Choose an action:")
        println("1 - Add an entry")
        println("2 - Search for entries")
        println("3 - Delete entries")
        println("4 - End")
        choice = readLine()!!
        println()

        //reaction to the choice
        when (choice) {
            "1" -> diary.addEntry()
            "2" -> diary.searchEntries()
            "3" -> diary.deleteEntries()
            "4" -> println("Press any key to quit the program...")
            else -> println("Error. Press any key to choose another action.")
        }
    }
}
