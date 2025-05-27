public class Inspect {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Inspect obj = new Inspect();
        int result = obj.add(5, 3);
        System.out.println("Result: " + result);
    }
}
