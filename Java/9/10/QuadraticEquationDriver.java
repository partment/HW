import java.util.Scanner;

public class QuadraticEquationDriver {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in); // Defined a Scanner
        System.out.println("Given a QuadraticEquation ax^2+bx+c=0");
        System.out.println("Enter coefficient a");
        double a = input.nextDouble();
        System.out.println("Enter coefficient b");
        double b = input.nextDouble();
        System.out.println("Enter coefficient c");
        double c = input.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c); // Construct with a, b and c
        System.out.println("The Discriminant is "+equation.getDiscriminant());
        System.out.println("Root1 is "+equation.getRoot1());
        System.out.println("Root2 is "+equation.getRoot2());
    }
}