import java.sql.*;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

public class Database extends org.sqlite.JDBC {
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    //Create Table if not exists
    public Database() {
        try {
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
    public String register(String id, String address) {
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            //Start checking id is whether being used
            if(id.equals("") || address.equals("")) {
            	return "id and address cannot be empty.";
            }
            if(this.isIDexists(id)) {
                return "This id has already registered.";
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
                return "Register successfully!";
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return "Error";
    }
    public boolean isIDexists(String id) {
        int count = 0;
        try {
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
        }
        return (count > 0);
    }
    public String insertOrder(String detail, String id, int total) {
        //Generate order id with current time (13 digits)
        Long orderid = System.currentTimeMillis();
        try {
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
    public String getOrderDetail(String id) {
    	String fallback = "";
    	try {
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            String findOrder = "select * from orderlist where id = ?;";
            this.pstmt = this.con.prepareStatement(findOrder);
            this.pstmt.setString(1, id);
            ResultSet exists = this.pstmt.executeQuery();
            while (exists.next()) {
            	fallback += "Order id : "+exists.getString("id")+"\n";
            	JSONArray detail = new JSONArray(exists.getString("detail"));
            	for(int i = 0; i < detail.length(); i++) {
            		JSONObject product = (JSONObject)detail.get(i);
            		if(product.has("weight")) {
                        fallback += (i+1)+" | "+product.get("weight")+"kg of ";
                    }else {
                        fallback += (i+1)+" | "+product.get("amount")+" ";
                    }
                    String name = (String)product.get("name");
                    Order order = new Order();
                    if(order.isCake(name)) {
                        fallback += name+" with message : "+product.get("message")+"\n";
                    }else {
                        fallback += name+"\n";
                    }
            	}
            }
            exists.close();
            this.pstmt.close();
            this.con.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    	return fallback;
    }
    public ArrayList<String> getOrderAll() {
    	ArrayList<String> listItems = new ArrayList<String>();
    	try {
            this.con = DriverManager.getConnection("jdbc:sqlite:data.db");
            String findOrder = "select * from orderlist order by id asc;";
            this.pstmt = this.con.prepareStatement(findOrder);
            ResultSet exists = this.pstmt.executeQuery();
            while (exists.next()) {
            	listItems.add(exists.getString("id")+" by "+exists.getString("member"));
            }
            exists.close();
            this.pstmt.close();
            this.con.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    	return listItems;
    }
}