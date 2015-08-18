/**
 * 
 */
package by.academy.entities;

import by.academy.Identified;

/**
 * @author Veronika
 *
 */
public class Car implements Identified<Integer>{

	private Integer id_car = null;
    private Integer id_type;
    private Integer id_details;

    public Integer getId() {
        return id_car;
    }

    protected void setId(int id_car) { this.id_car = id_car;  }

    public Integer getTypeId() {
        return id_type;
    }

    public void setTypeId(Integer id_type) {
        this.id_type = id_type;
    }

    public Integer getDetailsId() {
        return id_details;
    }

    public void setDetailsId(Integer id_details) { 
    	this.id_details = id_details;  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_car == null) ? 0 : id_car.hashCode());
		result = prime * result
				+ ((id_details == null) ? 0 : id_details.hashCode());
		result = prime * result + ((id_type == null) ? 0 : id_type.hashCode());
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
		Car other = (Car) obj;
		if (id_car == null) {
			if (other.id_car != null)
				return false;
		} else if (!id_car.equals(other.id_car))
			return false;
		if (id_details == null) {
			if (other.id_details != null)
				return false;
		} else if (!id_details.equals(other.id_details))
			return false;
		if (id_type == null) {
			if (other.id_type != null)
				return false;
		} else if (!id_type.equals(other.id_type))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [id_car=");
		builder.append(id_car);
		builder.append(", id_type=");
		builder.append(id_type);
		builder.append(", id_details=");
		builder.append(id_details);
		builder.append("]");
		return builder.toString();
	}
}
