public class HelpCommand extends AGameCommand {

    public HelpCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help look take drop give");
    }
}
