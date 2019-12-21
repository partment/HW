import java.util.Scanner;

public class Register {
    public Register() {
        Database database = new Database();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your membership id : ");
        String id = input.next();
        System.out.print("Please enter your address : ");
        String address = input.next();
        database.register(id, address);
    }
}