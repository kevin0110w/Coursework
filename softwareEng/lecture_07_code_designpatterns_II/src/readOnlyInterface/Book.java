package readOnlyInterface;

public class Book implements ReadOnlyBook {
	private String title;
	private String author;
	private String publicationDate;
	private int ISBN;
	private int pages;
	private String summary;
	
	public Book(String title, String author, String publicationDate, int iSBN,
			int pages, String summary) {
		super();
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		ISBN = iSBN;
		this.pages = pages;
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
