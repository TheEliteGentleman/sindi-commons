/**
 * 
 */
package za.co.sindi.common.collection;

/**
 * @author Buhake Sindi
 * @since 29 October 2012
 *
 */
public class Pair<T1, T2> {

	public T1 first;
	public T2 second;
	
	/**
	 * @param first
	 * @param second
	 */
	public Pair(final T1 first, final T2 second) {
		super();
		this.first = first;
		this.second = second;
	}
}
