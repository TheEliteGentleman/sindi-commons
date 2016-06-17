/**
 * 
 */
package za.co.sindi.common.lang;

/**
 * @author Bienfait Sindi
 * @since 16 March 2014
 *
 */
public class MutableByte extends Number implements Comparable<MutableByte>, MutableValue<Byte> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1691770007813271073L;
	
	private byte value;
	
	/**
	 * 
	 */
	public MutableByte() {
		this(0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 */
	public MutableByte(byte value) {
		super();
		this.value = value;
	}
	
	/**
	 * @param number
	 */
	public MutableByte(Number number) {
		super();
		if (number == null) {
			throw new IllegalArgumentException("Number is null.");
		}
		
		this.value = number.byteValue();
	}
	
	/**
	 * @param value
	 */
	public MutableByte(String value) {
		super();
		this.value = Byte.parseByte(value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MutableByte o) {
		// TODO Auto-generated method stub
		byte value2 = o.value;
		return (value < value2) ? -1 : (value == value2 ? 0 : 1);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#getValue()
	 */
	public Byte getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#setValue(java.lang.Object)
	 */
	public void setValue(Byte value) {
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
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#byteValue()
	 */
	@Override
	public byte byteValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		MutableByte other = (MutableByte) obj;
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
