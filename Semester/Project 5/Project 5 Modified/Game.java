
/**
 * Write a description of class Game here.
 * 
 * Katherine Klinefelter 
 * 2014
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.*;
public class Game
{

    private ArrayList<Item> pocket;     //stores items held

    private Room currentRoom;           //stores current location
    private String currentMsg;          //stores current message
    private int riddleCount;            //counts how many times a player has attempted the riddle

    //rooms
    private Room gallifrey;
    private Room skaro;
    private Room sol3;
    private Room karn;
    private Room metebelisThree;
    private Room obsidian;
    private Room oodSphere;
    private Room phaesterOsiris;
    private Room stormcage;
    private Room zetaMinor;

    //items
    private Item sonicScrewdriver;      //5lbs, reusable
    private Item psychicPaper;          //5lbs, reusable
    private Item bessie;                //1000lbs, reusable
    private Item jellyBaby;             //2lbs, not reusable
    private Item yoyo;                  //3lbs, reusable
    private Item scarf;                 //3 lbs, reusable
    private Item glasses;               //2 lbs, reusable
    private Item crystal;               //20lbs, reusable
    private Item dalekanium;            //45lbs, not reusable
    private Item radioactiveSuit;       //20lbs, reusable
    private Item nanogenes;             //10 lbs, not reusable
    private Item antiMatter;            //-10lbs, not reusable

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        pocket = new ArrayList<Item>();
        createRooms();      
        currentRoom = gallifrey;
    }

    private void createRooms()
    {
        //sets items
        sonicScrewdriver = new Item("the Sonic Screwdriver", "Opens doors, provided they’re not wood.  \n" +
            "Also can mess with electronics and, of course, unscrew/screw bolts and screws.\n", 5, true);
        psychicPaper = new Item("Psychic Paper", "Shows the viewer what they’re expecting to see.  \n" +
            "Useful when going under cover and needing to gain entry into someplace.\n", 5, true);
        bessie = new Item("Bessie", "Car – good for quick travel to distant locations on a planet.\n", 
            1000, true);
        jellyBaby = new Item("a Jelly Baby", "A good thing to offer friends, or enemies to distract them.\n", 2, false);
        yoyo = new Item("a yo-yo", "Field Gravity Detector.  Tests a planet's gravity.\n", 3, true);
        scarf = new Item("a scarf", "Stylish accessory can be used to reach out of reach objects, \n" + 
            "trip up an enemy, and other uses.\n", 3, true);
        glasses = new Item("3D Glasses", "Can detect \"void stuff\"\n", 2, true);
        crystal = new Item("a perfect Metebelius Crystal", "Blue crystal with psychic powers.  \n" +
            "Can focus and amplify thoughts.\n", 20, true);
        dalekanium = new Item("Dalekanium", "The material used to build Dalek armor. \n" +
            "Needed for analysis by the Time Lords.\n", 45, false);
        radioactiveSuit = new Item(" Radioactive Protection Suit", "Protects you from exposure to radiation.", 20, true);
        nanogenes = new Item("Nanogenes", "Heals damaged tissue.\n", 10, false);
        antiMatter = new Item("Anti-Matter", "Capable of producing enough energy to power a sun for 400 years \n" +
            "with about a jar of it. Could have some side effects.\n", -10, false);

        //sets rooms
        gallifrey = new Room("Gallifrey, home planet of the Time Lords (your species).  \n" +
            "It has a binary star system and is part of the constellation Kasterborous. You once said:\n" +
            "\"The sky's a bright orange, with a citadel enclosed in a mighty glass dome,\n" +
            "shining under the twin suns.  Beyond that, the mountains go on forever;\n" +
            "Slopes of deep-red grass, capped with snow.\"\n" 
        ,sonicScrewdriver, true);

        skaro = new Room("Skaro, home planet of the Daleks.  Daleks originally descended from a race called the \n" +
            "Kelads, but underwent major genetic experimentation.  All emotions are removed and Daleks are bent \n" +
            "on universal domination.  This stems from war with Thals, the other intelligent species on the planet.\n" +
            "Skaro is mostly a radioactive wasteland.  There is a Dalek city, some swamps, and some mutated forests.\n",
            dalekanium, true);

        sol3 = new Room("Earth.  You have spent quite a bit of time on earth, so I will not describe it further.\n", 
            bessie, jellyBaby, true);

        karn = new Room("Karn, a neighboring planet of Gallifrey.  It's one planet closer to the twin suns.\n" + 
            "Unfortunately, the natives have accused you of stealing their Elixer of Life and locked you up.\n"+
            "Use an item to escape.\n" , yoyo, false);

        metebelisThree = new Room ("Metebelis Three.  A planet that is quite blue.  It has a blue sun,\n" +
            "multiple moons, blue mountains, a light blue sky during the day, and a dark blue sky during \n" +
            "the night (not black, like an Earth night).  Has many hostile and intelligent life forms.\n",
            crystal, false);

        obsidian = new Room("Obsidian, a planet of perpetual darkness.  Scientists huddle around a fire, observing \n" +
            "some sort of technology.\n", nanogenes, true); //remeber to change this once item is taken.

        oodSphere = new Room("the Ood-Sphere.  Planet of the Ood, a race which communicates\n" +
            "telepathically and shares memory using a centralized brain, in addition to individual\n" + 
            "brains, located on the planet itself.\n", glasses, scarf, true);

        phaesterOsiris = new Room("Phaester Osiris.  This is the home planet of the Osirans,\n" +
            "a powerful race from which ancient Greek mythology was based.\n", radioactiveSuit, false);

        stormcage = new Room("Stormcage.  A high-security prison planet.\n", psychicPaper, true);

        zetaMinor = new Room("Zeta Minor.  This is the farthest planet of the known unit \n" +
            "and contains anti-matter.\n", antiMatter, true);

        //sets adjacencies
        metebelisThree.addNeighbor("east", zetaMinor);
        skaro.addNeighbor("east", oodSphere);
        zetaMinor.addNeighbor("west", metebelisThree);
        zetaMinor.addNeighbor("east", karn);
        zetaMinor.addNeighbor("south", oodSphere);
        oodSphere.addNeighbor("west", skaro);
        oodSphere.addNeighbor("north", zetaMinor);
        karn.addNeighbor("west", zetaMinor);
        karn.addNeighbor("south", gallifrey);
        karn.addNeighbor("east", sol3);
        gallifrey.addNeighbor("north", karn);
        gallifrey.addNeighbor("east", stormcage);
        sol3.addNeighbor("west", karn);
        sol3.addNeighbor("south", stormcage);
        sol3.addNeighbor("east", phaesterOsiris);
        stormcage.addNeighbor("west", gallifrey);
        stormcage.addNeighbor("north", sol3);
        stormcage.addNeighbor("east", obsidian);
        phaesterOsiris.addNeighbor("west", sol3);
        phaesterOsiris.addNeighbor("south", obsidian);
        obsidian.addNeighbor("north", phaesterOsiris);
        obsidian.addNeighbor("west", stormcage);

        setWelcomeMessage();

    }

    private void setWelcomeMessage()
    {
        currentMsg = "You are The Doctor (from Doctor Who)!\n" +  
        "You are currently traveling by yourself, but there are many worlds to explore.  \n" +
        "You are doing your usual thing…traveling the universe and saving various worlds \n" +
        "when they happen to be in danger (which is, pretty much all the time).   \n" +
        "The Time Lords summon you and ask you to bring them a sample of Dalekanium from Skaro \n" +
        "(this is a pre-Time War Doctor regeneration.).  \n" +
        "If you go straight there, you will die of radiation poisoning, \n" + 
        "so you will have to make a few stops before traveling to Skaro.\n";
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public String getMessage()
    {
        return currentMsg;
    }

    public void help()
    {
        currentMsg = "Welcome to my adventure game! You can move freely among most worlds,\n" +
        "however, you will find that some are accessable only through certain worlds.  This \n" +
        "information is detailed on the map.  You may also pick up, drop, and use items using \n" +
        "the buttons along the bottom of your screen.  Movement is done using the buttons on the \n" +
        "right side of the screen.  If you are stuck, you may need to use an item.\n";
    }

    public void look()
    {
        currentMsg = currentRoom.getLongDescription() + "\n";
    }

    public void move(String direction)
    {
        if (currentRoom.getCanPass())
        {
            if (currentRoom.getNeighbor(direction) != null)
            {
                currentRoom = currentRoom.getNeighbor(direction);
                look();
            }
            else
            {   
                currentMsg = "You cannot travel from this planet in that direction.";
            }
        }
        else
        {
            currentMsg = "You cannot move off of this planet until conditions are met.";
        }
    }

    public boolean gameOver()
    {
        if (!(currentRoom.getDescription().equals(zetaMinor.getDescription())) && pocket.contains(antiMatter))
        {
            currentMsg = "Anti-matter cannot be returned to N-Space.  It pulls you back and infects you. \n" +
            "You cannot leave now.  Game Over.";
            currentRoom.isCanPass(false);
            return true;
        }
        else if (currentRoom.getDescription().equals(skaro.getDescription()) && !(pocket.contains(radioactiveSuit)))
        {
            currentMsg = "Without protection, you could not survive exposure to the radiation in the \n" +
            "Dalekanium mines.  Game over.";
            currentRoom.isCanPass(false);
            return true;
        }
        else if (currentRoom.getDescription().equals(gallifrey.getDescription()) && pocket.contains(dalekanium))
        {
            currentMsg = "You have successfully completed your task!  The high council thanks you and \n" +
            "allows you to continue traveling.  You win!";
            currentRoom.isCanPass(false);
            return true;
        }
        else if (currentRoom.getDescription().equals(phaesterOsiris.getDescription()) && !pocket.contains(crystal) && !currentRoom.getCanPass())
        {
            currentMsg = "Those native to this planet highly value intelligence and logic.  They do a scan of your\n" +
            "abilities, and find that you come up short.  If only you had an item which enhances psychic abilities...\n" +
            "Game Over.";
            currentRoom.isCanPass(false);
            return true;
        }
        else if (currentRoom.getDescription().equals(phaesterOsiris.getDescription()) && riddleCount !=0 && !pocket.contains(nanogenes))
        {
            currentMsg = "You have not answered the riddle succesfully.  You are deemed unworthy of the Radioactive\n" +
            "Protection Suit and will remain trapped on Phaester Osiris for eternity.  Game Over.";
            currentRoom.isCanPass(false);
            return true;
        }
        else if (currentRoom.getDescription().equals(karn.getDescription()) && !(pocket.contains(sonicScrewdriver)) && !currentRoom.getCanPass())
        {
            currentMsg = "You find yourself blamed for trying to steel The Elixer and inprisoned.\n" +
            "Had you remembered your Sonic Screwdriver on Gallifrey, you may have been able to\n" +
            "escape...Game Over.";
            currentRoom.isCanPass(false);
            return true;
        }
        else if (currentRoom.getDescription().equals(metebelisThree.getDescription()) && !(pocket.contains(scarf)) && !currentRoom.getCanPass())
        {
            currentMsg = "The inhabitants of this planet are very hostile, especially to those seeking\n" +
            "their crystal.  If only you had something to trip them up, your fate could have been different.\n" +
            "Game Over.";
            currentRoom.isCanPass(false);
            return true;
        }

        return false;
    }

    public void take()
    {
        if (currentRoom.getDescription().equals(stormcage.getDescription()) && currentRoom.getItems().size()>0)
        {
            if (pocket.contains(jellyBaby) && !jellyBaby.getUsed())
            {
                currentMsg = "There is a guard, but he might be able to be bribed.  Maybe you\n" +
                "should offer him something...";
            }
            else if (pocket.contains(jellyBaby))
            {
                pocket.add(psychicPaper);
                currentMsg = "Picked up" + currentRoom.getItem(0).getName() + "\n";
                currentRoom.removeItem(0);
                for (int i = 0; i < pocket.size(); i++)
                {
                    if (pocket.get(i).getName().equals(jellyBaby.getName()))
                    {
                        pocket.remove(i);
                    }
                }
            }
            else
            {
                currentMsg = "There is a guard.  Maybe there is an item on another planet that can be used to bribe him.";
            }
        }
        else if (currentRoom.getDescription().equals(obsidian.getDescription())&& currentRoom.getItems().size()>0)
        {
            if (pocket.contains(psychicPaper) && !psychicPaper.getUsed())
            {
                currentMsg = "The scientist is not going to give out his nanogenes to every traveler\n" +
                "who wanders this way...";
            }
            else if (pocket.contains(psychicPaper))
            {
                pocket.add(nanogenes);
                currentMsg = "Picked up " + currentRoom.getItem(0).getName() + "\n" ;
                currentRoom.removeItem(0);
            }
            else
            {
                currentMsg = "The scientist is not going to give out his nanogenes to every traveler\n" +
                "who wanders this way...";
            }
        }
        else if (currentRoom.getDescription().equals(skaro.getDescription())&& currentRoom.getItems().size()>0)
        {
            if (pocket.contains(radioactiveSuit) && !radioactiveSuit.getUsed())
            {
                currentMsg = "The level of radiation is very high here.  Quick!  Put on the\n" +
                "suit!";
            }
            else if (pocket.contains(radioactiveSuit))
            {
                pocket.add(dalekanium);
                currentMsg = "Picked up " + currentRoom.getItem(0).getName() + "\n" ;
                currentRoom.removeItem(0);
            }
        }
        else if (currentRoom.getItems().size() == 1)
        {
            if (currentRoom.getItem(0).getWeight() <= 50)
            {
                currentMsg = "Picked up " + currentRoom.getItem(0).getName() + "\n";
                pocket.add(currentRoom.removeItem(0));
            }
            else
            {
                currentMsg = "That item is too heavy to take.";
            }
        }
        else 
        {
            currentMsg = "No items to take.\n";
        }

    }

    public void take(String s)
    {
        int count = 0;
        if (currentRoom.getDescription().equals(sol3.getDescription()) && !bessie.getUsed() && "jelly baby".contains(s.toLowerCase()))
        {
            currentMsg = "Those Jelly Babies are 10 miles away!  Maybe there is something\n" +
            "in this room you can use to get you there...";
            count++;
        }
        else if (currentRoom.getDescription().equals(sol3.getDescription()) && !bessie.getUsed())
        {
            if ("bessie".contains(s.toLowerCase()))
            {
                currentMsg = "That item is too heavy to take.";
                count++;
            }

            else if (pocket.contains(jellyBaby) && !jellyBaby.getUsed())
            {

                {
                    currentMsg = "There is a guard, but he might be able to be bribed.  Maybe you\n" +
                    "should offer him something...";
                    count++;
                }
            }
            else if (pocket.contains(jellyBaby))
            {
                count++;
                pocket.remove(jellyBaby);
                pocket.add(psychicPaper);
                currentRoom.removeItem(0);
            }
        }

        else if (currentRoom.getItems().size() > 0)
        {
            for (int i = 0; i < currentRoom.getItems().size(); i++)
                if (currentRoom.getItems().get(i).getName().toLowerCase().contains(s.toLowerCase()))
                {
                    if (currentRoom.getItems().get(i).getWeight() <= 50)
                    {
                        currentMsg = "Picked up " + currentRoom.getItem(i).getName() + "\n";
                        pocket.add(currentRoom.removeItem(i));
                        count++;
                    }
                    else
                    {
                        currentMsg = "That item is too heavy to take.";
                        count++;
                    }
            }
        }
        if (count == 0)
        {
            currentMsg = "That item is not in the room.\n";
        }
    }

    private ArrayList<Item> checkForItem(String name)
    {
        ArrayList<Item> temp = currentRoom.getItems();
        currentMsg = "";
        if (temp.size() == 0)
        {
            currentMsg = "There are no items in this room.\n";
        }
        else
        {
            for (int i = 0; i < temp.size(); i++)
            {
                currentMsg = currentMsg + temp.get(i).getName() + ", " + temp.get(i).getDescription() + "\n";
            }
        }
        return temp;
    }

    public void drop(String name)
    {
        int count = 0;
        for (int i = 0; i < pocket.size(); i++)
        {
            if (pocket.get(i).getName().toLowerCase().contains(name.toLowerCase()))
            {
                Item temp = pocket.get(i);
                pocket.remove(i);
                currentRoom.addItem(temp);
                currentMsg = "The player has successfully dropped " +temp.getName() +" in the room.\n";
                count ++;
            }
        }

        if (count == 0)
            currentMsg = "The player is not holding that item.\n";
    }

    public void show()
    {
        currentMsg = "";
        if (pocket.size() == 0)
        {
            currentMsg = "You are not holding any items.\n";
        }
        else
        {
            for (int i = 0; i < pocket.size(); i++)
            {
                currentMsg = currentMsg + pocket.get(i).getName() + ", " + pocket.get(i).getDescription() + "\n";
            }
        }
    }

    public void use()
    {
        if (currentRoom.getDescription().equals(metebelisThree.getDescription()))
        {
            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("scarf".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    if (!temp.isReusable())
                    {
                        pocket.remove(i);
                    }
                    currentMsg = "The player used the scarf to trip the approaching enemies.\n" +
                    "You can now leave the planet with the Metebelis Crystal.";
                    currentRoom.isCanPass(true);
                    count++;
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }
        }
        else if (currentRoom.getDescription().equals(zetaMinor.getDescription()))
        {
            //use yo-yo (optional)
            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("yo-yo".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    if (!temp.isReusable())
                    {
                        pocket.remove(i);
                    }
                    currentMsg = "The player used the yo-yo to test the gravity of this planet.\n" +
                    "It is much less than expected...";
                    count++;
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }
        }
        else if (currentRoom.getDescription().equals(karn.getDescription()))
        {
            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("sonic".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    if (!temp.isReusable())
                    {
                        pocket.remove(i);
                    }
                    karn.setDescription("Karn, a neighboring planet of Gallifrey.  It's one planet closer to the twin suns.\n");
                    currentMsg = "The player used the sonic screwdriver to unlock the door\n" +
                    "to the chamber he or she was locked in upon arrival.\n";
                    currentRoom.isCanPass(true);
                    count++;
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }
        }
        else if (currentRoom.getDescription().equals(sol3.getDescription()))
        {
            int count = 0;
            for (int i = 0; i < currentRoom.getItems().size(); i++)
            {
                if (currentRoom.getItems().get(i).getName().toLowerCase().contains("bessie".toLowerCase()))
                {
                    currentMsg = "The player drives 10 miles in Bessie to a store in order to find some jelly babies.\n" +
                    "(you can now pick up the Jelly Babies)";
                    bessie.setUsed(true);
                    count++;
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }
            //use bessie to get jelly baby
        }
        else if (currentRoom.getDescription().equals(stormcage.getDescription()))
        {
            //use jelly baby to get psychic paper
            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("jelly".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    currentMsg = "The player offered a guard a Jelly Baby.\n" +
                    "While he was distracted, a certain prisioner slips you the Psychic Paper.";
                    count++;
                    jellyBaby.setUsed(true);
                    pocket.add(psychicPaper);
                    pocket.remove(jellyBaby);
                    currentRoom.removeItem(0);
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }
        }
        else if (currentRoom.getDescription().equals(obsidian.getDescription()))
        {
            //use psychic paper to get nanogenes
            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("psychic".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    if (!temp.isReusable())
                    {
                        pocket.remove(i);
                    }
                    currentMsg = "By the light of a small fire, the player shows a scientist\n" +
                    "the Psycic Paper.  \"I'm part of the Interspace authority on development \n" +
                    " of new medical technology and I need to audit your nanogene experiments.\n" +
                    "you tell him.  He examines the Psycic Paper for a second, then offers you the\n" +
                    "nanogenes.";
                    count++;
                    psychicPaper.setUsed(true);
                    obsidian.setDescription("Obsidian, a planet of perpetual darkness.");
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }
        }
        else if (currentRoom.getDescription().equals(phaesterOsiris.getDescription()))
        {
            //use crystal to get brain teaser
            //use nanogenes if you fail

            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("crystal".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    if (!temp.isReusable())
                    {
                        pocket.remove(i);
                    }
                    count++;

                    String item = JOptionPane.showInputDialog(null, 
                            "The player enhances his or her mental capacities using the crystal.\n" +
                            "The Osirians recognize an acceptable level of intelligence and offer the player a riddle.\n" +
                            "If it is answered correctly, the player can pass.  If it is not, the player is attacked.\n" +
                            "If the player posses nanogenes, he or she may repair his or herself once and take another\n" +
                            "guess.\n\n"   + 
                            "Your riddle is this: \n" +
                            "There are two men standing at a fork in the road, one path leads to your \n" +
                            "destination, the other to your destruction.  One of the men can only \n" +
                            "speak the truth, the other only lies, with only asking one question, \n" +
                            "how do you determine which path leads to your destination?\n\n" +
                            "type 'a' for: \"Ask each which is the correct path.  Take the other path.\"\n" +
                            "type 'b' for: \"Ask each which is the correct path.  Take the path they indicate.\"\n" +
                            "type 'c' for: \"Ask each which path the other would chose. Take that path.\"\n" +
                            "type 'd' for: \"Ask each which path the other would chose. Take the other path.\"\n");

                    if (item.toLowerCase().equals("a") || item.toLowerCase().equals("d"))
                    {
                        currentRoom.isCanPass(true);
                        currentMsg = "Congratulations!  You are deemed worth of the Radioactivity Protection Suit";
                    }
                    else 
                    {
                        riddleCount++;
                        int count2 = 0;
                        for (int j = 0; j < pocket.size(); j++)
                        {
                            if (pocket.get(j).getName().toLowerCase().contains("nano".toLowerCase()))
                            {
                                Item temp2 = pocket.get(j);
                                if (!temp2.isReusable())
                                {
                                    pocket.remove(j);
                                    count2++;
                                    riddleCount--;
                                    currentMsg = "You have answered incorrectly.  Luckily, you were carrying nanogenes\n" +
                                    "which saved your life.  You may try one more time.";
                                }
                            }

                        }
                        if (count2 == 0)
                        {
                            gameOver();
                        }
                    }
                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }

        }

        else if (currentRoom.getDescription().equals(skaro.getDescription()))
        {
            //use radioactive protection suit
            int count = 0;
            for (int i = 0; i < pocket.size(); i++)
            {
                if (pocket.get(i).getName().toLowerCase().contains("radio".toLowerCase()))
                {
                    Item temp = pocket.get(i);
                    currentMsg = "The player put on the suit and is now protected from radiation.  He or \n" +
                    "she may now enter the mines and retrieve the Dalekanium.";
                    radioactiveSuit.setUsed(true);
                    count++;

                }
            }
            if (count == 0)
            {
                currentMsg = "You do not have the item which is needed for this planet.";
            }

        }
    }
    
    public static void main()
    {
        Game g = new Game();
        System.out.println(g.getMessage());
        g.take();
        System.out.println(g.getMessage());
        g.move("north");
        System.out.println(g.getMessage());
        g.use();
        System.out.println(g.getMessage());
        g.take();
        System.out.println(g.getMessage());
        g.move("west");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.take("scarf");
        System.out.println(g.getMessage());
        g.move("north");
        System.out.println(g.getMessage());
        g.move("west");
        System.out.println(g.getMessage());
        g.use();
        System.out.println(g.getMessage());
        g.take();
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        System.out.println("type \"bessie\"");
        g.use();
        System.out.println(g.getMessage());
        g.take("jelly");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.use();
        System.out.println(g.getMessage());
        g.take("psy");
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.use();
        System.out.println(g.getMessage());
        g.move("north");
        System.out.println(g.getMessage());
        System.out.println("select a or d on the next step");
        g.use();
        System.out.println(g.getMessage());
        g.take();
        System.out.println(g.getMessage());
        g.move("west");
        System.out.println(g.getMessage());
        g.move("west");
        System.out.println(g.getMessage());
        g.move("west");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.move("west");
        System.out.println(g.getMessage());
        g.use();
        System.out.println(g.getMessage());
        g.take();
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.move("north");
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.gameOver();
        System.out.println(g.getMessage());
    }
}
