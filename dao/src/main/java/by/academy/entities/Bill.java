/**
 * 
 */
package by.academy.entities;

import java.util.Date;

import by.academy.Identified;


/**
 * @author Veronika
 *
 */
public class Bill implements Identified<Integer>{
	
	private Integer id_bill = null;
    private Integer price;
    private Date date;

    public Integer getId() {
        return id_bill;
    }

    protected void setId(int id_bill) { this.id_bill = id_bill;  }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id_bill == null) ? 0 : id_bill.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Bill other = (Bill) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_bill == null) {
			if (other.id_bill != null)
				return false;
		} else if (!id_bill.equals(other.id_bill))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bill [id_bill=");
		builder.append(id_bill);
		builder.append(", price=");
		builder.append(price);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}


}
