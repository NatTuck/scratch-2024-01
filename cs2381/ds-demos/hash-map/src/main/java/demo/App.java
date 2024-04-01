package demo;

public class App {

    public static void main(String[] args) {
        Integer x = 5;
        System.out.println("5.hashCode() = " + x.hashCode());
        Integer y = 535237;
        System.out.println("535237.hashCode() = " + y.hashCode());
        String aa = "aa";
        String ab = "ab";
        System.out.println("aa.hashCode() = " + aa.hashCode());
        System.out.println("ab.hashCode() = " + ab.hashCode());
        var eaa = new Entry<>("a", "a");
        var eab = new Entry<>("a", "b");
        System.out.println("eaa.hashCode() = " + eaa.hashCode());
        System.out.println("eab.hashCode() = " + eab.hashCode());
    }
}
