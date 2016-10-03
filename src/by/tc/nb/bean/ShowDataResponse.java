package by.tc.nb.bean;
import java.util.List;
import by.tc.nb.bean.entity.Note;

public class ShowDataResponse extends Response  {
	
	
	 private List<Note> notes = null;

	 public ShowDataResponse() {

	    } 
	 
	    public List<Note> getNotes() {
	        return notes;
	    }

	    public void setNotes(List<Note> notes) {
	        this.notes = notes;
	    }

}
