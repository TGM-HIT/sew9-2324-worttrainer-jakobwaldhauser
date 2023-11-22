import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Der Controller, welcher das Modell und das View vereint
 */
public class Controller implements ActionListener {
    private RechtschreibTrainer rechtschreibTrainer;
    private TrainerView view;
    private Speichern speichern;
    public Controller(){
        speichern = new SpeichernJSON();
        rechtschreibTrainer = speichern.load("speicherung.json");
        view = new TrainerView(this);
        updateView();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Überprüfen")) {
            rechtschreibTrainer.pruefen(view.getEingabe());
            view.resetEingabe();
            updateView();
        }
        if(e.getActionCommand().equals("exit")) {
            speichern.save("speicherung.json",rechtschreibTrainer);
            System.exit(0);
        }
    }

    /**
     * updated die View mit aktuellen Werten
     */
    public void updateView() {
        view.setStatistik(rechtschreibTrainer.getStatistikInsgesamt(), rechtschreibTrainer.getStatistikRichtig(), rechtschreibTrainer.getStatistikFalsch());
        view.setBild(rechtschreibTrainer.getCurrentWort().getURL());
        view.setLastTry(rechtschreibTrainer.getLetzterVersuch());
    }

    public static void main(String[] args){
        new Controller();
    }
}
