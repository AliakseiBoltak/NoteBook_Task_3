package by.tc.nb.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
	
	List<Note> notes;
	
	public NoteBook() {
		notes = new ArrayList<>();
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


	public void add(Note newNote) {
		this.notes.add(newNote);   
	}

	public void clear() {
		if(this.notes.size() != 0) {
			this.notes.clear();
		}
	}
	
	public void fillNoteBook(List<Note> listForAdd) {
		if (notes.size() == 0) {
			this.notes = new ArrayList<>(listForAdd);
		} else {
			listForAdd.stream().forEach((element) -> notes.add(element));
		}
	}

	@Override
	public String toString() {
		return "NoteBook [notes=" + notes + "]";
	}
}
