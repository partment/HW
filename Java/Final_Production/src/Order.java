import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Scanner;

public class Order {
    private JSONArray orderlist = new JSONArray();
    private Scanner input = new Scanner(System.in);
    Database database = new Database();
    public Order() {}
    public void entrance(String id) {
        if(this.database.isIDexists(id)) {
            boolean exit = false;
            while(!exit) {
                System.out.println("Please choose what you want to do.");
                System.out.println("(1) Buy");
                System.out.println("(2) Delete");
                System.out.println("(3) Confirm");
                System.out.println("(4) Exit");
                switch(this.input.nextLine()) {
                    case "1":
                        //Buy
                        this.addOrder();
                        break;
                    case "2":
                        //Delete
                        this.deleteOrder();
                        break;
                    case "3":
                        //Confirm
                        exit = this.confirmOrder(id);
                        break;
                    case "4":
                        exit = true;
                        break;
                    default:
                        System.out.println("Unknown Feature.");
                        break;
                }
            }
        }else {
            System.out.println("Please register first!");
        }
    }
    public boolean isCake(String name) {
    	//to check if a string contains substring "cake"
    	//use regular expression
        return name.matches("(.*)cake(.*)");
    }
    public void addOrder() {
    	JSONObject product = new JSONObject();
        System.out.print("Enter what you want to buy : ");
        String name = this.input.nextLine();
        //is a cake?
        if(this.isCake(name)) {
            product.put("name", name);
            System.out.print("Enter amount : ");
            product.put("amount", this.input.nextInt());
            this.input.nextLine();
            //If so ask for custom message
            System.out.print("Enter custom message : ");
            product.put("message", this.input.nextLine());
        }else {
            product.put("name", name);
            System.out.print("Do you want to buy by quantity? (y/n): ");
            String choice = this.input.nextLine();
            if(choice.equals("y") || choice.equals("")) {
                System.out.print("Enter amount : ");
                product.put("amount", this.input.nextInt());
            }else {
                System.out.print("Enter weight(kg) : ");
                product.put("weight", this.input.nextInt());
            }
            this.input.nextLine();
        }
        this.orderlist.put(product);
    }
    public void deleteOrder() {
    	if(this.orderlist.length() > 0) {
            this.printOrder();
            System.out.print("Which one do you want to delete? : ");
            this.orderlist.remove(this.input.nextInt() - 1);
            this.input.nextLine();
        }else {
            System.out.println("You haven't ordered anything yet.");
        }
    }
    public boolean confirmOrder(String id) {
    	int subtotal = this.calcSubTotal();
        int total = 0;
        if(this.orderlist.length() > 0) {
            if(subtotal < 400) {
                System.out.println("Total value must have more than NTD400.");
                return false;
            }
            if(subtotal >= 400 && subtotal < 1200) {
                total = subtotal + 200;
            }
            if(subtotal >= 1200) {
                total = subtotal;
            }
            this.printOrder();
            System.out.println("Subtotal(without ship fee):"+subtotal+" | Total(with ship fee):"+total);
            System.out.print("Do you sure? (y/n): ");
            String choice = this.input.nextLine();
            if(choice.equals("y") || choice.equals("")) {
                //Insert the order
                String orderid = this.database.insertOrder(this.orderlist.toString(), id, total);
                System.out.println("Order has placed! Order id : "+orderid);
                return true;
            }else {
                return false;
            }
        }else {
            System.out.println("You haven't ordered anything yet.");
        }
        return false;
    }
    public void printOrder() {
        System.out.println("----- This is your order list -----");
        for(int i = 0; i < this.orderlist.length(); i++) {
            JSONObject product = (JSONObject)this.orderlist.get(i);
            if(product.has("weight")) {
                System.out.print((i+1)+" : "+product.get("weight")+"kg of ");
            }else {
                System.out.print((i+1)+" : "+product.get("amount")+" ");
            }
            String name = (String)product.get("name");
            if(this.isCake(name)) {
                System.out.println(name+" with message : "+product.get("message"));
            }else {
                System.out.println(name);
            }
        }
        System.out.println("----- End of your order list -----");
    }
    public int calcSubTotal() {
        int subtotal = 0;
        for(int i = 0; i < this.orderlist.length(); i++) {
            JSONObject product = (JSONObject)this.orderlist.get(i);
            String name = (String)product.get("name");
            if(product.has("weight")) {
                subtotal = subtotal + (int)product.get("weight")*50;
            }else if(isCake(name)) {
                subtotal = subtotal + (int)product.get("amount")*300;
            }else {
                subtotal = subtotal + (int)product.get("amount")*10;
            }
        }
        return subtotal;
    }
}