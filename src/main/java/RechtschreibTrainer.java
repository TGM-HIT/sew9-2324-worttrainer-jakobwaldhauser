import java.util.Random;

public class RechtschreibTrainer {
    private Wortpaar[] woerter;
    private Wortpaar currentWort;
    private int statistikInsgesamt;
    private int statistikRichtig;

    public RechtschreibTrainer(Wortpaar[] woerter){
        this.woerter = woerter;
    }

    public void wortAuswaehlen(int index){
        try {
            currentWort = woerter[index];
        }catch(Exception e){

        }
    }

    public void wortAuswaehlen(){
        Random random = new Random();
        int index = random.nextInt(woerter.length);
        wortAuswaehlen();
    }

    public boolean pruefen(String eingabe){
        try{
            if(eingabe.equals(currentWort.getWort())){
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
