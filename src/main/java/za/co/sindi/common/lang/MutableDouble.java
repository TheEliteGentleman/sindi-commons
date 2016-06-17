/**
 * 
 */
package za.co.sindi.common.lang;

/**
 * @author Bienfait Sindi
 * @since 16 March 2014
 *
 */
public class MutableDouble extends Number implements Comparable<MutableDouble>, MutableValue<Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1620136572520500627L;
	
	private double value;
	
	/**
	 * 
	 */
	public MutableDouble() {
		this(0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 */
	public MutableDouble(int value) {
		super();
		this.value = value;
	}
	
	/**
	 * @param number
	 */
	public MutableDouble(Number number) {
		super();
		if (number == null) {
			throw new IllegalArgumentException("Number is null.");
		}
		
		this.value = number.doubleValue();
	}
	
	/**
	 * @param value
	 */
	public MutableDouble(String value) {
		super();
		this.value = Double.parseDouble(value);
	}
	
	public boolean isNaN() {
		return Double.isNaN(value);
	}
	
	public boolean isInfinite() {
		return Double.isInfinite(value);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#getValue()
	 */
	public Double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.commons.lang.Mutable#setValue(java.lang.Object)
	 */
	public void setValue(Double value) {
		// TODO Auto-generated method stub
		this.value = (value == null) ? 0 : value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MutableDouble o) {
		// TODO Auto-generated method stub
		double value2 = o.value;
		return (value < value2) ? -1 : (value == value2 ? 0 : 1);
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
		return (long) value;
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
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MutableDouble other = (MutableDouble) obj;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
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
