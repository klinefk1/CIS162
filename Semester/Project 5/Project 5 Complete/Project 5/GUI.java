import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.*;

/*************************************************************
 * GUI for a Zip Code Database
 * 
 * @author Scott Grissom
 * @version October 7, 2011
 ************************************************************/
public class GUI extends JPanel{

    MakeMap frame = new MakeMap("Map of Worlds");

    /** the analyzer that does all the real work */
    Game myGame;

    /** Buttons to initiate each action */
    JButton north, east, south, west, take, drop, look, hold, help, use;

    /** GUI frame */
    JFrame myGUI;
    JTextArea results;

    /** menu items */
    // if attempting the challenge activity
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem, newItem;

    int gamecount = 0; //counts the number of games played so that look is not dipslayed twice when new game is selected

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        new GUI();
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public GUI(){

        // establish the frame
        myGUI = new JFrame();
        myGUI.setSize(600,300);
        myGUI.setTitle("An Adventure through the Universe");    

        // create display area
        results = new JTextArea(30,60);
        JScrollPane scrollPane = new JScrollPane(results);
        myGUI.add(BorderLayout.CENTER, scrollPane);

        // create data entry panel
        help = new JButton("help");
        take = new JButton("take");
        drop = new JButton("drop");
        look = new JButton("look");
        hold = new JButton("holding");
        use = new JButton("use");
        //shrink = new JButton("shrink");

        JPanel actionPanel = new JPanel();
        actionPanel.add(new JLabel("Actions: "));
        actionPanel.add(help);
        actionPanel.add(take);
        actionPanel.add(drop);
        actionPanel.add(look); 
        actionPanel.add(hold);
        actionPanel.add(use);
        //actionPanel.add(shrink);

        myGUI.add(BorderLayout.SOUTH, actionPanel);

        // create button panel
        JPanel directionPanel = new JPanel();
        directionPanel.setLayout(new BoxLayout(directionPanel, BoxLayout.Y_AXIS));
        north = new JButton("North");
        south = new JButton("South");
        east = new JButton("East");
        west = new JButton("West");
        directionPanel.add(new JLabel("Directions"));
        directionPanel.add(north);
        directionPanel.add(south);
        directionPanel.add(east);
        directionPanel.add(west);
        myGUI.add(BorderLayout.EAST, directionPanel);

        // register the listeners
        ButtonListener listener = new ButtonListener();
        help.addActionListener(listener);
        take.addActionListener(listener);
        drop.addActionListener(listener);
        look.addActionListener(listener);
        hold.addActionListener(listener);
        use.addActionListener(listener);
        north.addActionListener(listener);
        south.addActionListener(listener);
        east.addActionListener(listener);
        west.addActionListener(listener);

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newItem = new JMenuItem("New Game");
        fileMenu.add(newItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        myGUI.setJMenuBar(menus);
        menus.add(fileMenu);

        // register the menu items with the action listener
        quitItem.addActionListener(listener);
        newItem.addActionListener(listener);

        myGUI.setVisible(true);
        myGUI.pack();

        newGame();

    }

    private void gameOver()
    {
        results.append("\n\n" + myGame.getMessage());
    }

    private void newGame()
    {
        if (gamecount == 0)
        {
            myGame = new Game();
            results.append("\n\n" + myGame.getMessage());
            myGame.look();
            results.append("\n\n" + myGame.getMessage());
            gamecount++;
        }
        else
        {
            myGame = new Game();
            results.setText("");
            results.append("\n\n" + myGame.getMessage());
            myGame.look();
            gamecount++;
            

            drop.setEnabled(true);
            help.setEnabled(true);
            take.setEnabled(true);
            look.setEnabled(true);
            hold.setEnabled(true);
            use.setEnabled(true);
            north.setEnabled(true);
            south.setEnabled(true);
            east.setEnabled(true);
            west.setEnabled(true);
        }
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     ****************************************************************/       
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

            // extract the button that was clicked
            JComponent buttonPressed = (JComponent) e.getSource();

            if (buttonPressed == quitItem)
            {
                System.exit(1);
            }
            else if (buttonPressed == newItem)
            {
                newGame();
            }
            else if (buttonPressed == east)
            {
                myGame.move("east"); 
            }
            else if (buttonPressed == west)
            {
                myGame.move("west");
            }
            else if (buttonPressed == north)
            {
                myGame.move("north");
            }
            else if (buttonPressed == south)
            {
                myGame.move("south");
            }
            else if (buttonPressed == take)
            {
                if (myGame.getCurrentRoom().getItems().size()>1)
                {
                    String item = JOptionPane.showInputDialog(null, "What do you want to take?");
                    if (item != null)
                        myGame.take(item); 
                }    
                else
                    myGame.take();
            }
            else if (buttonPressed == look)
            {
                myGame.look();
            }
            else if (buttonPressed == hold)
            {
                myGame.show();
            }
            else if (buttonPressed == use)
            {
                myGame.use();
            }
            else if (buttonPressed == help)
            {
                myGame.help();
            }
            else if (buttonPressed == drop)
            {
                String item = JOptionPane.showInputDialog(null, "What do you want to drop?");
                if (item != null)
                    myGame.drop(item);    
            }

            results.append("\n\n" + myGame.getMessage());   

            if (myGame.gameOver())
            {
                gameOver();
                drop.setEnabled(false);
                help.setEnabled(false);
                take.setEnabled(false);
                look.setEnabled(false);
                hold.setEnabled(false);
                use.setEnabled(false);
                north.setEnabled(false);
                south.setEnabled(false);
                east.setEnabled(false);
                west.setEnabled(false);

            }
        }
    }

}