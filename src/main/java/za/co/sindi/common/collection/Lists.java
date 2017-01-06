/**
 * 
 */
package za.co.sindi.common.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

import za.co.sindi.common.functional.Function;
import za.co.sindi.common.functional.Predicate;
import za.co.sindi.common.utils.Objects;
import za.co.sindi.common.utils.PreConditions;


/**
 * Note, use this class pre Java 8.
 * 
 * @author Buhake Sindi
 * @since 29 October 2012
 *
 */
public final class Lists {

	private Lists() {
		throw new AssertionError("Private Constructor.");
	}
	
	@SafeVarargs
	public static <E> List<E> newList(E... elements) {
		PreConditions.checkArgument(elements != null, "No elements was specified.");
		
		List<E> newList = new ArrayList<E>();
		for (int i = 0; i < elements.length; i++) {
			E element = elements[i];
			if (element != null) {
				newList.add(element);
			}
		}
		
		return newList;
	}
	
	/**
     * Creates a new list and appends the specified element to the end of the new list and returning the new list.
     * 
     * @param list
	 * @param element
	 * @return
	 */
	public static <E> List<E> append(List<? extends E> list, E element) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(element != null, "No element was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		newList.add(element);
		return newList;
	}
	
	/**
	 * Returns a new List appending all elements to the end of the new list.
	 * 
	 * @param collections
	 * @return
	 */
	@SafeVarargs
	public static <E> List<E> concat(Collection<? extends E>... collections) {
		PreConditions.checkArgument(collections != null, "No collections was specified.");
		
		List<E> newList = new ArrayList<E>();
		for (int i = 0; i < collections.length; i++) {
			newList.addAll(collections[i]);
		}
		
		return newList;
	}
	
	/**
	 * Selects all elements except first {@code n} ones.
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public static <E> List<E> drop(List<? extends E> list, int n) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		return slice(list, n, list.size());
	}
	
	
	/**
	 * Selects all elements except last {@code n} ones.
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public static <E> List<E> dropRight(List<? extends E> list, int n) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		return slice(list, 0, list.size() - n);
	}
	
	
	/**
	 * Drops longest prefix of elements that satisfy a predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> List<E> dropWhile(List<? extends E> list, Predicate<? super E> predicate) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		int index = 0;
		if (list instanceof RandomAccess) {
			for (index = 0; index < list.size(); index++) {
				if (!predicate.apply(list.get(index))) {
					break;
				}
			}
		} else {
			for (E element : list) {
				if (!predicate.apply(element)) {
					break;
				}
				
				index++;
			}
		}
		
		return slice(list, index, list.size());
	}
	
	/**
	 * Returns the first element in the list.
	 * @return
	 */
	public static <E> E head(List<? extends E> list) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		return list.get(0);
	}
	
	/**
	 * Returns the initial elements in the list, except the last element.
	 * 
	 * @param list
	 * @return
	 */
	public static <E> List<E> init(List<? extends E> list) {
		return slice(list, 0, list.size() - 1);
	}
	
	/**
     * Creates a new list and inserts the specified element to the specified index of the new list and returning the new list.
     * 
     * @param list
     * @param index
	 * @param element
	 * @return
	 */
	public static <E> List<E> insert(List<? extends E> list, int index, E element) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		newList.add(index, element);
		return newList;
	}
	
	/**
	 * Returns a new List inserting all elements to the specified index of the new list.
	 * 
	 * @param list
	 * @param c
	 * @return
	 */
	public static <E> List<E> insert(List<? extends E> list, int index, java.util.Collection<? extends E> c) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		newList.addAll(index, c);
		return newList;
	}
	
	/**
	 * Returns the last element in the list.
	 * 
	 * @param list
	 * @return
	 */
	public static <E> E last(List<? extends E> list) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		if (list instanceof RandomAccess) {
			return list.get(list.size() - 1);
		}
		
		ListIterator<? extends E> iterator = list.listIterator(list.size());
		return iterator.hasPrevious() ? iterator.previous() : null; 
	}
	
	/**
	 * Returns the first element's tail (i.e., all elements except the first element).
	 * 
	 * @param list
	 * @return
	 */
	public static <E> List<E> tail(List<? extends E> list) {
		return drop(list, 1);
	}
	
	/**
	 * Builds a new list from this list without any duplicate elements.
	 * @return
	 */
	public static <E> List<E> distinct(List<? extends E> list) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>();
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				E element = list.get(i);
				if (!newList.contains(element)) {
					newList.add(element);
				}
			}
		} else {
			for (E element : list) {
				if (!newList.contains(element)) {
					newList.add(element);
				}
			}
		}
		
		return newList;
	}
	
	/**
	 * Selects all elements of this list which satisfy a predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> List<E> filter(List<? extends E> list, Predicate<? super E> predicate) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified");
		
		List<E> newList = new ArrayList<E>();
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				E element = list.get(i);
				if (predicate.apply(element)) {
					newList.add(element);
				}
			}
		} else {
			for (E element : list) {
				if (predicate.apply(element)) {
					newList.add(element);
				}
			}
		}
		
		return newList;
	}
	
	/**
	 * Selects all elements of this list which do not satisfy a predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> List<E> filterNot(List<? extends E> list, Predicate<? super E> predicate) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified");
		
		List<E> newList = new ArrayList<E>();
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				E element = list.get(i);
				if (!predicate.apply(element)) {
					newList.add(element);
				}
			}
		} else {
			for (E element : list) {
				if (!predicate.apply(element)) {
					newList.add(element);
				}
			}
		}
		
		return newList;
	}
	
	/**
	 * Finds the first element of the sequence satisfying a predicate, if any.
	 * 
	 * @param list
	 * @param predicate
	 * @return <code>E</code> if an element was found, <code>null</code>, otherwise.
	 */
	public static <E> E find(List<? extends E> list, Predicate<? super E> predicate) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified");
		
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				E element = list.get(i);
				if (predicate.apply(element)) {
					return element;
				}
			}
		} else {
			for (E element : list) {
				if (predicate.apply(element)) {
					return element;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Builds a new collection by applying a function to all elements of this list and using the elements of the resulting collections.
	 * 
	 * @param function
	 * @param lists
	 * @return
	 */
	@SafeVarargs
	public static <E, B> List<B> flatMap(Function<? super E, B> function, List<? extends E>... lists) {
		return map(flatten(lists), function);
	}
	
	/**
	 * Converts this list of traversable collections into a list formed by the elements of these traversable collections.
	 * @param lists
	 * @return
	 */
	@SafeVarargs
	@SuppressWarnings("unchecked")
	public static <E> List<E> flatten(java.util.List<? extends E>... lists) {
		return (List<E>) flattenAny(lists);
	}
	
	/**
	 * Converts this list of traversable collections into a list formed by the elements of these traversable collections.
	 * @param lists
	 * @return
	 */
	public static List<?> flattenAny(java.util.List<?>... lists) {
		PreConditions.checkArgument(lists != null, "No lists was specified.");
		
		List<Object> newList = new ArrayList<Object>();
		for (int i = 0; i < lists.length; i++) {
			newList.addAll(lists[i]);
		}
		
		return newList;
	}
	
	/**
	 * Partitions this list into a map of lists according to some discriminator function.
	 * 
	 * @param list
	 * @param discriminatorFunction
	 * @return
	 */
	public static <K, E> Map<K, List<E>> groupBy(List<? extends E> list, Function<? super E, K> discriminatorFunction) {
		PreConditions.checkArgument(list != null, "No list was specified.");
		PreConditions.checkArgument(discriminatorFunction != null, "No discriminator function was specified.");
		
		Map<K, List<E>> groupedMap = new HashMap<K, List<E>>();
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				E element = list.get(i);
				K key = discriminatorFunction.apply(element);
				groupedMap.put(key, append(Maps.getOrElse(groupedMap, key, new ArrayList<E>()), element));
			}
		} else {
			for (E element : list) {
				K key = discriminatorFunction.apply(element);
				groupedMap.put(key, append(Maps.getOrElse(groupedMap, key, new ArrayList<E>()), element));
			}
		}
		
		return groupedMap;
	}
	
	/**
	 * Finds index of first element satisfying some predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> int indexWhere(List<? extends E> list, Predicate<? super E> predicate) {
		return indexWhere(list, predicate, 0);
	}
	
	/**
	 * Finds index of the first element satisfying some predicate after or at some start index.
	 * 
	 * @Param list
	 * @param predicate
	 * @param from
	 * @return
	 */
	public static <E> int indexWhere(List<? extends E> list, Predicate<? super E> predicate, int from) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		if (list instanceof RandomAccess) {
			for (int i = from; i < list.size(); i++) {
				if (predicate.apply(list.get(i))) {
					return i;
				}
			}
		} else {
			int index = -1;
			for (E element : list) {
				index++;
				if (predicate.apply(element)) {
					return index;
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Computes the multiset intersection between this list and another sequence.
	 * 
	 * @param list
	 * @param c
	 * @return
	 */
	public static <E> List<E> intersect(List<? extends E> list, List<? extends E> c) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
//		List<E> newList = new ArrayList<E>();
//		if (list instanceof RandomAccess) {
//			for (int i = 0; i < list.size(); i++) {
//				E element = list.get(i);
//				if (c.contains(element)) {
//					newList.add(element);
//				}
//			}
//		} else {
//			for (E element : list) {
//				if (c.contains(element)) {
//					newList.add(element);
//				}
//			}
//		}
//		
//		return newList;
		return retainsAll(list, c);
	}
	
	/**
	 * Finds index of last occurrence of some value in this list before or at a given end index.
	 * 
	 * @param list
	 * @param element
	 * @param endIndex
	 * @return
	 */
	public static <E> int lastIndexOf(List<? extends E> list, E element, int endIndex) {
		if (list instanceof RandomAccess) {
			for (int i = endIndex - 1; i >= 0; i--) {
				if (Objects.equals(list.get(i), element)) {
					return i;
				}
			}
		} else {
			ListIterator<? extends E> listIterator = list.listIterator(endIndex);
			int index = endIndex;
			while (listIterator.hasPrevious()) {
				E e = listIterator.previous();
				if (Objects.equals(e, element)) {
					return index;
				}
				
				index--;
			}
		}
		
		return -1;
	}
	
	/**
	 * Finds index of last element satisfying some predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> int lastIndexWhere(List<? extends E> list, Predicate<? super E> predicate) {
		return lastIndexWhere(list, predicate, list.size());
	}
	
	/**
	 * Finds index of last element satisfying some predicate before or at given end index.
	 * 
	 * @param list
	 * @param predicate
	 * @param endIndex
	 * @return
	 */
	public static <E> int lastIndexWhere(List<? extends E> list, Predicate<? super E> predicate, int endIndex) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		if (list instanceof RandomAccess) {
			for (int i = endIndex - 1; i >= 0; i--) {
				if (predicate.apply(list.get(i))) {
					return i;
				}
			}
		} else {
			ListIterator<? extends E> listIterator = list.listIterator(endIndex);
			int index = endIndex;
			while (listIterator.hasPrevious()) {
				E element = listIterator.previous();
				if (predicate.apply(element)) {
					return index;
				}
				
				index--;
			}
		}
		
		return -1;
	}
	
	/**
	 * Builds a new collection by applying a function to all elements of this list.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E, B> List<B> map(List<? extends E> list, Function<? super E, ? extends B> function) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(function != null, "No function was specified");
		
		List<B> newList = new ArrayList<B>();
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				E element = list.get(i);
				newList.add(function.apply(element));
			}
		} else {
			for (E element : list) {
				newList.add(function.apply(element));
			}
		}
		
		return newList;
	}
	
	/**
	 * Partitions this list in two lists according to a predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> Pair<List<E>, List<E>> partition(List<? extends E> list, Predicate<? super E> predicate) {
		return new Pair<List<E>, List<E>>(filter(list, predicate), filterNot(list, predicate));
	}
	
//	/**
//	 * Sorts this <code>List</code> according to the <code>Ordering</code>.
//	 * @param ordering
//	 * @return
//	 */
//	public List<E> sort(Ordering<? super E> ordering);
	
	/**
	 * Returns a list and removes from the new list all of its elements that are contained in the
     * specified collection.
     * 
     * @param list
     * @param c
	 */
	public static <E> List<E> subtractAll(List<? extends E> list, Collection<?> c) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(c != null, "No collection was specified");
		
		List<E> newList = new ArrayList<E>(list);
		newList.removeAll(c);
		return newList;
	}
	
	/**
	 * Retains only the elements in the new list that are contained in the specified collection
	 * 
	 *  @param list
	 *  @param c
	 */
	public static <E> List<E> retainsAll(List<? extends E> list, Collection<?> c) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(c != null, "No collection was specified");
		
		List<E> newList = new ArrayList<E>(list);
		newList.retainAll(c);
		return newList;
	}
	
	/**
	 * Creates a new list and removes the specified element from the new list.
	 * 
	 * @param list
	 * @param element
	 * @return
	 */
	public static <E> List<E> removeElement(List<? extends E> list, E element) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		newList.remove(element);
		return newList;
	}
	
	/**
	 * Creates a new list and removes the specified element from the new list.
	 * 
	 * @param list
	 * @param element
	 * @return
	 */
	public static <E> List<E> removeElement(List<? extends E> list, Predicate<? super E> predicate) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				if (predicate.apply(list.get(i))) {
					newList.remove(i);
				}
			}
		} else {
			for (E element : list) {
				if (predicate.apply(element)) {
					newList.remove(element);
				}
			}
		}
		
		return newList;
	}
	
	/**
	 * Returns new list with elements in reversed order.
	 * 
	 * @param list
	 * @return
	 */
	public static <E> List<E> reverse(List<? extends E> list) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		Collections.reverse(newList);
		return newList;
	}
	
	/**
	 * Builds a new collection by applying a function to all elements of this list and collecting the results in reversed order.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E, B> List<B> reverseMap(List<? extends E> list, Function<? super E, B> function) {
		return map(reverse(list), function);
	}
	
	/**
     * Creates a new list and replaces item on the specified with the the specified element provided to the new list and returning the new list.
     * 
     * @param list
     * @param index
	 * @param element
	 * @return
	 */
	public static <E> List<E> setElement(List<? extends E> list, int index, E element) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		
		List<E> newList = new ArrayList<E>(list);
		newList.set(index, element);
		return newList;
	}
	
	/**
	 * @param list
	 * @param beginIndex
	 * @param endIndex
	 * @return a list containing the elements greater than or equal to index <code>fromIndex</code> extending up to (but not including) index <code>endIndex</code> of this list.
	 */
	public static <E> List<E> slice(List<? extends E> list, int beginIndex, int endIndex) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		return new ArrayList<E>(list.subList(beginIndex, endIndex));
	}
	
	/**
	 * Splits this list into two at a given position.
	 * 
	 * @param list
	 * @param index
	 * @return
	 */
	public static <E> Pair<List<E>, List<E>> splitAt(List<? extends E> list, int index) {
		return new Pair<List<E>, List<E>>(slice(list, 0, index), slice(list, index, list.size()));
	}
	
	/**
	 * Selects first {@code n} elements.
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public static <E> List<E> take(List<? extends E> list, int n) {
		return slice(list, 0, n);
	}
	
	/**
	 * Selects last {@code n} elements.
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public static <E> List<E> takeRight(List<? extends E> list, int n) {
		int size = list.size();
		return slice(list, size - n, size);
	}
	
	/**
	 * Takes longest prefix of elements that satisfy a predicate.
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public static <E> List<E> takeWhile(List<? extends E> list, Predicate<? super E> predicate) {
		PreConditions.checkArgument(list != null, "No List was specified.");
		PreConditions.checkArgument(predicate != null, "No predicate was specified.");
		
		int index = 0;
		if (list instanceof RandomAccess) {
			for (index = 0; index < list.size(); index++) {
				if (!predicate.apply(list.get(index))) {
					break;
				}
			}
		} else {
			for (E element : list) {
				index++;
				if (!predicate.apply(element)) {
					break;
				}
			}
		}
		
		return slice(list, 0, index);
	}
}
