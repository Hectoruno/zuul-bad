import java.util.Stack;
/**
 * 
 */
public class Player
{
    private Stack<Room> roomBack;
    private Room currentRoom;

    /**
     * Constructor for objects of class Player
     */
    public Player(Room entrada)
    {
        roomBack = new Stack<>();
        currentRoom = entrada;
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("�Donde quieres ir?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("No hay ninguna localidad aqui");
        }
        else {
            roomBack.push(currentRoom);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            System.out.println("\n");
        }
    }

    public void look() 
    {
        System.out.println(currentRoom.getLongDescription());

    }

    public void back() 
    {
        if (!roomBack.empty()) {
            currentRoom = roomBack.pop();
        } 
    }

    public void eat() 
    {
        System.out.println("You have eaten now and you are not hungry any more");

    }   

} 