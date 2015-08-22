/**
 * 
 */
package by.academy.config;

import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Connection implements AutoCloseable {
	private Connection connection;
	
	Connection(Connection connection) {
		this.connection = connection;
	}


	public void close() {
		ConnectionPool.INSTANCE.returnConnection(this);
	}
	
	void releaseConnection(int timeout) throws SQLException {
		if (connection.isValid(timeout)) {
			connection.close();
		}
	}

	public void commit() throws SQLException {
		connection.commit();
	}

	
	public Statement createStatement() throws SQLException {
		return connection.createStatement();
	}

	
	public boolean getAutoCommit() throws SQLException {
		return connection.getAutoCommit();
	}

	
	public DatabaseMetaData getMetaData() throws SQLException {
		return connection.getMetaData();
	}

	public int getNetworkTimeout() throws SQLException {
		return connection.getNetworkTimeout();
	}

	
	public boolean isClosed() throws SQLException {
		return connection.isClosed();
	}

	
	public boolean isValid(int timeout) throws SQLException {
		return connection.isValid(timeout);
	}

	
	public CallableStatement prepareCall(String sql) throws SQLException {
		return connection.prepareCall(sql);
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}

	
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		connection.releaseSavepoint(savepoint);
	}

	
	public void rollback() throws SQLException {
		connection.rollback();
	}

	
	public void rollback(Savepoint savepoint) throws SQLException {
		connection.rollback(savepoint);
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		connection.setAutoCommit(autoCommit);
	}

	public Savepoint setSavepoint() throws SQLException {
		return connection.setSavepoint();
	}

	
	public Savepoint setSavepoint(String name) throws SQLException {
		return connection.setSavepoint(name);
	}

}
