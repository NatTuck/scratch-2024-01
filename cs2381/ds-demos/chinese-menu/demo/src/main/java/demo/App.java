package demo;

import java.io.Console;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class App {
    public static void main(String[] args) {
        var menuLines = readMenuLines();
        var menu = new HashMap<String, MenuItem>();
        for (var line : menuLines) {
            var parts = line.split("\\t"); 
            int cents = stringToCents(parts[2]);
            var item = new MenuItem(parts[0], parts[1], cents);
            menu.put(parts[0], item);
            System.out.println(item);
        }

        var con = System.console();

        // Collect the order
        con.printf("\n\nWelcome to Restaraunt\n\n");
        var orderText = con.readLine("order> ");
        con.printf("Your order: %s\n", orderText);

        // Separate the menu codes
        var orderCodes = orderText.split("\\s+");

        // Find the menu items in the menu
        var order = new ArrayList<MenuItem>();
        for (var code : orderCodes) {
            var item = menu.get(code);
            order.add(item);
        }

        // Generate an order sub total
        int subTotalCents = 0;
        for (var item : order) {
            subTotalCents += item.cents();
        }
        con.printf("subtotal = %d cents\n", subTotalCents);



        // Calculate tax and total
        // Print out our recipt
    }

    // "4.95" => 495
    // "13.77" => 1377
    static int stringToCents(String text) {
        var parts = text.split("\\.");
        return Integer.parseInt(parts[0] + parts[1]);
    }

    static List<String> readMenuLines() {
        InputStream txt = App.class
            .getResourceAsStream("/menu.tsv");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines().toList();
    }
}

record MenuItem(String code, String name, int cents) {
    // pass
}