import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
die View des Rechtschreibtrainers
 */
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

        //ButtonPanel
        JPanel buttonPanel = new JPanel(new BorderLayout());

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
        buttonPanel.add(submit, BorderLayout.CENTER);

        //Beenden Button
        JButton exit = new JButton("Exit");
        exit.setActionCommand("exit");
        exit.addActionListener(ac);
        buttonPanel.add(exit, BorderLayout.SOUTH);

        //letzer Versuch
        lastTry = new JLabel("Letzter Versuch: ");
        midPanel.add(lastTry, BorderLayout.WEST);

        //Statistik
        statistik = new JLabel("<html>Gesamt: <br/>Richtig: <br/>Falsch: </html>");
        midPanel.add(statistik, BorderLayout.EAST);

        panel.add(midPanel,BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(panel);
        this.setVisible(true);

    }

    /**
    setzt ein neues Bild
    @param url URL des neuen Bildes
     */
    public void setBild(String url){
        try {
            ImageIcon ic = new ImageIcon(new URL(url));
            Image image = ic.getImage ().getScaledInstance (1200, 750, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    setzt den letzten try auf eine von 4 Möglichkeiteb
    @param status neuer Status des lastTry
     */
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

    /**
    setzt eine neue Statistik
    @param gesamt Anzahl aller Wörter
    @param richtig Anzahl aller richtigen Wörter
    @param falsch Anzahl aller falschen Wörter
     */
    public void setStatistik(int gesamt, int richtig, int falsch){
        statistik.setText("<html>Gesamt: "+gesamt+"<br/>Richtig: "+richtig+"<br/>Falsch: "+falsch+"</html>");
    }

    public String getEingabe(){
        return eingabe.getText();
    }

    /**
    setzt das Eingabefeld wieder auf leer
     */
    public void resetEingabe() {
        eingabe.setText("");
    }
}
