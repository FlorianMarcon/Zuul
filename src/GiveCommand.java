public class GiveCommand extends AGameCommand {

    public GiveCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to give...
            System.out.println("Givwe what?");
            return;
        }
        if (!command.hasThirdWord()) {
            // if there is no third word, we don't to whom to give it...
            System.out.println("Give it to who?");
            return;
        }

        String itemName = command.getSecondWord();
        String whom = command.getThirdWord();

        if (!game.getCurrentRoom().getCharacter().equals(whom)) {
            // cannot give it if the chacter is not here
            System.out.println(whom + " is not in the room");
            return;
        }
        Item item = game.getItemFactory().getItem(itemName);
        if (item == null) {
            System.out.println("You don't have the " + itemName);
            return;
        }
        game.getItemFactory().removeItem(itemName);    }
}
