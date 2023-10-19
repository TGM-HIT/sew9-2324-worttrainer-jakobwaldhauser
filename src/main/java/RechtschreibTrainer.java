import java.util.ArrayList;
import java.util.Random;

public class RechtschreibTrainer {
    private ArrayList<Wortpaar> woerter;
    private Wortpaar currentWort;
    private int statistikInsgesamt = 0;
    private int statistikRichtig = 0;

    public RechtschreibTrainer(ArrayList<Wortpaar> woerter){
        this.woerter = woerter;
    }

    public void wortAuswaehlen(int index){
        try {
            currentWort = woerter.get(index);
        }catch(Exception e){

        }
    }

    public void wortAuswaehlen(){
        Random random = new Random();
        int index = random.nextInt(woerter.size());
        wortAuswaehlen(index);
    }

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
