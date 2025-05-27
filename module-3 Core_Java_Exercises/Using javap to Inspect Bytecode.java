// File: Sample.java
public class Sample {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    public static void main(String[] args) {
        Sample s = new Sample();
        s.greet("World");
    }
}
