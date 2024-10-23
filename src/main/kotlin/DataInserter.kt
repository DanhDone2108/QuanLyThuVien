
import java.sql.Date
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.javatime.date
import java.time.LocalDate

fun insertData() {
    transaction {
        // Thêm người dùng
        val userId = User.insert{
            it[HoTen] = "Nguyen Van A"
            it[ngaysinh] = LocalDate.parse("2024-01-01")
            it[dienthoai] = "0123456789"
            it[gioitinh] = "Nam"
            it[taikhoan] = "nguyenvana"
            it[matkhau] = "password"
            it[phanloai] = "Thành viên"
        } get User.idUser

        // Thêm sách
        val bookId1 = Books.insert{
            it[tensach] = "Kotlin Programming"
            it[ngaymuon] = LocalDate.parse("2024-01-01")
            it[tinhtrang] = "Còn"
            it[maUser] = userId // Liên kết sách với người dùng
        }get Books.idbooks

        val bookId2 = Books.insert {
            it[tensach] = "Java Programming"
            it[ngaymuon] = LocalDate.parse("2024-01-02")
            it[tinhtrang] = "Còn"
            it[maUser] = userId// Liên kết sách với người dùng
        }get Books.idbooks

        // Thêm thông tin mượn sách
        BorrowDetails.insert {
            it[userID] = userId
            it[bookId] = bookId1
            it[borrowDate] = LocalDate.parse("2024-01-10")
            it[returnDate] = LocalDate.parse("2024-01-10")
        }

        BorrowDetails.insert {
            it[userID] = userId
            it[bookId] = bookId2
            it[borrowDate] = LocalDate.parse("2024-01-11")
            it[returnDate] = null // Chưa trả sách
        }

        println("Dữ liệu đã được thêm thành công!")
    }
}