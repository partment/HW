public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    EatStatus eatStatus;
    public abstract void display();
    public void swim() {
        System.out.println("This duck is swimming.");
    }
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
    public void performEat() {
        eatStatus.eat();
    }
}