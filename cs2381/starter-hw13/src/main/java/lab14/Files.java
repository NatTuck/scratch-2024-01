package lab14;

import java.util.List;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

class Files {
    static List<String> readWords() {
        try {
            InputStream raw = App.class
                .getResourceAsStream("/words.txt.gz");
            GZIPInputStream unz = new GZIPInputStream(raw);
            InputStreamReader rdr = new InputStreamReader(unz);
            BufferedReader buf = new BufferedReader(rdr);
            return buf.lines().toList();
        }
        catch (Exception ee) {
            throw new RuntimeException("read failed");
        }
    }
}
