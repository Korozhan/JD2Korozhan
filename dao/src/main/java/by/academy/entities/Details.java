/**
 * 
 */
package by.academy.entities;

import by.academy.Identified;

/**
 * @author Veronika
 *
 */
public class Details implements Identified<Integer>{
	
	private Integer id_details = null;
    private String mark;
    private String model;
    private String country;
    private String gearbox;
    private Integer mileage;
    private String fuel;


    public Integer getId() {
        return id_details;
    }

    protected void setId(int id_details) { this.id_details = id_details;  }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
    
    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + ((gearbox == null) ? 0 : gearbox.hashCode());
		result = prime * result
				+ ((id_details == null) ? 0 : id_details.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Details other = (Details) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (fuel == null) {
			if (other.fuel != null)
				return false;
		} else if (!fuel.equals(other.fuel))
			return false;
		if (gearbox == null) {
			if (other.gearbox != null)
				return false;
		} else if (!gearbox.equals(other.gearbox))
			return false;
		if (id_details == null) {
			if (other.id_details != null)
				return false;
		} else if (!id_details.equals(other.id_details))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (mileage == null) {
			if (other.mileage != null)
				return false;
		} else if (!mileage.equals(other.mileage))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Details [id_details=");
		builder.append(id_details);
		builder.append(", mark=");
		builder.append(mark);
		builder.append(", model=");
		builder.append(model);
		builder.append(", country=");
		builder.append(country);
		builder.append(", gearbox=");
		builder.append(gearbox);
		builder.append(", mileage=");
		builder.append(mileage);
		builder.append(", fuel=");
		builder.append(fuel);
		builder.append("]");
		return builder.toString();
	}
}
