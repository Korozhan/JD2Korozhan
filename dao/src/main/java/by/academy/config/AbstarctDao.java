package by.academy.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import by.academy.exceptions.DaoException;

public abstract class AbstarctDao<T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK>{
	
	private Connection connection;
	
	public abstract String getCreateQuery();//INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
	public abstract String getSelectQuery();//SELECT [column, column, ...] FROM [Table];
	public abstract String getUpdateQuery();//UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
	public abstract String getDeleteQuery();//DELETE FROM [Table] WHERE id= ?;

	protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;
	protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DaoException;
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DaoException;

	
	@Override
    public T add(T object) throws DaoException{
		T persistInstance = null;
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
            	throw new DaoException("On add modify more then 1 record: " + count);
            	}
        } catch (Exception e) {
        	throw new DaoException(e);
        }
        sql = getSelectQuery() + " WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1))
            	throw new DaoException("Exception on findByPK new persist data.");
            persistInstance = list.iterator().next();
        } catch (Exception e) {
        	throw new DaoException(e);
        }
        return persistInstance;
    }
	
	@Override
    public void update(T object) throws DaoException{
		String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1)
            	throw new DaoException("On update modify more then 1 record: " + count);
        } catch (Exception e) {
        	throw new DaoException(e);
        }
    }

    @Override
    public void delete(T object) throws DaoException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
            	throw new DaoException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1)
            	throw new DaoException("On delete modify more then 1 record: " + count);
            statement.close();
        } catch (Exception e) {
        	throw new DaoException(e);
        }
    }
	
	@Override
	public T getById(Integer id) throws DaoException{
		List<T> list = null;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e){
        	throw new DaoException(e);
        }
        if (list == null || list.size() == 0)
        	throw new DaoException("Record with PK = " + id + " not found.");
        if (list.size() > 1)
        	throw new DaoException("Received more than one record.");
        return list.iterator().next();
	}
	
	public AbstarctDao(Connection connection) {
	    this.connection = connection;
	}




	
}


