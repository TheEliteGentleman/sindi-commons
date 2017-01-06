/**
 * 
 */
package za.co.sindi.common.collection;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

import za.co.sindi.common.functional.Function;
import za.co.sindi.common.functional.Predicate;
import za.co.sindi.common.util.CaseInsensitiveHashMap;
import za.co.sindi.common.utils.PreConditions;

/**
 * Note, use this class pre Java 8.
 * 
 * @author Bienfait Sindi
 * @since 26 March 2013
 *
 */
public final class Collections {

	private Collections() {
		throw new AssertionError("Private Constructor.");
	}
	
	/**
	 * Counts the number of elements in the collection which satisfy a predicate.
	 * 
	 * @param collection
	 * @param predicate
	 * @return the number of elements satisfying the predicate.
	 */
	public static <E> int count(Collection<? extends E> collection, Predicate<? super E> predicate) {
		PreConditions.checkArgument(collection != null, "No collection was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		int count = 0;
		if (collection instanceof RandomAccess && collection instanceof List) {
			List<? extends E> list = (List<? extends E>)collection;
			for (int i = 0; i < list.size(); i++) {
				if (predicate.apply(list.get(i))) {
					count++;
				}
			}
		} else {
			for (E element : collection) {
				if (predicate.apply(element)) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Tests whether a predicate holds for some of the elements of this collection.
	 * 
	 * @param collection
	 * @param predicate
	 * @return <code>true</code> if the given predicate holds for some of the elements of this collection, otherwise <code>false</code>.
	 */
	public static <E> boolean exists(Collection<? extends E> collection, Predicate<? super E> predicate) {
		PreConditions.checkArgument(collection != null, "No collection was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		if (collection instanceof RandomAccess && collection instanceof List) {
			List<? extends E> list = (List<? extends E>)collection;
			for (int i = 0; i < list.size(); i++) {
				if (predicate.apply(list.get(i))) {
					return true;
				}
			}
		} else {
			for (E element : collection) {
				if (predicate.apply(element)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Tests whether a predicate holds for all elements of this collection.
	 * 
	 * @param collection
	 * @param predicate
	 * @return <code>true</code> if the given predicate <i>p</i> holds for all elements of this collection, <code>false</code> otherwise.
	 */
	public static <E> boolean forall(Collection<? extends E> collection, Predicate<? super E> predicate) {
		PreConditions.checkArgument(collection != null, "No collection was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		if (collection instanceof RandomAccess && collection instanceof List) {
			List<? extends E> list = (List<? extends E>)collection;
			for (int i = 0; i < list.size(); i++) {
				if (!predicate.apply(list.get(i))) {
					return false;
				}
			}
		} else {
			for (E element : collection) {
				if (!predicate.apply(element)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Applies a function <code>function</code> to all elements of this map.
	 * 
	 * @param collection
	 * @param function the function that is applied for its side-effect to every element. The result of function <code>function</code> is discarded.
	 */
	public static <E> void foreach(Collection<? extends E> collection, Function<? super E, Void> function) {
		PreConditions.checkArgument(collection != null, "No collection was specified.");
		PreConditions.checkArgument(function != null, "No function was specified.");
		
		if (collection instanceof RandomAccess && collection instanceof List) {
			List<? extends E> list = (List<? extends E>)collection;
			for (int i = 0; i < list.size(); i++) {
				function.apply(list.get(i));
			}
		} else {
			for (E element : collection) {
				function.apply(element);
			}
		}
	}
	
	public static <V> Map<String,V> caseInsensitiveMap(Map<String, V> m) {
		return new CaseInsensitiveHashMap<V>(m);
	}
}
