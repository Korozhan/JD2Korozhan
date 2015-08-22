/**
 * 
 */
package by.academy.entities;

import by.academy.config.Identified;


public class Lot implements Identified<Integer>{
	
	private Integer id_user;
    private Integer id_role;
    private Integer id_car;
    private Integer id_bill;

    public Integer getUserId() {
        return id_user;
    }

    public void setUserId(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getRoleId() {
        return id_role;
    }

    public void setRoleId(Integer id_role) { 
    	this.id_role = id_role;  }

    public Integer getCarId() {
        return id_car;
    }

    public void setCarId(Integer id_car) {
        this.id_car = id_car;
    }

    public Integer getBillId() {
        return id_bill;
    }

    public void setBillId(Integer id_bill) { 
    	this.id_bill = id_bill;  }

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_bill == null) ? 0 : id_bill.hashCode());
		result = prime * result + ((id_car == null) ? 0 : id_car.hashCode());
		result = prime * result + ((id_role == null) ? 0 : id_role.hashCode());
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
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
		Lot other = (Lot) obj;
		if (id_bill == null) {
			if (other.id_bill != null)
				return false;
		} else if (!id_bill.equals(other.id_bill))
			return false;
		if (id_car == null) {
			if (other.id_car != null)
				return false;
		} else if (!id_car.equals(other.id_car))
			return false;
		if (id_role == null) {
			if (other.id_role != null)
				return false;
		} else if (!id_role.equals(other.id_role))
			return false;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lot [id_user=");
		builder.append(id_user);
		builder.append(", id_role=");
		builder.append(id_role);
		builder.append(", id_car=");
		builder.append(id_car);
		builder.append(", id_bill=");
		builder.append(id_bill);
		builder.append("]");
		return builder.toString();
	}
}
