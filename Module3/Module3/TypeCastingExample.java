public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.75;
        int myInt = (int) myDouble;
        System.out.println("Original double: " + myDouble);
        System.out.println("Double cast to int: " + myInt);

        int myIntValue = 7;
        double myDoubleValue = (double) myIntValue;
        System.out.println("Original int: " + myIntValue);
        System.out.println("Int cast to double: " + myDoubleValue);
    }
}
