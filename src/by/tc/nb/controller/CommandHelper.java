package by.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.AddNewNote;
import by.tc.nb.command.impl.ClearNoteBook;
import by.tc.nb.command.impl.FindNotesByContent;
import by.tc.nb.command.impl.FindNotesByDate;
import by.tc.nb.command.impl.ReadDataFromFile;
import by.tc.nb.command.impl.ShowAllData;
import by.tc.nb.command.impl.WriteDataInFile;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_NOTE", new AddNewNote());
		commands.put("FIND_NOTES_BY_CONTENT", new FindNotesByContent());
		commands.put("FIND_NOTES_BY_DATE", new FindNotesByDate());
		commands.put("SHOW_ALL_NOTES", (Command) new ShowAllData());
		commands.put("CLEAR_NOTEBOOK", new ClearNoteBook());
		commands.put("WRITE_NOTEBOOK_IN_FILE", new WriteDataInFile());
		commands.put("READ_NOTEBOOK_FROM_FILE", new ReadDataFromFile());
	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}
