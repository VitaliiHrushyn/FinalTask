package com.alpha.view;

import java.util.Scanner;

import static com.alpha.common.Constants.ENTER_COMMAND;
import static com.alpha.common.Constants.ERROR_ENTER;

public class InputDataView {
	private Scanner scanner = new Scanner(System.in);
	private BooksView booksView;

	public InputDataView(BooksView booksView) {
		this.booksView = booksView;
	}

	public double inputDouble(String message) {
		booksView.printMessage(message);

		while ( !scanner.hasNextDouble()) {
			scanner.next();
			booksView.printMessage(ERROR_ENTER);
		}
		return scanner.nextDouble();
	}

	public int inputInt(String message) {
		booksView.printMessage(message);

		while ( !scanner.hasNextInt()) {
			scanner.next();
			booksView.printMessage(ERROR_ENTER);
		}
		return scanner.nextInt();
	}

	public int inputMenuItem() {
		booksView.printMenu();
		return inputInt(ENTER_COMMAND);
	}

	public String inputString(String message) {
		booksView.printMessage(message);
		return scanner.next();
	}
}
