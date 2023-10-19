import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //erstellen von Test Wörtern
        ArrayList<Wortpaar> list1 = new ArrayList<>();
        list1.add(new Wortpaar("Hund", "https://th.bing.com/th/id/R.542611eacb5c3972de6a1fecc74de38b?rik=ycZGLnItV7s%2bAQ&riu=http%3a%2f%2fwallpapercave.com%2fwp%2fJgYQiAp.jpg&ehk=fFlqdbVQY9ouK0xw%2bBZMS3nGESR1GRHJOcL1c4M0t5M%3d&risl=&pid=ImgRaw&r=0"));
        list1.add(new Wortpaar("Katze", "https://th.bing.com/th/id/OIP.M9UpJPCBRKl9U2JKDqJPhgHaEK?pid=ImgDet&rs=1"));
        list1.add(new Wortpaar("Igel", "https://th.bing.com/th/id/OIP.TfSik2avbGBkvZVtOGlmrAHaE8?pid=ImgDet&rs=1"));
        list1.add(new Wortpaar("Tiger", "https://th.bing.com/th/id/OIP.MccTUyTQmGwGUDtaeO8A3gHaHa?pid=ImgDet&rs=1"));
        list1.add(new Wortpaar("Nashorn", "https://img.fotocommunity.com/nashorn-portrait-4122ea52-84e8-419b-9c32-dc2b8cddeaf2.jpg?width=1000"));

        RechtschreibTrainer rt1 = new RechtschreibTrainer(list1);

        rt1.wortAuswaehlen(1);


        //TrainerView tv = new TrainerView();
        Speichern speichern = new SpeichernJSON();
        speichern.save("speicherung.json", rt1);


    }
}
