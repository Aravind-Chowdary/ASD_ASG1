import javax.swing.*;
import java.awt.*;

public class CRSHome extends JFrame {
    static CRSHome frame;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame= new CRSHome();
                    frame.setResizable(false);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public CRSHome() {

    }
}