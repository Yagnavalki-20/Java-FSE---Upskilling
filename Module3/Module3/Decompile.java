public class Decompile {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        Decompile obj = new Decompile();
        obj.greet("World");
    }
}
