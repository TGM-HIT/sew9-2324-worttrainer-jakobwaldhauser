import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.*;

public class SpeichernJSON implements Speichern{
    @Override
    public void save(String file, RechtschreibTrainer rechtschreibTrainer) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(rechtschreibTrainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public RechtschreibTrainer load(String file) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, RechtschreibTrainer.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new RechtschreibTrainer(new ArrayList<Wortpaar>());

        }
    }

}
