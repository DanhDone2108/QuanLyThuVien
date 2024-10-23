import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date



object  User : Table("user")
{
    val idUser = integer("id").autoIncrement()
    val HoTen = varchar("HoTen", 20)
    val ngaysinh = date("ngaysinh")
    val dienthoai = varchar("dienthoai", 10)
    val gioitinh = varchar("gioitinh", 5)
    val taikhoan= varchar("taikhoan", 20)
    val matkhau = varchar("matkhau", 20)
    val phanloai =varchar("phanloai", 20)

    override val primaryKey = PrimaryKey(idUser)
}
object Books : Table("books")
{
    val idbooks = integer("id").autoIncrement()
    val tensach = varchar("tensach", 50)
    val ngaymuon = date("ngaymuon")
    val tinhtrang =varchar("tinhtrang", 50)
    val maUser =integer("maUserMuon").references(User.idUser)
    override val primaryKey = PrimaryKey(idbooks)
}

object BorrowDetails : Table("borrow_details")
{
    val idPM = integer("idPM").autoIncrement()
    val userID = integer("userID").references(User.idUser)
    val bookId = integer("bookId").references(Books.idbooks)
    val borrowDate = date("borrow_Date")
    val returnDate = date("return_date").nullable()

     override val primaryKey = PrimaryKey(idPM)
}
