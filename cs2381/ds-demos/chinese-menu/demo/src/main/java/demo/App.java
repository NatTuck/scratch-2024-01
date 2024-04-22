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
        var menuLines = readMenuLines(); // n items
        var menu = new HashMap<String, MenuItem>();
        // Building the menu, this loop
        // has complexity: O(n)
        for (var line : menuLines) {
            var parts = line.split("\\t"); 
            int cents = stringToCents(parts[2]);
            var item = new MenuItem(parts[0], parts[1], cents);
            menu.put(parts[0], item);
            // TreeMap put is O(log n)
            // HashMap put is expected, amortized O(1)
            System.out.println(item);
        }

        var con = System.console();

        // Collect the order
        con.printf("\n\nWelcome to Restaraunt\n\n");
        var orderText = con.readLine("order> ");
        con.printf("Your order: %s\n", orderText);

        // Separate the menu codes
        var orderCodes = orderText.split("\\s+");
        // List of n codes.

        // Find the menu items in the menu
        var order = new ArrayList<MenuItem>();
        var counts = new HashMap<String, Integer>();
        // Loop complexity in terms of the length
        // of orderCodes is: O(n) 
        for (var code : orderCodes) {
            // Get is amortized O(1)
            var item = menu.get(code);

            int count = 1; 
            if (counts.containsKey(code)) {
                count = counts.get(code) + 1;
            }
            else {
                order.add(item);
            }
            counts.put(code, count);
        }

        // Generate an order sub total
        int subTotalCents = 0;
        for (var item : order) {
            var count = counts.get(item.code());
            subTotalCents += count * item.cents();
        }


        int salesTaxCents = (int) Math.round(0.085 * subTotalCents); 
        int totalCents = subTotalCents + salesTaxCents;

        // Calculate tax and total
        // Print out our recipt
        for (var item : order) {
            var count = counts.get(item.code());
            var lineTotal = count * item.cents();
            con.printf(
                "%s\t%d\t%s ea.\t%s\n", 
                item.name(), 
                count,
                centsToString(item.cents()),
                centsToString(lineTotal)
            );
        }

        con.printf("subtotal = %s\n", centsToString(subTotalCents));
        con.printf("tax = %s\n", centsToString(salesTaxCents));
        con.printf("total = %s\n", centsToString(totalCents));
    }

    // "4.95" => 495
    // "13.77" => 1377
    static int stringToCents(String text) {
        var parts = text.split("\\.");
        return Integer.parseInt(parts[0] + parts[1]);
    }

    // 1377 => "$13.77";
    static String centsToString(int cents) {
        int dollars = cents / 100;
        int cents1 = Math.floorMod(cents, 100);
        if (cents1 < 10) {
            return "$" + dollars + ".0" + cents1; 
        }
        else {
            return "$" + dollars + "." + cents1; 
        }
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