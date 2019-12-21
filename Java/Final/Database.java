import java.sql.*;

public class Database {
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    //Create Table if not exists
    public Database() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            this.stmt = this.con.createStatement();
            String createOrder = "create table if not exists orderlist ("+
                                 "id char(13) primary key not null,"+
                                 "detail text not null,"+
                                 "price int not null,"+
                                 "member varchar(100) not null);";
            String createMember = "create table if not exists memberlist ("+
                                  "id varchar(100) primary key not null,"+
                                  "address text not null);";
            this.stmt.executeUpdate(createOrder);
            this.stmt.executeUpdate(createMember);
            this.stmt.close();
            this.con.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public void register(String id, String address) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            //Start checking id is whether being used
            if(this.isIDexists(id)) {
                System.out.println("This id has already registered.");
            }else {
                //Insert the data
                this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
                String register = "insert into memberlist (id, address) values (?,?);";
                this.pstmt = this.con.prepareStatement(register);
                this.pstmt.setString(1, id);
                this.pstmt.setString(2, address);
                this.pstmt.executeUpdate();
                this.pstmt.close();
                this.con.close();
                System.out.println("Register successfully!");
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public boolean isIDexists(String id) {
        int count = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            String checkidexists = "select count(id) as rowcount from memberlist where id = ?;";
            this.pstmt = this.con.prepareStatement(checkidexists);
            this.pstmt.setString(1, id);
            ResultSet exists = this.pstmt.executeQuery();
            exists.next();
            count = exists.getInt("rowcount");
            exists.close();
            this.pstmt.close();
            this.con.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }finally {

        }
        return (count > 0);
    }
    public String insertOrder(String detail, String id, int total) {
        //Generate orderid
        Long orderid = System.currentTimeMillis();
        try {
            Class.forName("org.sqlite.JDBC");
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            //Insert the data
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            String register = "insert into orderlist (id, detail, price, member) values (?,?,?,?);";
            this.pstmt = this.con.prepareStatement(register);
            this.pstmt.setString(1, orderid.toString());
            this.pstmt.setString(2, detail);
            this.pstmt.setInt(3, total);
            this.pstmt.setString(4, id);
            this.pstmt.executeUpdate();
            this.pstmt.close();
            this.con.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return orderid.toString();
    }
}