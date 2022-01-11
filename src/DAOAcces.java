import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAOAcces {

    private static Connection connection;

    public DAOAcces() throws SQLException  {
        try {
            String dbName= "tp_jdbc";
            String url = "jdbc:mysql://localhost:3306/" +  dbName;
            String username = "teddy";
            String password = "teddy123";

            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DAOAcces daoAcces = new DAOAcces();

        try ( Scanner scanner = new Scanner( System.in ) ) {
            while( true ) {

                System.out.print( "What do you want to do ?" );
                System.out.print( "\nEnter 1 : List" );
                System.out.print( "\nEnter 2 : Add" );
                System.out.print( "\nEnter 3 : Modify" );
                System.out.print( "\nYour choice : " );
                String choix = "";
                choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        daoAcces.lister();
                        break;

                    case "2":
                        try ( Scanner scan = new Scanner( System.in ) ) {
                            while( true ) {
                                System.out.print( "Enter firstname : " );
                                String firstname = scanner.nextLine();

                                System.out.print( "Enter login : " );
                                String login = scanner.nextLine();

                                System.out.print( "Enter password : " );
                                String password = scanner.nextLine();

                                System.out.print( "Enter statut : " );
                                String statut = scanner.nextLine();

                                System.out.print( "Enter age : " );
                                int age = scanner.nextInt();

                                daoAcces.ajouter(firstname, login, password, statut, age);

                                break;
                            }
                        }
                        break;

                    case "3":
                        System.out.print( "Enter the id of the user to delete : " );
                        String id = "";
                        try ( Scanner scan = new Scanner( System.in ) ) {
                            while( true ) {
                                id = scanner.nextLine();
                                break;
                            }
                        }
                        daoAcces.supprimer(id);
                        break;
                }

                break;
            }
        }
    }

    public void lister() throws SQLException {
        try( Statement statement = connection.createStatement() ) {
            ResultSet rsUsers = statement.executeQuery("select * from Acces");
            while(rsUsers.next()) {
                System.out.print("Id[" + rsUsers.getInt(1) + "]"
                        + rsUsers.getString(2)
                        + "[" + rsUsers.getString("statut") + "] "
                        + rsUsers.getInt("age") +"\n"); }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouter(String prenom, String login, String password, String statut, int age) throws SQLException {
        try( Statement statement = connection.createStatement() ) {
            statement.executeUpdate("insert into Acces (prenom, login, password, statut, age) values ('"
                            + prenom + "', '"
                            + login + "', '"
                            + password + "', '"
                            + statut + "', '"
                            + age + "')");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimer(String id) throws SQLException {
        try( Statement statement = connection.createStatement() ) {
            statement.executeUpdate("delete from Acces where id = " + id);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listerDAO() throws SQLException {
        ArrayList<Acces> acces = new ArrayList<Acces>();
        try( Statement statement = connection.createStatement() ) {
            ResultSet rsUsers = statement.executeQuery("select * from Acces");
            while(rsUsers.next()) {
                Acces accesObj = new Acces(
                        rsUsers.getInt(1),
                        rsUsers.getString("prenom"),
                        rsUsers.getString("login"),
                        rsUsers.getString("password"),
                        rsUsers.getString("statut"),
                        rsUsers.getInt("age")
                );

                acces.add(accesObj);
                break;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ajouterDAO(Acces acces) throws SQLException {
        try( Statement statement = connection.createStatement() ) {
            statement.executeUpdate("insert into Acces (prenom, login, password, statut, age) values ('"
                    + acces.prenom + "', '"
                    + acces.login + "', '"
                    + acces.password + "', '"
                    + acces.statut + "', '"
                    + acces.age + "')");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerDAO(Acces acces) throws SQLException {
        try( Statement statement = connection.createStatement() ) {
            statement.executeUpdate("delete from Acces where id = " + acces.id);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
