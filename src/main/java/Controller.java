import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void updateView() {
        view.setStatistik(rechtschreibTrainer.getStatistikInsgesamt(), rechtschreibTrainer.getStatistikRichtig(), rechtschreibTrainer.getStatistikFalsch());
        view.setBild(rechtschreibTrainer.getCurrentWort().getURL());
    }

    public static void main(String[] args){
        new Controller();
    }
}
