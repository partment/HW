import java.security.SecureRandom;
import java.util.Arrays;

public class Craps {
    private int dice1, dice2;
    private SecureRandom random = new SecureRandom();
    public Craps() {}
    private void Roll() {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
    }
    private int Sum() {
        return dice1 + dice2;
    }
    public void getResult() {
    	boolean end = false;
        final Integer craps[] = {2, 3, 12};
        final Integer natural[] = {7, 11};
        while(!end) {
            Roll();
            int sum = Sum();
            if(Arrays.asList(craps).contains(sum)) {
                System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum);
                System.out.println("You lose");
                end = true;
            }else if(Arrays.asList(natural).contains(sum)) {
                System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum);
                System.out.println("You win");
                end = true;
            }else {
                System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum);
                System.out.println("Point is "+sum);
            }
        }
    }
    public static void main(String args[]) {
        Craps craps = new Craps();
        craps.getResult();
    }
}