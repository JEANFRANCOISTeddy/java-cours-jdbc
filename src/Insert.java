import java.sql.*;

public class Insert {

    /**
     *
     * Méthode qui possède un main qui ajoute un tuple dans la base de données
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
            Statement stAddUser = conn.createStatement();
            stAddUser.executeUpdate("insert into Acces values (5,'Tom','tomahawk','indien','Etudiant',22)");

            conn.close();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }

}