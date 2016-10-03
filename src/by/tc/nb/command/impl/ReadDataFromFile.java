package by.tc.nb.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.tc.nb.bean.ReadDataFromFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class ReadDataFromFile implements Command {

	@Override
	public Response execute(Request request) throws CommandException, IOException {

		ReadDataFromFileRequest req = null;

		if (request instanceof ReadDataFromFileRequest) {
			req = (ReadDataFromFileRequest) request;
		} else {
			throw new CommandException("WRONG REQUEST");
		}

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		try {
			File myfile = new File(req.getFilePath());
			FileReader fr = new FileReader(myfile);
			BufferedReader reader = new BufferedReader(fr);
			String line = null;
			String note;
			String date;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|");
				date = temp[0].trim();
				note = temp[1].trim();
				Note n = new Note(note, date);
				noteBook.getNotes().add(n);
			}
		} catch (FileNotFoundException ex) {
		}

		Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("SUCCESS");

		return response;
	}

}
