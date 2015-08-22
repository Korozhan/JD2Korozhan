package by.academy;

import java.util.HashMap;

public class CommandFactory {

	private HashMap<String, Command> commands;
	private static CommandFactory instance;
	
	private CommandFactory() {
		commands = new HashMap<String, Command>();
		
		// create commands and set mapping
		commands.put("user_login", new UserLoginCommand());
		commands.put("admin_login", new AdminLoginCommand());
		commands.put("create_user", new CreateUserCommand());
		commands.put("update_users", new UpdateUsersCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("find_train", new FindCarCommand());
	}
	
	public static synchronized CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		
		return instance;
	}
	
	public Command getCommand(String id) {
		return commands.get(id);
	}
}
