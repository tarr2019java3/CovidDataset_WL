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
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Rekord rekord = new Rekord();
                rekord.setSno(Integer.parseInt(columns[0]));
                rekord.setDate(columns[1]);
                rekord.setProvince(columns[2]);
                rekord.setCountry(columns[3]);
                rekord.setLast(columns[4]);
                rekord.setConfirmed(Double.parseDouble(columns[5]));
                rekord.setDeaths(Double.parseDouble(columns[6]));
                rekord.setRecorved(Double.parseDouble(columns[7]));
                rekords.add(rekord);

                System.out.println(line);

            }

            JSONUtils jsonUtils = new JSONUtils();
            jsonUtils.writeList("COVID.json", rekords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
