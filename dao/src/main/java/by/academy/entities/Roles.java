/**
 * 
 */
package by.academy.entities;

import by.academy.config.Identified;

public class Roles implements Identified<Integer>{
	private Integer id_role = null;
    private String role;

    public Integer getId() {
        return id_role;
    }

    protected void setId(int id_role) { this.id_role = id_role;  }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_role == null) ? 0 : id_role.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Roles other = (Roles) obj;
		if (id_role == null) {
			if (other.id_role != null)
				return false;
		} else if (!id_role.equals(other.id_role))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Roles [id_role=");
		builder.append(id_role);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
