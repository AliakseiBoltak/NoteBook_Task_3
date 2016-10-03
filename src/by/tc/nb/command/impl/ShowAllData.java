package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowDataRequest;
import by.tc.nb.bean.ShowDataResponse;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;



public class ShowAllData implements Command {
	
	 @Override
	    public Response execute(Request request) throws CommandException {
	        ShowDataRequest req = null;

	        if(request instanceof ShowDataRequest){
	            req = (ShowDataRequest)request;
	        }else{
	            throw new CommandException("ILLEGAL COMMAND");
	        }

	        ShowDataResponse response = new ShowDataResponse();
	        response.setNotes(NoteBookProvider.getInstance().getNoteBook().getNotes());
	        response.setErrorStatus(false);
	        response.setResultMessage("SUCCESS");

	        return response;
	    }
	
	
	
	
}
