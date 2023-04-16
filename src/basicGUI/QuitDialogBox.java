import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitDialougeBox extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        new QuitDialougeBox();
    }

    boolean exitGame = false;

    private JButton yesButton;
    private JButton noButton;
    private JLabel quitLabel;


    QuitDialougeBox()
    {
        this.setVisible(true);//this makes the frame visible
        this.setTitle("Onitama");//setting title
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//what happens when we close the window
        //this.setResizable(false);//we can change whether frame may be resized
        ImageIcon image = new ImageIcon("OnitamaLogo.png"); //creates an image icon
        this.setIconImage(image.getImage()); //changes icon of frame
        this.getContentPane().setBackground(Color.WHITE);//changing color of frame
        this.setLayout(null);
        this.setBounds(300, 200, 400, 400);

        yesButton = new JButton();
        yesButton.setText("Yes");
        yesButton.addActionListener(this);
        yesButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        yesButton.setBounds(100,0,100,50);



        noButton = new JButton();
        noButton.setText("No");
        noButton.addActionListener(this);
        noButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        noButton.setBounds(220,0,100,50);


        quitLabel = new JLabel();
        quitLabel.setText("Are you sure you want to exit to main menu");
        quitLabel.setBounds(350, 250, 100, 100);
        quitLabel.setFont(new Font("MV Boli", Font.BOLD, 15));



        this.add(yesButton);
        this.add(noButton);
        this.add(quitLabel);
    }

    public boolean getExitGame()
    {
        return exitGame;
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == yesButton)
        {
            exitGame = true;
        }
        else if (e.getSource() == noButton)
        {
            exitGame = false;
        }
    }
}
