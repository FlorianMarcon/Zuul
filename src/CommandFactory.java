public class CommandFactory {
    
    public static AGameCommand getCommand(Command command) {
        String commandWord = command.getCommandWord();

        if ("help".equals(commandWord)) {
            return new HelpCommand(command);
        } else if ("go".equals(commandWord)) {
            return new GoCommand(command);
        } else if ("quit".equals(commandWord)) {
            return new QuitCommand(command);
        } else if ("look".equals(commandWord)) {
            return new LookCommand(command);
        } else if ("take".equals(commandWord)) {
            return new TakeCommand(command);
        } else if ("drop".equals(commandWord)) {
            return new DropCommand(command);
        } else if ("give".equals(commandWord)) {
            return new GiveCommand(command);
        }
        return null;
    }
}
