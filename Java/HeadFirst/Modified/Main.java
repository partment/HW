public class Main {
    public static void main(String args[]) {
        MallardDuck mallardDuck = new MallardDuck();
        RedheadDuck redheadDuck = new RedheadDuck();
        RubberDuck rubberDuck = new RubberDuck();
        DecoyDuck decoyDuck = new DecoyDuck();
        ImaginaryDuckA imaginaryDuckA = new ImaginaryDuckA();
        ImaginaryDuckB imaginaryDuckB = new ImaginaryDuckB();
        ImaginaryDuckC imaginaryDuckC = new ImaginaryDuckC();

        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        redheadDuck.display();
        redheadDuck.swim();
        redheadDuck.performFly();
        redheadDuck.performQuack();

        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.performFly();
        rubberDuck.performQuack();

        decoyDuck.display();
        decoyDuck.swim();
        decoyDuck.performFly();
        decoyDuck.performQuack();

        imaginaryDuckA.display();
        imaginaryDuckA.swim();
        imaginaryDuckA.performFly();
        imaginaryDuckA.performQuack();
        imaginaryDuckA.performEat();

        imaginaryDuckB.display();
        imaginaryDuckB.swim();
        imaginaryDuckB.performQuack();

        imaginaryDuckC.display();
        imaginaryDuckC.swim();
        imaginaryDuckC.performQuack();
        imaginaryDuckC.performEat();
    }
}