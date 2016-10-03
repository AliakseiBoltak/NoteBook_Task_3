package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearNoteBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class ClearNoteBook implements Command{
	
	 @Override
	    public Response execute(Request request) throws CommandException {
	        ClearNoteBookRequest req = null;

	        if(request instanceof ClearNoteBookRequest){
	            req = (ClearNoteBookRequest)request;
	        }else{
	            throw new CommandException("WRONG REQUEST");
	        }

	        NoteBookProvider.getInstance().getNoteBook().clear();

	        Response response = new Response();
	        response.setErrorStatus(false);
	        response.setResultMessage("NOTEBOOK HAS BEEN CLEARED");

	        return response;
	    }

}
