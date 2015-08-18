package by.academy;

import org.apache.log4j.Logger;

public class ConnectionPoolException extends CarMarketException {

	private static final String MESSAGE = "Error during operation with connection pool";
	private final Logger LOG = Logger.getLogger(getClass().getSimpleName());

	public ConnectionPoolException() {
		LOG.error(MESSAGE);
	}
	
	public ConnectionPoolException(String message) {
		super(message);
		LOG.error(message);
	}
	
	public ConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
		LOG.error(message, cause);
	}
	
	public ConnectionPoolException(Throwable cause) {
		super(cause);
		LOG.error(MESSAGE);
	}
}
