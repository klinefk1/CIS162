import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MakeMap extends JFrame
{
    public WorldMap map;
    public MakeMap( String title )
    {
        super( title );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


        setLayout( new BorderLayout( ) );
        getContentPane( ).add(map = new WorldMap(), BorderLayout.EAST ); 

        setLocation( 750, 50 );
        pack();
        setVisible(true);
    }

    public void redrawMap()
    {
        map.redrawMap();
        
    }
    
    public static void main (String[] args)
    {
        try {
            UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName());
            MakeMap frame = new MakeMap( "Map of Worlds" ); 
        }
        catch (Exception _e_) {
            {
                _e_.printStackTrace();
            }
        }

    }
    
    
}