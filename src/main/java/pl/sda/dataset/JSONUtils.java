package pl.sda.dataset;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONUtils {

    public void writeList(String filename, List<Rekord> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filename), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
