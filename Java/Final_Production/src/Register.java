import java.util.Scanner;

public class Register {
	private Scanner input = new Scanner(System.in);
	public Register() {}
    public void entrance() {
        Database database = new Database();
        System.out.print("Please enter your membership id : ");
        String id = input.next();
        System.out.print("Please enter your address : ");
        String address = input.next();
        database.register(id, address);
    }
}