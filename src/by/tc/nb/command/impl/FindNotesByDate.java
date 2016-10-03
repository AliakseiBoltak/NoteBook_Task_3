package by.tc.nb.command.impl;

import java.util.ArrayList;
import by.tc.nb.bean.FindNotesByDateRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowDataResponse;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class FindNotesByDate implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		FindNotesByDateRequest req = null;

		if (request instanceof FindNotesByDateRequest) {
			req = (FindNotesByDateRequest) request;
		} else {
			throw new CommandException("WRONG REQUEST");
		}

		ShowDataResponse response = new ShowDataResponse();

		ArrayList<Note> result = new ArrayList<Note>();

		String date = req.getDate();

		for (Note current : NoteBookProvider.getInstance().getNoteBook().getNotes()) {
			if (current.getDate().equals(date.trim())) {
				result.add(current);
			}
		}
		response.setNotes(result);
		response.setErrorStatus(false);
		response.setResultMessage("NOTE HAS BEEN FOUND");

		return response;
	}
}
