package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library
 */
public class Book {
	private String title;
	private String author;
	private String ISBN;
	private int yearPublished;
	
	/**
	 * Constructor for creating a new book
	 * 
	 * @param title
	 * @param author
	 * @param ISBN
	 * @param yearPublished
	 */
	public Book(String title, String author, String ISBN, int yearPublished) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.yearPublished = yearPublished;
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
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public int getYearPublished() {
		return yearPublished;
	}
	public void setyearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	
	/**
	 * Determines if 2 book objects are equal, if they have the same ISBN and author
	 */
	@Override
	public boolean equals (Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Book book = (Book) obj;
		return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
		
	}
	
	/**
	 * Returns a string representation of the book 
	 */
	@Override
	public String toString() {
		return "Title: " + title + ", Author: "+ author + ", ISBN: "+ ISBN + ", Year Published: " + yearPublished;
	}
	
	

}
