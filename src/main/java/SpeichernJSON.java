import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.*;

public class SpeichernJSON implements Speichern{

    /**
     * Diese Methode speichert ein RechtschreibTrainer-Objekt als JSON-Datei.
     * @param file Der Dateiname, unter dem das Objekt gespeichert werden soll.
     * @param rechtschreibTrainer Das RechtschreibTrainer-Objekt, das gespeichert werden soll.
     */
    @Override
    public void save(String file, RechtschreibTrainer rechtschreibTrainer) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(rechtschreibTrainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode lädt ein RechtschreibTrainer-Objekt aus einer JSON-Datei.
     * @param file Der Dateiname, aus dem das Objekt geladen werden soll.
     * @return Das geladene RechtschreibTrainer-Objekt oder ein neues leeres Objekt, wenn ein Fehler auftritt.
     */
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
