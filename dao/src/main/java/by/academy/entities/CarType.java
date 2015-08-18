/**
 * 
 */
package by.academy.entities;

import by.academy.Identified;

/**
 * @author Veronika
 *
 */
public class CarType implements Identified<Integer>{
	
	private Integer id_type = null;
    private String type;

    public Integer getId() {
        return id_type;
    }

    protected void setId(int id_type) { this.id_type = id_type;  }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_type == null) ? 0 : id_type.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarType other = (CarType) obj;
		if (id_type == null) {
			if (other.id_type != null)
				return false;
		} else if (!id_type.equals(other.id_type))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarType [id_type=");
		builder.append(id_type);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
