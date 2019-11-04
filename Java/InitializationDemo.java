public class InitializationDemo {
    public static void main(String args[]) {
        new InitializationDemo();
        System.out.println("1");
    }

    public InitializationDemo() {
        new M();
    }

    {
        System.out.println("2");
    }
    static {
        System.out.println("3");
    }
}
class M extends N {
    M() {
        System.out.println("4");
    }

    {
        System.out.println("5");
    }
    static {
        System.out.println("6");
    }
}
class N {
    N() {
        System.out.println("7");
    }

    {
        System.out.println("8");
    }

    static {
        System.out.println("9");
    }
}