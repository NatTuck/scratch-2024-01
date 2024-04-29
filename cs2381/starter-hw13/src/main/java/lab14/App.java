package lab14;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import kotlin.Pair;
import static kotlin.collections.MapsKt.mapOf;

public class App {
    final static String URL = "https://words.homework.quest/socket/websocket";
    //final static String URL = "http://localhost:4000/socket/websocket";

    static Chan chan = null;
    static List<String> words = null;
    
    public static void main(String[] args) {
        words = Files.readWords();

        var guesses = new HashSet(List.of("z", "e", "s"));
        var pat = "ze---";

        WORD: for (var word : words) {
            if (word.length() != pat.length()) {
                continue;
            }

            for (int ii = 0; ii < pat.length(); ++ii) {
                if (!charAt(pat, ii).equals("-") && 
                !charAt(pat, ii).equals(charAt(word, ii))) {
                    continue WORD;
                }

                if (charAt(pat, ii).equals("-") &&
                    guesses.contains(charAt(word, ii))) {
                    continue WORD;
                }
            }
                    
            System.out.println("match: " + pat + " " + word);
        }

        // Best guess is a letter that is:
        //  - Common among possible words.
        //  - Common among all words, because opponent is
        //    likely to pick common letters first.
    }

    public static void main1(String[] args) {
        words = Files.readWords();

        int zz = (int)(1000 * Math.random());
        chan = new Chan(URL, "Daisy", "lecture" + zz);
    }

    public static void onJoin(Map<String, Object> msg) {
        System.out.println("Joined game.");
    }

    public static void onView(Map<String, Object> msg) {
        var puzzle = (String) msg.get("puzzle");
        System.out.println("gotView: " + puzzle);

        if (puzzle.contains("-")) {
            @SuppressWarnings("unchecked")
            var gs = new HashSet<String>((List<String>) msg.get("guesses"));
            try {
                var ch = pickMove(puzzle, gs);
                chan.guess(ch);
            }
            catch (Exception ee) {
                System.out.println("fail: " + ee);
            }
        }
        else {
            System.out.println("Game done");
            System.exit(0);
        }
    }

    static String pickMove(String puzzle, Set<String> gs) {
        var pats = puzzle.split(" ");

        var moves = legalMoves(gs);
        var bestMove = moves.get(0);



        System.out.println("Guessing " + bestMove);
        return bestMove;
    }

    static List<String> legalMoves(Set<String> gs) {
        var ys = new ArrayList<String>();
        for (var ch : letters()) {
            if (!gs.contains(ch)) {
                ys.add(ch);
            }
        }
        return ys;
    }

    static List<String> letters() {
        return Arrays.asList("snlabcdefghijkmopqrtuvwxyz".split(""));
    }

    static String charAt(String xx, int ii) {
        return Character.toString(xx.codePointAt(ii));
    }
}

