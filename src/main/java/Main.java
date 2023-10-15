import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);


        //1. Load and register the driver
        // name of mysql driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. Establish the connection with the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root","2311");

        //3. Create the statement object - CAR
        Statement st = con.createStatement() ;

        boolean flag = true;
        while(flag){

            System.out.println("Enter the choice : ");
            System.out.println("1. View the scoreboard");
            System.out.println("2. Insert the new record");
            System.out.println("3. Update the record");
            System.out.println("4. Delete the record");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch(choice){

                // VIEW
                case 1:
                    viewTable(st);
                    break;

                // INSERT
                case 2:
                    insertRecord(st, sc);
                    break;

                // UPDATE
                case 3:
                    updateRecord(st, sc);
                    break;

                // DELETE
                case 4:
                    deleteRecord(st, sc);
                    break;

                default :
                    flag = false;
                    break;

            }


        }

    }
    static void viewTable(Statement st) throws Exception{
        String sql = "select * from scoretable; " ;
        ResultSet rs = st.executeQuery(sql);

        System.out.println("-------------------------------------");
        System.out.println("ID\t| NAME\t| RUNS\t| BALLS\t");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t| "+
                    rs.getString(2)+"\t| "+
                    rs.getInt(3)+"\t| "+
                    rs.getInt(4));
        }
        System.out.println("-------------------------------------");
    }
    static void insertRecord(Statement st, Scanner sc) throws Exception{
        // INSERT into scoretable VALUES (1,'Kohli',100,50);

        System.out.println("Enter the id : ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the player : ");
        String name = sc.next();
        System.out.println("Enter the runs scored : ");
        int runs = sc.nextInt();
        System.out.println("In how many balls??? : ");
        int balls = sc.nextInt();

        String insertQuery = "INSERT into scoretable VALUES ("+id+",'"+name+"',"+runs+","+balls+") ;" ;
        int rows = st.executeUpdate(insertQuery);

        System.out.println(rows+" rows inserted ");
        System.out.println("-------------------------------------");
    }
    static void updateRecord(Statement st, Scanner sc) throws Exception{
        // UPDATE scoretable SET runs=140, balls=70 WHERE id=1 ;
        System.out.println("Enter the id of the player : ");
        int id = sc.nextInt();
        System.out.println("Enter new runs : ");
        int runs = sc.nextInt();
        System.out.println("In how many balls??? : ");
        int balls = sc.nextInt();

        String updateQuery = "UPDATE scoretable SET runs="+runs+", balls="+balls+" WHERE id="+id+" ;";
        int rows = st.executeUpdate(updateQuery);

        System.out.println(rows+" rows updated ");
        System.out.println("-------------------------------------");
    }
    static void deleteRecord(Statement st, Scanner sc) throws Exception{
        // DELETE from scoretable where id=1;
        System.out.println("Enter the id of the player : ");
        int id = sc.nextInt();

        String deleteQuery = "DELETE from scoretable where id="+id+" ;";
        int rows = st.executeUpdate(deleteQuery);

        System.out.println(rows+" rows deleted ");
        System.out.println("-------------------------------------");
    }

}
