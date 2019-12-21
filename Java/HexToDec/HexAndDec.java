import java.util.Scanner;

public class HexAndDec {
    private static Scanner input = new Scanner(System.in);

    public HexAndDec () {}

    private static Integer HexToDec(String hex) {
        return Integer.parseInt(hex, 16);
    }

    private static String DecToHex(int dec) {
        return Integer.toHexString(dec);
    }
    public static void main(String args[]) {
        HexAndDec manipulater = new HexAndDec();
        System.out.println("Hexadecimal to Decimal press 1");
        System.out.println("Decimal to Hexadecimal press 2");
        switch(manipulater.input.nextInt()) {
            case 1:
                System.out.println("Enter with Hexadecimal notation:");
                System.out.println("Decimal:"+manipulater.HexToDec(manipulater.input.next()));
                break;
            case 2:
                System.out.println("Enter with Decimal notation:");
                System.out.println("Hexadecimal:"+manipulater.DecToHex(manipulater.input.nextInt()).toUpperCase());
                break;
            default:
                System.out.println("Unknown");
                break;
        }
    }
}