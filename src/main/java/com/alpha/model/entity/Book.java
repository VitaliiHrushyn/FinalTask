package com.alpha.model.entity;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int countPages;
	private double price;

	public Book() {}

	public Book(String title, String author, String publisher, int year, int countPages, double price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.countPages = countPages;
		this.price = price;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCountPages() {
		return countPages;
	}

	public void setCountPages(int countPages) {
		this.countPages = countPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", year=" + year +
				", countPages=" + countPages +
				", price=" + price +
				'}';
	}
}
