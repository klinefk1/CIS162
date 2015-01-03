import javax.swing.*;
import java.awt.*;

public class RoomPanel extends JPanel
{

    public RoomPanel(  Color color, String[ ] labels )
    {
        setBorder( BorderFactory.createLineBorder( color, 3 ) );
        setBackground( Color.WHITE );
        setPreferredSize( new Dimension( 50, 50 ));
        
        setLayout( new GridLayout( 4, 1, 5, 5 ) );

        for (String s: labels)
        {
            add( new JLabel( s ) );
        }
    }

    public RoomPanel(  Color color, String label1, JLabel pic, String[ ] labels )
    {
        setBorder( BorderFactory.createLineBorder( color, 3 ) );
        setBackground( Color.WHITE );
        setPreferredSize( new Dimension( 50, 50 ));
        
        setLayout( new GridLayout( 4, 1, 5, 5 ) );
        
        add(new JLabel( label1));
        add(pic);

        for (String s: labels)
        {
            add( new JLabel( s ) );
        }
    }
}
