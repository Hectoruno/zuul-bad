/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room ultimaRoom;
    private Player jugador;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        jugador = new Player(createRooms());
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private Room createRooms()
    {
        Room entrada, salon, dormitorio, cocina, bodega, despacho, jardin;

        // create the rooms
        entrada = new Room("en la entrada del palacio");
        salon = new Room("en el salon");
        dormitorio = new Room("en el dormitorio");
        cocina = new Room("en la cocina");
        bodega = new Room("en la bodega");
        despacho = new Room("en el despacho");
        jardin = new Room("en el jardin");

        // initialise room exits
        entrada.setExit("north", salon);
        entrada.setExit("northWest", cocina);

        salon.setExit("east", dormitorio);
        salon.setExit("south", entrada);
        salon.setExit("west", cocina);
        salon.setExit("northWest", bodega);

        dormitorio.setExit("west", salon);

        cocina.setExit("north", bodega);
        cocina.setExit("east", salon);

        bodega.setExit("north", despacho);
        bodega.setExit("south", cocina);
        bodega.setExit("southEast", salon);
        bodega.setExit("northWest", jardin);

        despacho.setExit("south", bodega);
        despacho.setExit("west", jardin);

        jardin.setExit("east", despacho);
        jardin.setExit("southEast", bodega);

        entrada.addItem ("puerta",50);
        return entrada;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println("\n");
        jugador.look();
        System.out.println("\n");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            jugador.goRoom(command);
        }
        else if (commandWord.equals("look")) {
            jugador.look();
        }
        else if (commandWord.equals("eat")) {
            jugador.eat();
        }
        else if (commandWord.equals("back")) {
            jugador.back();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}