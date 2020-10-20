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
    
    // Exits from the room
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    
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
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return Get room located at north
     */
    public Room getNorthExit() {
        return this.northExit;
    }

    /**
     * @return Get room located at south
     */
    public Room getSouthExit() {
        return this.southExit;
    }

    /**
     * @return Get room located at east
     */
    public Room getEastExit() {
        return this.eastExit;
    }

    /**
     * @return Get room located at wet
     */
    public Room getWestExit() {
        return this.westExit;
    }

    /**
     * @return character
     */
    public String getCharacter() {
        return this.character;
    }
}
