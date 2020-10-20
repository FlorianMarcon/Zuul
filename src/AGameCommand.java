public abstract class AGameCommand {
    
    protected Game game;

    protected Command command;

    /**
     * Construction of the object AGameCommand
     * @param game
     */
    public AGameCommand(Command command) {
        this.game = Game.getInstance();
        this.command = command;
    }

    /**
     * Method to implement
     */
    public abstract void execute();
}
