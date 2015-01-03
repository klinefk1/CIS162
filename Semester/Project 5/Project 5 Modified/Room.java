
/**
 * A location within the map.
 * 
 * Katherine Klinefelter
 * 2014
 */
import java.util.*;
public class Room
{
    // instance variables - replace the example below with your own
    private String description;
    private ArrayList<Item> items;
    private HashMap<String, Room> neighbors;
    private boolean canPass;

    //constructor for no items in room
    public Room(String pDescription, boolean b)
    {
        description = pDescription;
        items = new ArrayList<Item>();
        neighbors = new HashMap<String, Room>();
        canPass = b;
    }

    //constructor for one item in room
    public Room(String pDescription, Item pItem, boolean b)
    {
        description = pDescription;
        items = new ArrayList<Item>();
        items.add(pItem);
        neighbors = new HashMap<String, Room>();
        canPass = b;
    }

    //constructor for two items in room (max for this game)
    public Room(String pDescription, Item pItem, Item pItem2, boolean b)
    {
        description = pDescription;
        items = new ArrayList<Item>();        
        items.add(pItem);
        items.add(pItem2);
        neighbors = new HashMap<String, Room>();
        canPass = b;
    }

    //constructor for multiple items in room
    public Room(String pDescription, ArrayList<Item> pItems, boolean b)
    {
        description = pDescription;
        items = pItems;
        neighbors = new HashMap<String, Room>();
        canPass = b;
    }

    //returns item description
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String s)
    {
        description = s;
    }
    //returns the items stored in room
    public ArrayList<Item> getItems()
    {
        return items;
    }
    
    //returns an individual item
    public Item getItem(int n)
    {
        if (items.size() > 0)
        {
            return items.get(n);
        }
        return null;
    }

    public Item getItem(String s)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(s))
            {
                return items.get(i);
            }
        }
        return null;
    }

    //adds an item to the room
    public void addItem(Item i)
    {
        items.add(i);
    }

    //true if there is at least one item in the room
    public boolean hasItem()
    {
        return items.size() != 0;
    }

    //removes the item at the given index and returns it
    public Item removeItem(int n)
    {
        if (items.get(n) != null)
        {
            Item temp = items.get(n);
            items.remove(n);
            return temp;
        }
        else
        {
            System.out.println("That item doesn't exist");
            return null;
        }        
    }

    public Item removeItem(String s)
    {
        Item temp = null;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().contains(s))
            {
                temp = items.get(i);
                items.remove(i);
                return temp;   
            }
        }
        
        return temp;
    }

    public void addNeighbor(String pDirection, Room r)
    {
        neighbors.put(pDirection, r);
    }

    public Room getNeighbor (String pDirection)
    {
        Room result = neighbors.get(pDirection);
        return result;
    }
    
    public void isCanPass(boolean set)
    {
        canPass = set;
    }
    
    public boolean getCanPass()
    {
        return canPass;
    }

    public String getLongDescription()
    {
        String temp;
        temp = "You are on " + description;
        if(items.size() > 0)
        {
            for (int i = 0; i < items.size(); i++)
            {
                temp = temp + "\nYou see " + items.get(i).getName() +".";
            }
        }
        return temp;
    }

}
