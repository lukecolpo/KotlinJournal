import java.time.LocalDateTime

// only used for data manipulation
class Database {
    // initialize list of entries
    private var entries: List<Entry> = listOf()

    // add text entry to entries indexed with date and time
    fun addEntry(dateTime: LocalDateTime, text: String){
        entries += Entry(dateTime,text)
    }

    // find entries by time and date or just date only
    fun findEntries(dateTime: LocalDateTime, byTime: Boolean): List<Entry> {
        var found: List<Entry> = listOf()

        for (entry in entries) {
            if (((byTime) && (entry.dateTime == dateTime)) // filtered by time and date
                || (!byTime && entry.dateTime.toLocalDate() == dateTime.toLocalDate()) //filtered by date only
            )
                found += entry
        }
        return found
    }

    // delete entries by specific time and date
    fun deleteEntries(dateTime: LocalDateTime) {
        val found = findEntries(dateTime, true)
        entries -= found
    }
}