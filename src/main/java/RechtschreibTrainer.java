import java.util.ArrayList;
import java.util.Random;

/**
Ein Rechtschreibtrainer welcher eine Liste an Wortpaaren hat, von dieser kann ein Wortpaar ausgewählt werden und auf richtigkeit überprüft werden
 */
public class RechtschreibTrainer {
    private ArrayList<Wortpaar> woerter;
    private Wortpaar currentWort;
    private int statistikInsgesamt = 0;
    private int statistikRichtig = 0;

    private int letzterVersuch = 1;

    public RechtschreibTrainer(ArrayList<Wortpaar> woerter){
        this.woerter = woerter;
    }

    /**
    wählt ein Wortpaar aus der Liste aus
    @param index Index des auszuwählendes Wortes
     */
    public void wortAuswaehlen(int index){
        try {
            currentWort = woerter.get(index);
        }catch(Exception e){

        }
    }

    /**
    wählt ein zufälliges Wortpaar aus der Liste aus
     */
    public void wortAuswaehlen(){
        Random random = new Random();
        int index = random.nextInt(woerter.size());
        wortAuswaehlen(index);
    }

    /**
    überprüft ob das übergebene Wort dem aktuellen Wortpaar entspricht
    @param eingabe zu prüfendes Wort
     */
    public boolean pruefen(String eingabe){
        try{
            if(eingabe.equals(currentWort.getWort())){
                currentWort = null;
                statistikInsgesamt++;
                statistikRichtig++;
                wortAuswaehlen();
                return true;
            }
            statistikInsgesamt++;
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public Wortpaar getCurrentWort() {
        return currentWort;
    }

    public int getStatistikInsgesamt(){
        return statistikInsgesamt;
    }

    public int getStatistikRichtig(){
        return statistikRichtig;
    }

    public int getStatistikFalsch(){
        return statistikInsgesamt-statistikRichtig;
    }
}
