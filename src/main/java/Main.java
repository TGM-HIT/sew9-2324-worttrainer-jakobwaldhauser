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
        list1.add(new Wortpaar("Adler", "https://jooinn.com/images/adler-4.jpg"));
        list1.add(new Wortpaar("Ratte", "https://www.slantmagazine.com/wp-content/uploads/2018/11/ratatouille-1000x600.jpg"));
        list1.add(new Wortpaar("Löwe", "https://images5.alphacoders.com/665/thumb-1920-665846.jpg"));
        list1.add(new Wortpaar("Giraffe", "https://th.bing.com/th/id/R.964d43d8632d0dc4a22ccd02c68e41a6?rik=eOh0DTlQ21C2kA&riu=http%3a%2f%2fupload.wikimedia.org%2fwikipedia%2fcommons%2ff%2ff9%2fGiraffe_Portrait%2c_Woburn_Safari_Park.jpg&ehk=wZaeO8iK9Cbm1prBj1sqbBvAb5oHrI0mASKFPv56XIQ%3d&risl=&pid=ImgRaw&r=0"));
        list1.add(new Wortpaar("Auto", "https://th.bing.com/th/id/OIP.uszUxJ8AmvyMasfHABIEewHaFD?rs=1&pid=ImgDetMain"));

        RechtschreibTrainer rt1 = new RechtschreibTrainer(list1);

        rt1.wortAuswaehlen();


        //TrainerView tv = new TrainerView();
        Speichern speichern = new SpeichernJSON();
        speichern.save("speicherung.json", rt1);


    }
}
