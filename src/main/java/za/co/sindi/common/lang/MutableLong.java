/**
 * 
 */
package za.co.sindi.common.lang;

/**
 * @author Bienfait Sindi
 * @since 16 March 2014
 *
 */
public class MutableLong extends Number implements Comparable<MutableLong>, MutableValue<Long> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3100619423196582928L;
	
	private long value;
	
	/**
	 * 
	 */
	public MutableLong() {
		this(0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 */
	public MutableLong(long value) {
		super();
		this.value = value;
	}
	
	/**
	 * @param number
	 */
	public MutableLong(Number number) {
		super();
		if (number == null) {
			throw new IllegalArgumentException("Number is null.");
		}
		
		this.value = number.longValue();
	}
	
	/**
	 * @param value
	 */
	public MutableLong(String value) {
		super();
		this.value = Long.parseLong(value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MutableLong o) {
		// TODO Auto-generated method stub
		long value2 = o.value;
		return (value < value2) ? -1 : (value == value2 ? 0 : 1);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#getValue()
	 */
	public Long getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#setValue(java.lang.Object)
	 */
	public void setValue(Long value) {
		// TODO Auto-generated method stub
		this.value = value == null ? 0 : value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return (int) value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float) value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return (double) value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (value ^ (value >>> 32));
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
		MutableLong other = (MutableLong) obj;
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
