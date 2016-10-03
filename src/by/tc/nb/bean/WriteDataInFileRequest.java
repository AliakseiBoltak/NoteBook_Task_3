package by.tc.nb.bean;


public class WriteDataInFileRequest  extends Request {
	
	private String filePath;

    public WriteDataInFileRequest() {

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
	
}
