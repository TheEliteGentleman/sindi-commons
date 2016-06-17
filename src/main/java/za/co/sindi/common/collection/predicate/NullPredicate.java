/**
 * 
 */
package za.co.sindi.common.collection.predicate;

import za.co.sindi.common.functional.Predicate;

/**
 * @author Bienfait Sindi
 * @since 16 May 2013
 *
 */
public class NullPredicate<T> implements Predicate<T> {

	/* (non-Javadoc)
	 * @see za.co.sindi.collections.math.Predicate#apply(java.lang.Object)
	 */
	public boolean apply(T input) {
		// TODO Auto-generated method stub
		return input == null;
	}
}
