import java.time.LocalDateTime

// entry object
class Entry(var dateTime: LocalDateTime, var text: String) {
    override fun toString(): String {
        // return dateTime of entry formatted by static member and entry text
        return "${dateTime.format(Diary.dateTimeFormatter)} $text"
    }
}