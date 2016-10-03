package by.tc.nb.command.impl;

import java.io.FileWriter;
import java.io.IOException;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.WriteDataInFileRequest;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class WriteDataInFile implements Command{
	
	
	 @Override
	    public Response execute(Request request) throws CommandException , IOException  {
		 

	        WriteDataInFileRequest req = null;

	        if (request instanceof  WriteDataInFileRequest) {
	            req = (WriteDataInFileRequest) request;
	        } else {
	            throw new CommandException("Wrong request");
	        }

	        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
	        
	        String path= req.getFilePath();
	        
	        try (FileWriter writer = new FileWriter(path, true)) {
	            for (Note i : noteBook.getNotes()) {
	                writer.write(i.getDate()  + " | " + i.getNote() + "\r\n");
	                writer.flush();
	            }
	        } catch (IOException ex) {
	            System.out.println("INCORRECT PATH");
	        }

	        Response response = new Response();
	        response.setErrorStatus(false);
	        response.setResultMessage("SUCCESS");

	        return response;
	 }
}
