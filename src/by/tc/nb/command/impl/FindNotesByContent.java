package by.tc.nb.command.impl;
import java.util.ArrayList;
import by.tc.nb.bean.FindNotesByContentRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowDataResponse;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class FindNotesByContent implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		FindNotesByContentRequest req = null;

		if (request instanceof FindNotesByContentRequest) {
			req = (FindNotesByContentRequest) request;
		} else {
			throw new CommandException("INVALID COMMAND");
		}

		String content = req.getContent();
		ShowDataResponse response = new ShowDataResponse();

		ArrayList<Note> result = new ArrayList<Note>();
		for (Note tmp : NoteBookProvider.getInstance().getNoteBook().getNotes()) {
			if (tmp.getNote().contains(content.trim()) && !content.equals("")) {
				result.add(tmp);
			}
		}
		response.setNotes(result);
		response.setErrorStatus(false);
		response.setResultMessage("NOTE HAS BEEN FOUND");
		return response;
	}
}
