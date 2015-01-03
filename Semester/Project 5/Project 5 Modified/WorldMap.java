import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.net.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;

public class WorldMap extends JPanel
{
    RoomPanel m3;
    RoomPanel zm;
    RoomPanel karn;
    RoomPanel sol3;
    RoomPanel po;
    RoomPanel skaro;
    RoomPanel ood;
    RoomPanel gallifrey;
    RoomPanel stormcage;
    RoomPanel ob;

    JLabel ne = image("tardisNE.jpg");
    JLabel sew = image("tardisSEW.jpg");
    JLabel sew1 = image("tardisSEW.jpg");
    JLabel sew2 = image("tardisSEW.jpg");
    JLabel sw = image("tardisSW.jpg");
    JLabel e = image("tardisE.jpg");
    JLabel e1 = image("tardisE.jpg");
    JLabel nwe = image("tardisNEW.jpg");
    JLabel nw = image("tardisNW.jpg");
    JLabel nw1 = image("tardisNW.jpg");

    //panels for rooms that the user is not in
    RoomPanel m3Empty;
    RoomPanel zmEmpty;
    RoomPanel karnEmpty;
    RoomPanel sol3Empty;
    RoomPanel poEmpty;
    RoomPanel skaroEmpty;
    RoomPanel oodEmpty;
    RoomPanel gallifreyEmpty;
    RoomPanel stormcageEmpty;
    RoomPanel obEmpty;

    //panels for the current room where the user is
    RoomPanel m3Tardis;
    RoomPanel zmTardis;
    RoomPanel karnTardis;
    RoomPanel sol3Tardis;
    RoomPanel poTardis;
    RoomPanel skaroTardis;
    RoomPanel oodTardis;
    RoomPanel gallifreyTardis;
    RoomPanel stormcageTardis;
    RoomPanel obTardis;

    public WorldMap(  )
    {
        setBorder( BorderFactory.createEmptyBorder( 8, 8, 8, 8) );
        setLayout( new GridLayout( 2, 5, 5, 5 ) );

        setBackground( Color.WHITE );
        setBorder( BorderFactory.createLineBorder( Color.BLACK, 3 ) );

        setPreferredSize( new Dimension( 500, 300 ));

        //empty labels
        m3Empty = ( new RoomPanel( Color.RED,   "Metabelis Three,, Metebelis Crystal,".split(",") ) );
        zmEmpty = ( new RoomPanel( Color.RED, "Zeta Minor,,Anti-Matter".split(",") ) );
        karnEmpty = ( new RoomPanel( Color.RED,  "Karn,,Yo-yo".split(",") ) );
        sol3Empty = ( new RoomPanel( Color.BLACK, "Sol-3,,Bessie, Jelly Baby".split(",") ) );
        poEmpty = ( new RoomPanel( Color.RED,   "Phaester Osiris,,Radioactive Protection Suit".split(",") ) );
        skaroEmpty = ( new RoomPanel( Color.RED, "Skaro,,Dalekanium".split(",") ) );
        oodEmpty = ( new RoomPanel( Color.BLACK,  "Ood-Sphere,,Scarf, 3D Glasses".split(",") ) );
        gallifreyEmpty = ( new RoomPanel( Color.BLACK, "Gallifrey,,Sonic Screwdriver".split(",") ) );
        stormcageEmpty = ( new RoomPanel( Color.BLACK, "Stormcage,,Psychic Paper".split(",") ) );
        obEmpty = ( new RoomPanel( Color.BLACK, "Obsidian,,Nanogenes".split(",") ) );

        //labels with Tardis
        m3Tardis = ( new RoomPanel( Color.RED,   "Metabelis Three", e ,"Metebelis Crystal,".split(",") ) );
        zmTardis = ( new RoomPanel( Color.RED, "Zeta Minor", sew ,"Anti-Matter".split(",") ) );
        karnTardis = ( new RoomPanel( Color.BLACK, "Karn", sew1 ,"Yo-yo".split(",") ) );
        sol3Tardis = ( new RoomPanel( Color.BLACK, "Sol-3", sew2 ,"Bessie, Jelly Baby".split(",") ) );
        poTardis = ( new RoomPanel( Color.RED,   "Phaester Osiris", sw ,"Radioactive Protection Suit".split(",") ) );
        skaroTardis = ( new RoomPanel( Color.RED, "Skaro", e1 ,"Dalekanium".split(",") ) );
        oodTardis = ( new RoomPanel( Color.BLACK,  "Ood-Sphere", nw ,"Scarf, 3D Glasses".split(",") ) );
        gallifreyTardis = ( new RoomPanel( Color.BLACK, "Gallifrey", ne,"Sonic Screwdriver".split(",") ) );
        stormcageTardis = ( new RoomPanel( Color.BLACK, "Stormcage", nwe ,"Psychic Paper".split(",") ) );
        obTardis = ( new RoomPanel( Color.BLACK, "Obsidian", nw1 ,"Nanogenes".split(",") ) );        

        m3 = m3Empty;
        zm = zmEmpty;
        karn = karnEmpty;
        sol3 = sol3Empty;
        po = poEmpty;
        skaro = skaroEmpty;
        ood = oodEmpty;
        gallifrey = gallifreyTardis;
        stormcage = stormcageEmpty;
        ob = obEmpty;

        add(m3);
        add(zm);
        add(karn);
        add(sol3);
        add(po);
        add(skaro);
        add(ood);
        add(gallifrey);
        add(stormcage);
        add(ob);

    }

    public JLabel image (String fileName)
    {
        JLabel temp;
        try 
        {
            BufferedImage a = ImageIO.read(this.getClass().getResource(fileName));
            temp = new JLabel(new ImageIcon(a));
        } 
        catch (Exception e) 
        {
            temp = new JLabel("No image to display");
        }
        return temp;
    }

    //removes the TARDIS from the space on the map when the player moves
    public void emptySpace(String current)
    {
        if (current.toLowerCase().contains("metebelis"))
        {
            remove(m3);
            m3 = m3Empty;
            add(m3,0);
        }
        else if (current.toLowerCase().contains("zeta"))
        {
            remove(zm);
            zm = zmEmpty;
            add(zm,1);
        }
        else if (current.toLowerCase().contains("karn"))
        {
            remove(karn);
            karn = karnEmpty;
            add(karn,2);
        }
        else if (current.toLowerCase().contains("earth"))
        {
            remove(sol3);
            sol3 = sol3Empty;
            add(sol3,3);
        }
        else if (current.toLowerCase().contains("phaester"))
        {
            remove(po);
            po = poEmpty;
            add(po,4);
        }
        else if (current.toLowerCase().contains("skaro"))
        {
            remove(skaro);
            skaro = skaroEmpty;
            add(skaro,5);
        }
        else if (current.toLowerCase().contains("ood"))
        {
            remove(ood);
            ood = oodEmpty;
            add(ood,6);
        }
        else if (current.toLowerCase().contains("gallifrey"))
        {
            remove(gallifrey);
            gallifrey = gallifreyEmpty;
            add(gallifrey,7);
        }
        else if (current.toLowerCase().contains("stormcage"))
        {
            remove(stormcage);
            stormcage = stormcageEmpty;
            add(stormcage,8);
        }
        else if (current.toLowerCase().contains("obsidian"))
        {
            remove(ob);
            ob = obEmpty;
            add(ob);
        }
    }

    //adds the TARDIS to the new space
    public void moveTardis(String current)
    {
        if (current.toLowerCase().contains("metebelis"))
        {
            remove(m3);
            m3 = m3Tardis;
            add(m3,0);
        }
        else if (current.toLowerCase().contains("zeta"))
        {
            remove(zm);
            zm = zmTardis;
            add(zm,1);
        }
        else if (current.toLowerCase().contains("karn"))
        {
            remove(karn);
            karn = karnTardis;
            add(karn,2);
        }
        else if (current.toLowerCase().contains("earth"))
        {
            remove(sol3);
            sol3 = sol3Tardis;
            add(sol3,3);
        }
        else if (current.toLowerCase().contains("phaester"))
        {
            remove(po);
            po = poTardis;
            add(po,4);
        }
        else if (current.toLowerCase().contains("skaro"))
        {
            remove(skaro);
            skaro = skaroTardis;
            add(skaro,5);
        }
        else if (current.toLowerCase().contains("ood"))
        {
            remove(ood);
            ood = oodTardis;
            add(ood,6);
        }
        else if (current.toLowerCase().contains("gallifrey"))
        {
            remove(gallifrey);
            gallifrey = gallifreyTardis;
            add(gallifrey,7);
        }
        else if (current.toLowerCase().contains("stormcage"))
        {
            remove(stormcage);
            stormcage = stormcageTardis;
            add(stormcage,8);
        }
        else if (current.toLowerCase().contains("obsidian"))
        {
            remove(ob);
            ob = obTardis;
            add(ob);
        } 

    }

    public void redrawMap()
    {
        revalidate();
        repaint();      
    }

}
