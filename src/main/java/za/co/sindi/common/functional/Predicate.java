/**
 * 
 */
package za.co.sindi.common.functional;

/**
 * @author Buhake Sindi
 * @since 29 October 2012
 *
 */
public interface Predicate<T> /* extends Function<T, Boolean> */ {

	public boolean apply(T input);
}
