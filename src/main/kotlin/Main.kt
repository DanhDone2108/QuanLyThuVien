
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
   Database.connect("jdbc:sqlite:./database.db", driver = "org.sqlite.JDBC")
    transaction {
       SchemaUtils.create(User, Books, BorrowDetails)
       insertData()
    }
}