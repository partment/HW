/* SolveEquation Class, Quadratic and ComplexPair Client
   Anderson, Franceschi
*/

import java.util.Scanner;

public class SolveEquation
{
  public static void main( String [] args )
  {
    int conti = 1;
    try {
      while(conti == 1) {
        Scanner input = new Scanner(System.in); // Defined a Scanner
        System.out.println("Given a QuadraticEquation ax^2+bx+c=0");
        System.out.println("Enter coefficient a");
        int a = input.nextInt();
        System.out.println("Enter coefficient b");
        int b = input.nextInt();
        System.out.println("Enter coefficient c");
        int c = input.nextInt();
        Quadratic q = new Quadratic(a, b, c);
        System.out.println( "Quadratic equation # 1: " + q.toString( ) );
        ComplexPair z = q.solveQuadratic( );
        System.out.println( q.getComment( ) );
        System.out.println( "Solutions: " + z + "\n" );
        System.out.println("Do you want to try again? (y/n Default : n)");
        conti = input.next().equals("y") ? 1 : 0;
      }
    }catch (java.util.InputMismatchException e) {
      System.out.println("coefficient a b c only accept integer numbers.");
      System.out.println("Please restart this program.");
    }
  }
}