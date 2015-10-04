package NexTask;

import java.util.Scanner;


public class Controller {
	private static final int INDEX_OF_CMD_NAME = 0;
	private Scanner scanner;
	private Logic logic;
	//private Storage storage;
	private static UI ui;
	private CommandParser parser;
	
	enum OPERATION {
		ADD, COMPLETED, DELETE, EDIT, UNDO, SEARCH, ARCHIVE, DISPLAY, SAVE, INVALID
	};
	
	public static void main(String[] args) {
		Controller program = new Controller();
		program.startProgram();
	}
	
	public Controller() {
		scanner = new Scanner(System.in);
		logic = new Logic();
	//	storage = new Storage();
		parser = new CommandParser();
		ui = new UI();
	}
	
	public void startProgram() {
		ui.displayWelcomeMessage();
		this.run();
	}
	
	
	public void run() {
		while (true) {
			ui.printCommandPrompt();
			Command newCommand = this.getUserCommand();
			String feedback = logic.executeUserCommand(newCommand);
			//ui.displayMessage(feedback);
		//	storage.updateOutputFile();
		}
	}
	
	public Command getUserCommand() {
		String input = this.getUserInput();
		return parser.parse(input);
	}
	


	public String getUserInput() {
		String userInput = "";

		if (this.scanner.hasNextLine()) {
			userInput = this.scanner.nextLine();
		} else {
			System.exit(0);
		}
		return userInput;
	}

}
