import java.sql.*;

public class Select {

    public static void main(String[] args) throws SQLException  {
        try {
            String dbName= "tp_jdbc";
            String login= "teddy";
            String motdepasse= "teddy123";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName;

            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stUsers = conn.createStatement();

            ResultSet rsUsers = stUsers.executeQuery("select * from Acces");
            while(rsUsers.next()) {
                System.out.print("Id[" + rsUsers.getInt(1) + "]"
                        + rsUsers.getString(2)
                        + "[" + rsUsers.getString("statut") + "] "
                        + rsUsers.getInt("age") +"\n"); }
            conn.close();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }

}
