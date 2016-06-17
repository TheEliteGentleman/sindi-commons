/**
 * 
 */
package za.co.sindi.common.lang;

import java.io.Serializable;

/**
 * @author Bienfait Sindi
 * @since 16 March 2014
 *
 */
public class MutableBoolean implements Comparable<MutableBoolean>, MutableValue<Boolean>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4285344028213417541L;
	
	private boolean value;
	
	/**
	 * 
	 */
	public MutableBoolean() {
		this(false);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 */
	public MutableBoolean(boolean value) {
		super();
		this.value = value;
	}
	
	/**
	 * @param value
	 */
	public MutableBoolean(Boolean value) {
		super();
		if (value == null) {
			throw new IllegalArgumentException("Boolean is null.");
		}
		
		this.value = value.booleanValue();
	}
	
	/**
	 * @param value
	 */
	public MutableBoolean(String value) {
		super();
		this.value = Boolean.parseBoolean(value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MutableBoolean o) {
		// TODO Auto-generated method stub
		boolean value2 = o.value;
		return (value == value2) ? 0 : (value ? 1 : -1);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#getValue()
	 */
	public Boolean getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#setValue(java.lang.Object)
	 */
	public void setValue(Boolean value) {
		// TODO Auto-generated method stub
		this.value = value == null ? false : value;
	}

	public boolean booleanValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public boolean isTrue() {
		return true == value;
	}
	
	public boolean isFalse() {
		return false == value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (value ? 1231 : 1237);
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
		MutableBoolean other = (MutableBoolean) obj;
		if (value != other.value)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
