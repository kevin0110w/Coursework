package immutable;

public class Magazine {
	private String title;
	private String editor;
	private String publicationDate;
	private int ISBN;
	private int pages;
	private String summary;
	
	public Magazine(String title, String editor, String publicationDate,
			int iSBN, int pages, String summary) {
		super();
		this.title = title;
		this.editor = editor;
		this.publicationDate = publicationDate;
		ISBN = iSBN;
		this.pages = pages;
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public Magazine setTitle(String title) {
		return new Magazine(title, this.editor,this.publicationDate, this.ISBN, this.pages, this.summary);
	}

	public String getEditor() {
		return editor;
	}

	public Magazine setEditor(String editor) {
		return new Magazine(this.title, editor,this.publicationDate, this.ISBN, this.pages, this.summary);

	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public Magazine setPublicationDate(String publicationDate) {
		return new Magazine(this.title, this.editor,publicationDate, this.ISBN, this.pages, this.summary);
	}

	public int getISBN() {
		return ISBN;
	}

	public Magazine setISBN(int iSBN) {
		return new Magazine(this.title, this.editor,this.publicationDate, ISBN, this.pages, this.summary);

	}

	public int getPages() {
		return pages;
	}

	public Magazine setPages(int pages) {
		return new Magazine(this.title, this.editor,this.publicationDate, this.ISBN, pages, this.summary);
	}

	public String getSummary() {
		return summary;
	}

	public Magazine setSummary(String summary) {
		return new Magazine(this.title, this.editor,this.publicationDate, this.ISBN, this.pages, summary);
	}
	
	
}
