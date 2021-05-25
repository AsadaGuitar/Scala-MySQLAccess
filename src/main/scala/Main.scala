import java.sql.Connection
import java.sql.DriverManager

object Main extends App{

  println("Hello")

  //portは　show variables like 'port';　で確認
  val url = "jdbc:mysql://localhost:3306/scala"
  //.cjの方を使う
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = "root"
  val password = "********"
  var connection:Connection = _
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement
    val rs = statement.executeQuery("SELECT id, name FROM account")
    while (rs.next) {
      val id = rs.getString("id")
      val name = rs.getString("name")
      println("id = %s, name = %s".format(id,name))
    }
  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close

}