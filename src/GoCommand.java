public class GoCommand extends AGameCommand {

    public GoCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = game.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            game.setCurrentRoom(nextRoom);
            game.look();
        }
    }
}
