package com.shopnow.dto;

public class Book {
	 private String title;
	    private String author;
	    private String isbn;
	    private String publishedDate;
	    private float price;
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Book(String title, String author, String isbn, String publishedDate, float price) {
			super();
			this.title = title;
			this.author = author;
			this.isbn = isbn;
			this.publishedDate = publishedDate;
			this.price = price;
		}
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return this.author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getIsbn() {
			return this.isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getPublishedDate() {
			return this.publishedDate;
		}
		public void setPublishedDate(String publishedDate) {
			this.publishedDate = publishedDate;
		}
		public float getPrice() {
			return this.price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Book [title=" + this.title + ", author=" + this.author + ", isbn=" + this.isbn
					+ ", publishedDate=" + this.publishedDate + ", price=" + this.price + "]";
		}
		
		
	 
}
