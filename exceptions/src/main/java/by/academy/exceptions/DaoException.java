package by.academy.exceptions;

import org.apache.log4j.Logger;

public class DaoException extends CarMarketException{ 

	private final Logger LOG = Logger.getLogger(getClass().getSimpleName());
	private static final String MESSAGE = "Error during access to object's data";

	public DaoException() {
		LOG.error(MESSAGE);
	}

	public DaoException(String message) {
		super(message);
		LOG.error(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
		LOG.error(message, cause);
	}

	public DaoException(Throwable cause) {
		super(cause);
		LOG.error(MESSAGE, cause);
	}
}
