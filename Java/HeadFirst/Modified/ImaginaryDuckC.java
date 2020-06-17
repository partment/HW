public class ImaginaryDuckC extends Duck {
    public ImaginaryDuckC() {
        quackBehavior = new Quack();
        eatStatus = new UnEatable();
    }
    public void display() {
        System.out.println("This is a ImaginaryDuckC.");
    }
}