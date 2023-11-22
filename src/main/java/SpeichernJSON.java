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
            return loadStandard();

        }
    }

    public RechtschreibTrainer loadStandard(){
        ArrayList<Wortpaar> list1 = new ArrayList<>();
        list1.add(new Wortpaar("Hund", "https://th.bing.com/th/id/R.542611eacb5c3972de6a1fecc74de38b?rik=ycZGLnItV7s%2bAQ&riu=http%3a%2f%2fwallpapercave.com%2fwp%2fJgYQiAp.jpg&ehk=fFlqdbVQY9ouK0xw%2bBZMS3nGESR1GRHJOcL1c4M0t5M%3d&risl=&pid=ImgRaw&r=0"));
        list1.add(new Wortpaar("Katze", "https://th.bing.com/th/id/OIP.M9UpJPCBRKl9U2JKDqJPhgHaEK?pid=ImgDet&rs=1"));
        list1.add(new Wortpaar("Igel", "https://th.bing.com/th/id/OIP.TfSik2avbGBkvZVtOGlmrAHaE8?pid=ImgDet&rs=1"));
        list1.add(new Wortpaar("Tiger", "https://th.bing.com/th/id/OIP.MccTUyTQmGwGUDtaeO8A3gHaHa?pid=ImgDet&rs=1"));
        list1.add(new Wortpaar("Nashorn", "https://img.fotocommunity.com/nashorn-portrait-4122ea52-84e8-419b-9c32-dc2b8cddeaf2.jpg?width=1000"));

        RechtschreibTrainer rt1 = new RechtschreibTrainer(list1);

        rt1.wortAuswaehlen();
        return rt1;
    }

}
