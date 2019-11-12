import java.math.BigInteger;
import java.util.Scanner;

public class PrimeNumber {
    public static boolean isPrimeNumber(int n) {
    	for(int i=1;i<((n+1)/2);i++) {
            BigInteger combi = combination((n+1)-1, i);
            if(!combi.mod(BigInteger.valueOf(n)).equals(BigInteger.valueOf(0))) return false;
        }
        return true;
    }

    public static BigInteger combination(int n, int k) {
    	BigInteger result = new BigInteger("1");
    	for(int i=n;i>k;i--) {
    		result = result.multiply(BigInteger.valueOf(i));
    	}
    	result = result.divide(factorial(n-k));
    	return result;
    }

    public static BigInteger factorial(int input) {
        BigInteger result = new BigInteger("1");
        for(int i=1;i<=input;i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter what number you want to test:");
        int n = input.nextInt();
        long stime = System.nanoTime();
        if(isPrimeNumber(n)) {
            System.out.println(n + " is a prime number");
        }else {
            System.out.println(n + " is not a prime number");
        }
        long etime = System.nanoTime() - stime;
        System.out.println("Spent " + (etime/Math.pow(10,9)) + " sec");
    }
}