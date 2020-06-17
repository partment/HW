public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
    public void display() {
        System.out.println("This is a RubberDuck.");
    }
}