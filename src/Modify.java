import java.sql.*;
import java.util.Scanner;

public class Modify {

    /**
     *
     * Méthode permettant de modifier l’orthographe d’un statut connaissant son identifiant.
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        try {
            String dbName= "tp_jdbc";
            String login= "teddy";
            String motdepasse= "teddy123";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName;

            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stModifyUser = conn.createStatement();

            System.out.print( "Modify your statut \n" );
            String userLogin = "";
            String userPassword = "";
            String userStatut = "";

            try ( Scanner scanner = new Scanner( System.in ) ) {
                while( true ) {
                    System.out.print( "Login : " );
                    userLogin = scanner.nextLine();

                    ResultSet rsUserLogin = stModifyUser.executeQuery("select * from Acces where login = '" + userLogin + "'");
                    if(!rsUserLogin.next()) {
                        System.out.print( "Login does not exists in database !" );
                        break;
                    }

                    System.out.print( "Password : " );
                    userPassword = scanner.nextLine();

                    ResultSet rsUserPassword = stModifyUser.executeQuery("select * from Acces where login = '" + userLogin + "' and password = '" + userPassword + "'");
                    if(!rsUserPassword.next()) {
                        System.out.print( "Wrong password !" );
                        break;
                    }

                    System.out.print( "Modify statut : " );
                    userStatut = scanner.nextLine();
                    stModifyUser.executeUpdate("UPDATE Acces SET statut = '" + userStatut + "' WHERE login = '" + userLogin + "'");

                    break;
                }
            }

            conn.close();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }

}
