package by.tc.nb.bean;


public class ReadDataFromFileRequest  extends Request  {
	
	private String filePath;

    public ReadDataFromFileRequest() {

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
