package com.alpha.controller;

import com.alpha.controller.exception.*;
import com.alpha.model.BookFileDAO;
import com.alpha.model.ServiceBooks;
import com.alpha.view.BooksView;
import com.alpha.view.InputDataView;
import org.apache.log4j.Logger;

import java.io.IOException;

import static com.alpha.common.Constants.*;

public class BooksController {
	private static final Logger logger = Logger.getLogger(BooksController.class);

	private BooksView printBooks;
	private ServiceBooks serviceBooks;
	private InputDataView inputDataView;

	public BooksController() {
		this.printBooks = new BooksView();
		try {
			this.serviceBooks = new ServiceBooks(new BookFileDAO());
		} catch (IOException e) {
			logger.fatal("No source of books found", e);
			e.printStackTrace();
			printBooks.printMessage("No source of books found, application closed");
			System.exit(0);
		}
		this.inputDataView = new InputDataView(printBooks);
		logger.debug("Books are loaded");
	}

	public void execute() throws PriceValidationException, InputStringValidationException, InputIntValidationException {
		while (true) {
			System.out.println();

			int menuItem = inputDataView.inputMenuItem();
			switch (menuItem) {
				case 0 : stopApplication();
				case 1 : printBooks(); break;
				case 2 : addBook(); break;
				case 3 : changeBooksPrice(); break;
				case 4 : findBook(); break;
				default: printBooks.printMessage(ERROR_ENTER);
			}
		}
	}

	private void stopApplication() {
		serviceBooks.saveBooks();
		printBooks.printMessage(BOOK_SAVED_MESSAGE);
		logger.debug("Application stopped");
		System.exit(0);
	}

	private void findBook() {
		printBooks.printListBooks(serviceBooks.findBooks(getFindingParam()));
	}

	private String getFindingParam() {
		String value;
		while (true) {
			try {
				value = inputDataView.inputString(FIND_BOOK);
				BookValidator.validateFindParam(value);
				return value;
			} catch (FindParamValidationException e) {
				printBooks.printMessage(FINDING_PARAM_ERROR_TEXT);
			}
		}
	}

	private void changeBooksPrice() {
		int percents = getPercent();
		serviceBooks.changePrice(percents);
		printBooks.printMessage(String.format(PRICE_CHANGED, percents));
	}

	private int getPercent() {
		int value;
		while (true) {
			try {
				value = inputDataView.inputInt(CHANGE_PRICE);
				BookValidator.validatePriceChange(value);
				return value;
			} catch (PriceChangeValidationException e) {
				printBooks.printMessage(CHANGE_PRICE_ERROR_TEXT);
			}
		}
	}

	private void printBooks() {
		printBooks.printListBooks(serviceBooks.getBookList());
	}

	//TODO add exceptions handling
	private void addBook() throws InputStringValidationException, InputIntValidationException, PriceValidationException {
		String name = inputDataView.inputString(ENTER_TITLE);
		BookValidator.validateInputString(name);
		String author = inputDataView.inputString(ENTER_AUTHOR);
		BookValidator.validateInputString(author);
		String publisher = inputDataView.inputString(ENTER_PUBLISHER);
		BookValidator.validateInputString(publisher);
		int year = inputDataView.inputInt(ENTER_YEAR);
		BookValidator.validateInputInt(year);
		int pages = inputDataView.inputInt(ENTER_PAGES_COUNT);
		BookValidator.validateInputInt(pages);
		double cost = inputDataView.inputDouble(ENTER_COST);
		BookValidator.validatePrice(cost);

		printBooks.printNewBook(serviceBooks.addBook(name, author, publisher, year, pages, cost));
	}
}
