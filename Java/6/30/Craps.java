import java.security.SecureRandom;
import java.util.Arrays;

public class Craps {
    private int dice1, dice2;
    private SecureRandom random = new SecureRandom();
    public Craps() {}
    public void Roll() {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
    }
    public int Sum() {
        return dice1 + dice2;
    }
    public static void main(String args[]) {
        boolean end = false;
        final Integer craps[] = {2, 3, 12};
        final Integer natural[] = {7, 11};
        Craps result = new Craps();
        while(!end) {
            result.Roll();
            int sum = result.Sum();
            if(Arrays.asList(craps).contains(sum)) {
                System.out.println("You rolled "+result.dice1+" + "+result.dice2+" = "+result.Sum());
                System.out.println("You lose");
                end = true;
            }else if(Arrays.asList(natural).contains(sum)) {
                System.out.println("You rolled "+result.dice1+" + "+result.dice2+" = "+result.Sum());
                System.out.println("You win");
                end = true;
            }else {
                System.out.println("You rolled "+result.dice1+" + "+result.dice2+" = "+result.Sum());
                System.out.println("Point is "+result.Sum());
            }
        }
    }
}