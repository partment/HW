import java.util.Scanner;

public class OrderManagement {
	private Scanner input = new Scanner(System.in);
	private Database database = new Database();
	public OrderManagement() {};
	public void entrance() {
		System.out.print("Please enter your membership id : ");
		String id = input.next();
        if(this.database.isIDexists(id)) {
            boolean exit = false;
            while(!exit) {
                System.out.println("Please choose what you want to do.");
                System.out.println("(1) List order from you");
                System.out.println("(2) List all order");
                System.out.println("(3) Exit");
                switch(this.input.next()) {
                    case "1":
                    	this.database.printOrderbyMember(id);
                        break;
                    case "2":
                    	this.database.printOrderAll();
                        break;
                    case "3":
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
}
