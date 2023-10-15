import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TrainerView extends JFrame {
    private ImageIcon bild;
    private JTextField eingabe;
    private JLabel lastTry;
    private JLabel statistik;
    public static final int LAST_TRY_NONE = 1;
    public static final int LAST_TRY_RICHTIG = 2;
    public static final int LAST_TRY_FALSCH = 3;
    public TrainerView(){
        super("Rechtschreibtrainer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        try {
            bild = new ImageIcon(new URL("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        JLabel imageLabel = new JLabel(bild);
        panel.add(imageLabel, BorderLayout.NORTH);

        eingabe = new JTextField();
        panel.add(eingabe, BorderLayout.CENTER);

        JButton submit = new JButton("Abschicken");
        panel.add(submit, BorderLayout.SOUTH);


        this.add(panel);
        this.setVisible(true);
    }

    public void setBild(String url){

    }
    public void setLastTry(int status){

    }
    public void setStatistik(int gesamt, int richtig, int falsch){

    }
}
