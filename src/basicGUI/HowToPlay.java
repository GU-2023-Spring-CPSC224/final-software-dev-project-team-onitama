import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlay extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        new HowToPlay();
    }

    JLabel optionsMenuLabel;
    JButton backButton;


    HowToPlay()
    {
        optionsMenuLabel = new JLabel();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);//this makes the frame visible
        //this.setSize(600,600);//sets x & y dimensions
        this.setTitle("Onitama");//setting title
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//what happens when we close the window
        this.setResizable(true);//we can change whether frame may be resized
        this.getContentPane().setBackground(Color.WHITE);//changing color of frame
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon image = new ImageIcon("OnitamaLogo.png"); //creates an image icon
        this.setIconImage(image.getImage()); //changes icon of frame


        optionsMenuLabel.setBounds(690, 100, 400, 100);
        optionsMenuLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        optionsMenuLabel.setText("How to play");




        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);

        this.add(optionsMenuLabel);
        this.add(backButton);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton)
        {
            dispose();
        }
    }
}
