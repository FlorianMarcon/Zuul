import java.util.HashMap;

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
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room extends ItemFactory
{
    private String description;
    
    private HashMap<String, Room> exits = new HashMap<>();
    
    // Characters in the room
    private String character;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Set an exit
     * @param direction string representing the direction to the new room  
     * @param room Room
     */
    public void addExit(String direction, Room room) {
        this.exits.put(direction, room);
    }

    /**
     * Get room corresponding the exit  
     * @param direction Direction to look for
     * @return Room or null
     */
    public Room getExit(String direction) {
        return this.exits.get(direction);
    }

    /**
     * Get all exits
     * 
     * @return Hasmap of direction and exits
     */
    public HashMap<String, Room>    getExits() {
        return this.exits;
    }

    /**
     * Check if an exit exists
     * @param direction Direction to check
     * @return True if exist, False otherwise
     */
    public Boolean isExistingExit(String direction) {
        return (this.exits.get(direction) != null);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return character
     */
    public String getCharacter() {
        return this.character;
    }
}
