/**
 * 
 */
package za.co.sindi.common.lang;

import java.io.Serializable;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public final class Null implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5300029777650791979L;

	/** The primary instance of Null. */
	public static final Null VALUE = new Null();
	
	/**
	 * 
	 */
	private Null() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		if (obj == this) return true;
//		return (obj == null || obj.getClass() == getClass());
		return (obj == null || obj == this || obj.getClass() == getClass());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "null";
	}
}
