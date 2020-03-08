package pl.sda.dataset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private Path path;

    public void openFile(String filename) {
        path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);
            List<Rekord> rekords = new ArrayList<>();
            lines.remove(0);

            for (String line: lines) {
                String[] columns = line.split(",");
                Rekord rekord = new Rekord();
                rekord.setSno(Integer.parseInt(columns[0]));
                rekord.setDate(columns[1]);
                rekord.setProvince(columns[2]);
                rekord.setCountry(columns[3]);
                rekord.setLast(columns[4]);
                rekord.setConfirmed(Integer.parseInt(columns[5]);
                rekord.setDeaths(Integer.parseInt(columns[6]));
                rekord.setRecorved(Integer.parseInt(columns[7]);

                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
