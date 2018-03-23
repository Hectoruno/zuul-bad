import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item;
    private ArrayList <Item> itemList;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        itemList = new ArrayList<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room nextRoom)
    {
        exits.put(direction, nextRoom);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit(String direction)
    {

        return exits.get(direction);
    }

    public String getExitString()
    {
        Set <String> namesOfDirection = exits.keySet();
        String exitsDescription = "";

        for(String direction : namesOfDirection) {
            exitsDescription += direction + " ";
        }

        return exitsDescription;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + "objetos: " + infoObjHabitacion()+ ".\n" + "Tienes estas posibilidades " + getExitString();

    }
    
    /**
     * Añade más de un objeto
     */

    public void addItem(String itemDescription, int itemWeigh)
    {
        Item it= new Item (itemDescription, itemWeigh);
        itemList.add(it);        
    }

    /**
     * Muestra la informacion de los obejtos de cada habitacion
     */
    public String infoObjHabitacion(){
        String infoObjHabitacion="";
        if(itemList.size() <= 0){
            infoObjHabitacion="No hay objetos en esta ubicacion";
        } else {
            for(Item objetoDeLaLista : itemList)
            {
                infoObjHabitacion += objetoDeLaLista.getNombre();
            }
        }
        return infoObjHabitacion;
    }
} 