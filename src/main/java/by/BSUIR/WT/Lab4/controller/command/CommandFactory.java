package by.BSUIR.WT.Lab4.controller.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import by.BSUIR.WT.Lab4.controller.command.impl.CompleteOrderCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.ConfirmAddingApartmentCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.ConfirmChangingApartmentStatusCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.ConfirmUserOrderCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.DeleteUserOrderCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.LogInCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.LogOutCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.LogUpCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.DefaultCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToAddApartmentCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToAddUserOrderCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToCatalogCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToChangeApartmentStatusCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToContactsCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToLogInCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToLogUpCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToMainCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToMyOrdersCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToProfileCommand;
import by.BSUIR.WT.Lab4.controller.command.impl.transition.GoToViewOrdersCommand;

public class CommandFactory {

	private static final CommandFactory instance = new CommandFactory();
	private static final Map<String, Command> commands = new HashMap<>();
	
	private CommandFactory() {
        commands.put(CommandName.DEFAULT_COMMAND, 							new DefaultCommand());
        commands.put(CommandName.MAIN_COMMAND, 								new GoToMainCommand());
        commands.put(CommandName.PROFILE_COMMAND, 							new GoToProfileCommand());
        commands.put(CommandName.REGISTRATION_COMMAND, 						new LogUpCommand());
        commands.put(CommandName.LOG_IN_COMMAND, 							new GoToLogInCommand());
        commands.put(CommandName.CONTACTS_COMMAND, 							new GoToContactsCommand());
        commands.put(CommandName.CATALOG_COMMAND, 							new GoToCatalogCommand());
        commands.put(CommandName.CHECK_LOGIN_COMMAND, 						new LogInCommand());
        commands.put(CommandName.LOG_OUT_COMMAND, 							new LogOutCommand());
        commands.put(CommandName.LOG_UP_COMMAND, 							new GoToLogUpCommand());
        commands.put(CommandName.VIEW_ORDERS_COMMAND, 						new GoToViewOrdersCommand());
        commands.put(CommandName.DELETE_USER_ORDER_COMMAND, 				new DeleteUserOrderCommand());
        commands.put(CommandName.ADD_APARTMENT_COMMAND,						new GoToAddApartmentCommand());
        commands.put(CommandName.CONFIRM_ADDING_APARTMENT_COMMAND, 			new ConfirmAddingApartmentCommand());
        commands.put(CommandName.MY_ORDERS_COMMAND, 						new GoToMyOrdersCommand());
        commands.put(CommandName.CONFIRM_USER_ORDER_COMMAND, 				new ConfirmUserOrderCommand());
        commands.put(CommandName.ADD_USER_ORDER,							new GoToAddUserOrderCommand());
        commands.put(CommandName.COMPLETE_USER_ORDER_COMMAND, 				new CompleteOrderCommand());
        commands.put(CommandName.EDIT_APARTMENT_STATUS, 					new GoToChangeApartmentStatusCommand());
        commands.put(CommandName.CONFIRM_CHANGING_APARTMENT_STATUS_COMMAND, new ConfirmChangingApartmentStatusCommand());
	}
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public Command getCommand(String name) {
		return Optional.ofNullable(commands.get(name)).orElse(commands.get(CommandName.DEFAULT_COMMAND));
	}
}
