public class PatternMatchingSwitchExample {
    public static void main(String[] args) {
        testSwitch(42);
        testSwitch("Hello");
        testSwitch(3.14);
        testSwitch(true);
    }

    public static void testSwitch(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            case Boolean b -> System.out.println("It's a Boolean: " + b);
            default -> System.out.println("Unknown type: " + obj);
        }
    }
}
