public class DropCommand extends AGameCommand {

    public DropCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("Drop what?");
            return;
        }

        String itemName = command.getSecondWord();
        Item item = game.getItemFactory().getItem(itemName);
        if (item == null) {
            System.out.println("Drop what?");
        } else {
            game.getItemFactory().removeItem(itemName);
            game.getCurrentRoom().addItem(item);
        }
    }
}
