public class LookCommand extends AGameCommand {

    public LookCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        this.game.look();
    }
}
