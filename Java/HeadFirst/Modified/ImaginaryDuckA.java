public class ImaginaryDuckA extends Duck {
    public ImaginaryDuckA() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
        eatStatus = new Eatable();
    }
    public void display() {
        System.out.println("This is a ImaginaryDuckA.");
    }
}