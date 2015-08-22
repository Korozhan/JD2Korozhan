package by.academy.exceptions;

public class CarMarketException extends Exception{
	
	public CarMarketException() {
		super();
	}
	
	public CarMarketException(String message) {
		super(message);
	}
	
	public CarMarketException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CarMarketException(Throwable cause) {
		super(cause);
	}

}
