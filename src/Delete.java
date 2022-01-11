import java.sql.*;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) throws SQLException {
        try {
            String dbName= "tp_jdbc";
            String login= "teddy";
            String motdepasse= "teddy123";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName;

            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stDeleteUser = conn.createStatement();

            System.out.print( "Enter the id of the user to delete : " );
            String idUser = "";
            try ( Scanner scanner = new Scanner( System.in ) ) {
                while( true ) {
                    idUser = scanner.nextLine();
                    break;
                }
            }

            stDeleteUser.executeUpdate("delete from Acces where id = " + idUser);

            conn.close();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }

}

