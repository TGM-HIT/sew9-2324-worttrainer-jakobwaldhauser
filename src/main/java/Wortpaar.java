/**
Ein Wortpaar bestehend aus dem Wort und dem dazugehörigen Bild als URL
 */
public class Wortpaar {
    private String wort;
    private String url;

    public Wortpaar(String wort, String url){
        this.wort = wort;
        this.url = url;
    }

    public String getWort(){
        return this.wort;
    }

    public String getURL(){
        return this.url;
    }

    public void setWort(String wort){
        this.wort = wort;
    }

    public void setURL(String url){
        this.url = url;
    }
}
