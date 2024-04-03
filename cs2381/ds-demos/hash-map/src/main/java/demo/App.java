package demo;

public class App {
    public static void main(String[] args) {
        HashMap<String, String> ns = new HashMap<>();
        ns.insert("duck", "quack");
        ns.insert("cow", "moo");
        ns.insert("sheep", "baa");
        ns.insert("goat", "neh");
        ns.insert("elephant", "toot");
        System.out.println("cow says " + ns.get("cow"));
        System.out.println("sheep says " + ns.get("sheep"));
        ns.delete("cow");
        System.out.println("sheep says " + ns.get("sheep"));
    }

    public static void main2(String[] args) {
        System.out.println("" + (-1 % 4));
        System.out.println("" + Math.floorMod(-1, 4));
    }

    public static void main1(String[] args) {
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
