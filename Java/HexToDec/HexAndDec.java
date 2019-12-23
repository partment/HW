import java.util.Scanner;

public class HexAndDec {
    private static Scanner input = new Scanner(System.in);

    public HexAndDec () {}

    private Integer HexToDec(String hex) {
        int length = hex.length();
        int base = 1; 
        int dec = 0; 
       
        for(int i = length-1;i>=0;i--) {    
            if(hex.charAt(i) >= '0' && hex.charAt(i) <= '9') { 
                dec += (hex.charAt(i) - 48)*base;  
                base = base * 16; 
            }else if(hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F') { 
                dec += (hex.charAt(i) - 55)*base; 
                base = base*16; 
            } 
        } 
        return dec;
    }

    private String DecToHex(int dec) {
        String hex = "";
        int i = 0;
        if(dec == 0) hex = "0";
        while(dec!=0) 
        {    
            int tmp  = 0; 
            tmp = dec % 16; 
            if(tmp < 10) { 
                hex = (char)(tmp + 48)+hex; 
                i++; 
            }else { 
                hex = (char)(tmp + 55)+hex; 
                i++; 
            }
            dec = dec/16; 
        }
        return hex;
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