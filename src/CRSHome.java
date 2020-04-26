import javax.swing.*;
import java.awt.*;

public class CRSHome extends JFrame {
    static CRSHome frame;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame= new CRSHome();
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    frame.setBounds(0,0,screenSize.width, screenSize.height);

                    frame.getContentPane().setLayout(new GridBagLayout());
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