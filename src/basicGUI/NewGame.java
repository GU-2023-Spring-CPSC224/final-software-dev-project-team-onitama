import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        new NewGame();
    }

    private JLabel newGameLabel;
    private JButton quitButton;
    private int defaultBoardDimension = 5;


    NewGame()
    {

        newGameLabel = new JLabel();

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


        newGameLabel.setBounds(720, 50, 400, 100);
        newGameLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        newGameLabel.setText("New Game");


        quitButton = new JButton();
        quitButton.setText("Quit");
        quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        quitButton.setBounds(1410, 725, 100, 50);
        quitButton.addActionListener(this);
        quitButton.setFocusable(false);
        quitButton.setForeground(Color.BLACK);


        JPanel gameBoardPanel = new JPanel();
        gameBoardPanel.setBounds(525, 150, 500, 500);
        gameBoardPanel.setLayout(new GridLayout(defaultBoardDimension,defaultBoardDimension));

        for (int i = 0; i < defaultBoardDimension * defaultBoardDimension; i++)
        {
            gameBoardPanel.add(new JButton());
        }



        this.add(gameBoardPanel);
        this.add(newGameLabel);
        this.add(quitButton);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == quitButton)
        {
            QuitDialougeBox q = new QuitDialougeBox();
            if (q.getExitGame() == true)
            {
                dispose();
            }
            else if (q.getExitGame() == false)
            {
                q.dispose();
            }
        }
    }
}