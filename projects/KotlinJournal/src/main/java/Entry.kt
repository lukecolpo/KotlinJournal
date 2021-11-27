import java.time.LocalDateTime

class Entry(var dateTime: LocalDateTime, var text: String) {
    override fun toString(): String{
        return "$dateTime $text"
    }
}