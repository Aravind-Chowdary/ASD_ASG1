import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


import javax.swing.LayoutStyle.ComponentPlacement;

public class CRSHome extends JFrame {
    static CRSHome frame;
    private JPanel contentPane;
    DB db = null;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame= new CRSHome();
                    try{
                        ImageIcon  image = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
                        frame.setIconImage(image.getImage());
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    //frame.setBounds(0,0,screenSize.width, screenSize.height);

                    // frame.getContentPane().setLayout(new GridBagLayout());

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

        JButton btnAdminLogin = new JButton("Room Manager Login",db.getImage("images/pass.png"));
        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login.main(new String[]{});
                //frame.dispose();
            }
        });
        btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));



        JButton reports = new JButton("Clerk Login",db.getImage("images/pass.png"));
        reports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LoginClerk.main(new String[]{});
            }
        });
        reports.setFont(new Font("Tahoma", Font.PLAIN, 15));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(64)
                                                .addComponent(lblLibraryManagement))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(140)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(btnAdminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(reports, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))

                                .addContainerGap(95, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblLibraryManagement)
                                .addGap(32)
                                .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(reports, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );

        contentPane.setLayout(gl_contentPane);

    }
}
