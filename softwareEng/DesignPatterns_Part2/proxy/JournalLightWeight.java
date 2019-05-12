package proxy;

public class JournalLightWeight implements Journal {
	
	private String title;
	private String editor;
	private String publicationDate;
	private int ISBN;
	private int pages;
	private String summary;
	boolean fetched = false;
	
	public JournalLightWeight() {
		
	}

	protected void FetchJournal() {
		//  Do something to get a Journal's Details
		
	}
	
	public String getTitle() {
		if (!this.fetched) {
			this.FetchJournal();
		}
		return this.title;
	}

	public void setTitle(String title) {
		if (! this.fetched) {
			this.FetchJournal();
		}
		
		this.title = title;
	}

	//  ETC for remaining methods
	
	public String getEditor() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setEditor(String editor) {
		// TODO Auto-generated method stub
		
	}


	public String getPublicationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPublicationDate(String publicationDate) {
		// TODO Auto-generated method stub
		
	}


	public int getISBN() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setISBN(int isbn) {
		// TODO Auto-generated method stub
		
	}


	public int getPages() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setPages(int pages) {
		// TODO Auto-generated method stub
		
	}


	public String getSummmary() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSummary(String summary) {
		// TODO Auto-generated method stub
		
	}


}
