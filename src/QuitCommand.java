public class QuitCommand extends AGameCommand {

    public QuitCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        if (command.hasSecondWord())
            System.out.println("Quit what?");
        else
            this.game.setFinish(true);
    }
}
