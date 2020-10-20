public class TakeCommand extends AGameCommand {

    public TakeCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }

        String itemName = command.getSecondWord();
        Item item = game.getCurrentRoom().getItem(itemName);
        if (item == null) {
            // The item is not in the room
            System.out.println("No " + itemName + " in the room");
            return;
        }
        // OK we can pick it up
        game.getCurrentRoom().removeItem(itemName);
        try {
            game.getItemFactory().addItem(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
