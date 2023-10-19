import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class TrainerView extends JFrame {
    private JLabel imageLabel;
    private JTextField eingabe;
    private JLabel lastTry;
    private JLabel statistik;
    public static final int LAST_TRY_NONE = 1;
    public static final int LAST_TRY_RICHTIG = 2;
    public static final int LAST_TRY_FALSCH = 3;
    public TrainerView(ActionListener ac){
        super("Rechtschreibtrainer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        //Hauptpanel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //MittelPanel (beinhaltet Bild, Letzten Versuch und Statistik)
        JPanel midPanel = new JPanel(new BorderLayout());

        //Bild
        ImageIcon bild;
        try {
            bild = new ImageIcon(new URL("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        imageLabel = new JLabel(bild);
        midPanel.add(imageLabel, BorderLayout.CENTER);

        //Eingabe Feld
        eingabe = new JTextField();
        panel.add(eingabe, BorderLayout.CENTER);

        //Senden Button
        JButton submit = new JButton("Abschicken");
        submit.setActionCommand("Überprüfen");
        submit.addActionListener(ac);
        panel.add(submit, BorderLayout.SOUTH);

        //letzer Versuch
        lastTry = new JLabel("Letzter Versuch: ");
        midPanel.add(lastTry, BorderLayout.WEST);

        //Statistik
        statistik = new JLabel("<html>Gesamt: <br/>Richtig: <br/>Falsch: </html>");
        midPanel.add(statistik, BorderLayout.EAST);

        panel.add(midPanel,BorderLayout.NORTH);
        this.add(panel);
        this.setVisible(true);

    }

    public void setBild(String url){
        try {
            ImageIcon ic = new ImageIcon(new URL(url));
            Image image = ic.getImage ().getScaledInstance (1200, 800, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setLastTry(int status){
        switch (status){
            case LAST_TRY_NONE: lastTry.setText("Erster Versuch");
                break;
            case LAST_TRY_RICHTIG: lastTry.setText("<html>Letzter Versuch: <br/>Richtig</html>");
                break;
            case LAST_TRY_FALSCH: lastTry.setText("<html>Letzter Versuch: <br/>Falsch</html>");
                break;
            default: lastTry.setText("");
        }
    }
    public void setStatistik(int gesamt, int richtig, int falsch){
        statistik.setText("<html>Gesamt: "+gesamt+"<br/>Richtig: "+richtig+"<br/>Falsch: "+falsch+"</html>");
    }

    public String getEingabe(){
        return eingabe.getText();
    }

    public void resetEingabe() {
        eingabe.setText("");
    }
}
