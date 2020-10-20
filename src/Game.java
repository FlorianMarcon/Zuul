/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * To play this game, create an instance of this class and call the "play"
 * method.
 *
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    private static Game instance = null;

    private Parser parser;
    private Room currentRoom;
    private ItemFactory itemFactory;
    private final int MAX_WEIGHT = 10;

    private boolean finished = false;

    /**
     * Create the game and initialise its internal map.
     */
    private Game() {
        createRooms();
        parser = new Parser();
        itemFactory = new ItemFactory(MAX_WEIGHT);
    }

    public static Game getInstance() {
        if (Game.instance == null)
            Game.instance = new Game();
        return Game.instance;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.addExit(ECardinality.EAST.toString(), theatre);
        outside.addExit(ECardinality.SOUTH.toString(), lab);
        outside.addExit(ECardinality.WEST.toString(), pub);
        outside.addItem(new Item("notebook", 2));
        theatre.addExit(ECardinality.WEST.toString(), outside);
        pub.addExit(ECardinality.EAST.toString(), outside);
        lab.addExit(ECardinality.NORTH.toString(), outside);
        lab.addExit(ECardinality.EAST.toString(), office);
        office.addExit(ECardinality.WEST.toString(), lab);

        currentRoom = outside;  // start game outside
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        while (!this.finished) {
            Command command = parser.getCommand();
            processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        this.look();
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     */
    private void processCommand(Command command) {
        AGameCommand execution = CommandFactory.getCommand(command);

        if (execution == null)
            System.out.println("I don't know what you mean...");
        else
            execution.execute();

        // String commandWord = command.getCommandWord();
        // if (commandWord.equals("help")) {
        //     printHelp();
        // } else if (commandWord.equals("go")) {
        //     goRoom(command);
        // } else if (commandWord.equals("quit")) {
        //     quit(command);
        // } else if (commandWord.equals("look")) {
        //     look();
        // } else if (commandWord.equals("take")) {
        //     take(command);
        // } else if (commandWord.equals("drop")) {
        //     drop(command);
        // } else if (commandWord.equals("give")) {
        //     give(command);
        // }
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            this.look();
        }
    }

    /**
     * "Look" was entered. Report what the player can see in the room
     */
    public void look() {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        currentRoom.getExits().forEach((destination, room) -> System.out.print(destination + " "));
        System.out.println();
        System.out.println("Items: ");
        currentRoom.getItems().forEach(item -> System.out.println(" - " + item.getName() + '(' + item.getWeight() + ')'));
    }

    /**
     * Set finished variable
     * @param finished
     */
    public void setFinish(boolean finished) {
        this.finished = finished;
    }

    public ItemFactory getItemFactory() {
        return this.itemFactory;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
