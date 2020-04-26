import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CRSHome extends JFrame {
    static CRSHome frame;
    private JPanel contentPane;
    DB db = null;
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
        db = new DB();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.cyan);
        setContentPane(contentPane);
        JLabel lblLibraryManagement = new JLabel("College Room Booking System");
        lblLibraryManagement.setFont(new Font("Times New Roman",Font.BOLD,30));

        JButton btnAdminLogin = new JButton("Room Manager Login");
        contentPane.add(btnAdminLogin);

    }
}