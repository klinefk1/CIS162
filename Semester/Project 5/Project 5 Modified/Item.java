
/**
 * An item which a character can pick up, drop, switch, or use.
 * 
 * Katherine Klinefelter
 * 2014
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int weight;
    private boolean reusable;
    private boolean used;

    /**
     * Constructor for objects of class Item
     */
    public Item(String n, String d, int w, boolean r)
    {
        name = n;
        description = d;
        weight = w;
        reusable = r;
        used = false;
    }

    //returns the name
    public String getName()
    {
        return name;
    }
    
    //returns the description of the item
    public String getDescription()
    {
        return description;
    }
    
    //returns the weight of an object
    public int getWeight()
    {
        return weight;
    }
    
    //sets the name
    public void setName(String n)
    {
        name = n;
    }
    
    //sets description
    public void setDescription(String d)
    {
        description = d;
    }
    
    //sets the weight
    public void setWeight(int w)
    {
        weight = w;
    }
    
    //sets reusuablility
    public void setReusable(boolean b)
    {
        reusable = b;
    }
    
    //true if item is reusable
    public boolean isReusable()
    {
        return reusable;
    }
    
    public void setUsed(boolean b)
    {
        used = b;
    }
    
    public boolean getUsed()
    {
        return used;
    }
}
