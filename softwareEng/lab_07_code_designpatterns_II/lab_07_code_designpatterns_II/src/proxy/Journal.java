package proxy;

public interface Journal {
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getEditor();
	public void setEditor(String editor);
	
	public String getPublicationDate();
	public void setPublicationDate(String publicationDate);
	
	public int getISBN();
	public void setISBN(int ISBN);
	
	public int getPages();
	public void setPages(int pages);
	
	public String getSummmary();
	public void setSummary(String summmary);

}
