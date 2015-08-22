
package by.academy.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.academy.exceptions.ConnectionPoolException;

public enum ConnectionPool {
	INSTANCE;
	
	public static final int DEFAULT_CAPACITY = 5;
	private final Logger LOG = Logger.getLogger(getClass().getSimpleName());
	private static final int TIMEOUT = 2;
	
	private Lock lock;
	private BlockingQueue<Connection> connections;
	private int connectionsCreated;
	private int connPoolCapacity;
	private Properties connectionProps;
	
	private ConnectionPool() {
		connectionProps = new Properties();
		connectionProps.put("user", ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.DB_USER));
		connectionProps.put("password", ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.DB_PASSWORD));
		connectionProps.put("url", ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.DB_URL));
	}
	
	public void init(int connectionNum) throws ConnectionPoolException {
		this.connections = new LinkedBlockingQueue<>(connectionNum);
		this.connectionsCreated = 0;
		this.connPoolCapacity = connectionNum;
		this.lock = new ReentrantLock(true);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw new ConnectionPoolException("Driver for database was not found");
		}
	}
	
	
	public Connection getConnection() throws ConnectionPoolException {
		try {
			if (connPoolCapacity > connectionsCreated) {
				this.lock.lock();
				try {
					if ((connections.isEmpty()) && (connPoolCapacity > connectionsCreated)){
						Connection conn = (Connection) DriverManager.getConnection(connectionProps.getProperty("url"), connectionProps);
						Connection dbConnection = new Connection(conn);
						++connectionsCreated;
						return dbConnection;
					}
				} finally {
					this.lock.unlock();
				}
			}
			Connection dbConnection = connections.take();
			if(dbConnection.isValid(TIMEOUT)) {
				return dbConnection;
			} else {
				Connection conn = (Connection) DriverManager.getConnection(connectionProps.getProperty("url"), connectionProps);
				dbConnection = new Connection(conn);
				return dbConnection;
			}
		} catch (InterruptedException | SQLException e) {
			throw new ConnectionPoolException(e);
		}
	}
	
	void returnConnection(Connection connection) {
		try {
			this.connections.put(connection);
		} catch (InterruptedException e) {
			LOG.error("Thread was interrupted during connection releasing", e);
		}
	}
	
	public void releaseResources() throws ConnectionPoolException {
		try {
			for (Connection dbConnection : connections) {
				dbConnection.releaseConnection(TIMEOUT);
			} 
		} catch (SQLException e) {
			throw new ConnectionPoolException("Was not able to close connections", e);
		}
	}
}