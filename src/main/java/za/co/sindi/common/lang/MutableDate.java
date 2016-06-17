/**
 * 
 */
package za.co.sindi.common.lang;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Bienfait Sindi
 * @since 28 April 2014
 *
 */
public class MutableDate implements Comparable<MutableDate>, MutableValue<Date>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9065112440554046564L;
	private Date value;

	/**
	 * 
	 */
	public MutableDate() {
		super();
		// TODO Auto-generated constructor stub
		value = new Date();
	}
	
	/**
	 * 
	 * @param date
	 */
	public MutableDate(long date) {
		super();
		// TODO Auto-generated constructor stub
		value = new Date(date);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#getValue()
	 */
	@Override
	public Date getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Date value) {
		// TODO Auto-generated method stub
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MutableDate o) {
		// TODO Auto-generated method stub
		return value.compareTo(o.value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		MutableDate other = (MutableDate) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
