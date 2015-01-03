import javax.swing.*;
import java.awt.*;

public class WorldMap extends JPanel
{

    public WorldMap(  )
    {
        setBorder( BorderFactory.createEmptyBorder( 8, 8, 8, 8 ) );
        setLayout( new GridLayout( 2, 5, 5, 5 ) );

        setBackground( Color.WHITE );
        setBorder( BorderFactory.createLineBorder( Color.BLACK, 3 ) );

        setPreferredSize( new Dimension( 500, 200 ));
        add( new RoomPanel( Color.RED,   "Metabelis Three,,Metebelis Crystal".split(",") ) );
        add( new RoomPanel( Color.RED, "Zeta Minor,,Anti-Matter".split(",") ) );
        add( new RoomPanel( Color.RED,  "Karn,,Yo-yo".split(",") ) );
        add( new RoomPanel( Color.BLACK, "Sol-3,,Bessie, Jelly Baby".split(",") ) );
        add( new RoomPanel( Color.RED,   "Phaester Osiris,,Radioactive Protection Suit".split(",") ) );
        add( new RoomPanel( Color.RED, "Skaro,,Dalekanium".split(",") ) );
        add( new RoomPanel( Color.BLACK,  "Ood-Sphere,,Scarf, 3D Glasses".split(",") ) );
        add( new RoomPanel( Color.BLACK, "Gallifrey,,Sonic Screwdriver".split(",") ) );
        add( new RoomPanel( Color.BLACK, "Stormcage,,Psychic Paper".split(",") ) );
        add( new RoomPanel( Color.BLACK, "Obsidian,,Nanogenes".split(",") ) );
    }

}
