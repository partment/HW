import java.math.BigInteger;
import java.util.Scanner;

public class PrimeNumber {
    public static boolean isPrimeNumber(int n) {
        BigInteger[] array = bionomial_coefficient(n+1);
        for(BigInteger i : array) {
            if(!i.equals(BigInteger.valueOf(1))) {
                if(!i.mod(BigInteger.valueOf(n)).equals(BigInteger.valueOf(0))) return false;
            }
        }
        return true;
    }

    public static BigInteger[] bionomial_coefficient(int input) {
        BigInteger[] array = new BigInteger[input/2];
        for(int i=0;i<(input/2);i++) {
            if(i==0) {
                array[i] = BigInteger.valueOf(1);
            }else {
                array[i] = factorial(input-1).divide(factorial(i).multiply(factorial((input-1)-i)));
            }
        }
        return array;
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
        System.out.println("Spent " + etime);
    }
}