import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// handle user interactions and pass data to the database
class Diary {
    // create database instancce as wrapper for the list to handle data operations
    private val database = Database()

    // date and time functions we will use to pass to below function
    companion object {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyy H:m")
        val dateFormatter = DateTimeFormatter.ofPattern("d.M.yyyy")
    }

    // prompt the user for date and time
    private fun readLocalDateTime(dateTimeFormatter: DateTimeFormatter): LocalDateTime {
        return try {
            LocalDateTime.parse(readLine(), dateTimeFormatter)
        } catch (e: Exception) {
            println("Incorrect date format. Please try again.")
            readLocalDateTime(dateTimeFormatter)
        }
    }

    private fun readDateTime(): LocalDateTime {
        println("Enter the date and time as mm/dd/yyyy hh:mm")
        return readLocalDateTime(dateTimeFormatter)
    }

    private fun readDate(): LocalDate {
        println("Enter date as mm/dd/yyyy")
        return readLocalDateTime(dateFormatter).toLocalDate()
    }

    fun printEntries(day: LocalDateTime) {
        val entries = database.findEntries(day, false)
        for (entry in entries) {
            println(entry)
        }
    }

    fun addEntry() {
        val dateTime = readDateTime()
        println("Enter the entry text:")
        val text = readLine()!!
        database.addEntry(dateTime, text)
    }

    fun searchEntries() {
        // entering the date
        val dateTime = readDate().atStartOfDay()
        // searching for entries
        val entries = database.findEntries(dateTime, false)
        // printing entries
        if (entries.size > 0) {
            println("Entries found: ")
            for (entry in entries) {
                println(entry)
            }
        } else {
            // nothing found
            println("No entries were found.")
        }
    }

    fun deleteEntries() {
        println("Entries with the same exact date and time will be deleted")
        val dateTime = readDateTime()
        database.deleteEntries(dateTime)
    }

    fun printHomeScreen() {
        println()
        println()
        println("Welcome to your virtual diary!")
        val today = LocalDateTime.now()
        val yesterday = LocalDateTime.now().minusDays(1)
        println("Today is: ${LocalDateTime.now().format(dateTimeFormatter)}")
        println()
        // printing the home screen
        println("Yesterday:\n----------")
        printEntries(yesterday)
        println("Today:\n----------")
        printEntries(today)
        println()
    }

}