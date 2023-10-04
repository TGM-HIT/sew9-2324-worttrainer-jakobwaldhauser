import java.util.ArrayList;
import java.util.Random;

public class RechtschreibTrainer {
    private ArrayList<Wortpaar> woerter;
    private Wortpaar currentWort;
    private int statistikInsgesamt;
    private int statistikRichtig;

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
        int index = random.nextInt(woerter.size()-1);
        wortAuswaehlen();
    }

    public boolean pruefen(String eingabe){
        try{
            if(eingabe.equals(currentWort.getWort())){
                currentWort = null;
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public Wortpaar getCurrentWort() {
        return currentWort;
    }
}
