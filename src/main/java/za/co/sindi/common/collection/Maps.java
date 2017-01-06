/**
 * 
 */
package za.co.sindi.common.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;

import za.co.sindi.common.functional.Function;
import za.co.sindi.common.functional.Predicate;
import za.co.sindi.common.utils.PreConditions;

/**
 * @author Bienfait Sindi
 * @since 07 July 2013
 *
 */
public final class Maps {
	
	private Maps() {
		throw new AssertionError("Private Constructor.");
	}

	public static <K, V> Map<K, V> add(Map<? extends K, ? extends V> map, K key, V value) {
		Map<K, V> newMap = new HashMap<K, V>();
		if (map != null) {
			newMap.putAll(map);
		}
		
		newMap.put(key, value);
		return newMap;
	}
	
	@SafeVarargs
	public static <K, V> Map<K, V> concat(Map<? extends K, ? extends V>... maps) { //was addAll
		PreConditions.checkArgument(maps != null, "No maps were specified.");
		
		Map<K, V> newMap = new HashMap<K, V>();
		for (int i = 0; i < maps.length; i++) {
			newMap.putAll(maps[i]); 
		}
		
		return newMap;
	}
	
	public static <K, V> int count(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
//		int count = 0;
//		for (Entry<K, V> entry : map.entrySet()) {
//			if (predicate.apply(entry)) {
//				count++;
//			}
//		}
//		
//		return count;
		return Collections.count(map.entrySet(), predicate);
	}
	
	public static <K, V> boolean exists(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
//		for (Entry<K, V> entry : map.entrySet()) {
//			if (predicate.apply(entry)) {
//				return true;
//			}
//		}
//		
//		return false;
		return Collections.exists(map.entrySet(), predicate);
	}
	
	public static <K, V> Map<K, V> filter(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<K, V> newMap = new HashMap<K, V>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			if (predicate.apply(entry)) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		return newMap;
	}
	
	public static <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> map, Predicate<? super K> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<K, V> newMap = new HashMap<K, V>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			if (predicate.apply(entry.getKey())) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		return newMap;
	}
	
	public static <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<K, V> newMap = new HashMap<K, V>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			if (!predicate.apply(entry)) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		return newMap;
	}
	
	public static <K, V> Pair<K, V> find(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			if (predicate.apply(entry)) {
				return new Pair<K, V>(entry.getKey(), entry.getValue());
			}
		}
		
		return null;
	}
	
	public static <K, V> boolean forall(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
//		for (Entry<K, V> entry : map.entrySet()) {
//			if (!predicate.apply(entry)) {
//				return false;
//			}
//		}
//		
//		return true;
		return Collections.forall(map.entrySet(), predicate);
	}
	
	public static <K, V> void foreach(Map<? extends K, ? extends V> map, Function<Entry<? extends K, ? extends V>, Void> function) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
//		for (Entry<K, V> entry : map.entrySet()) {
//			function.apply(entry);
//		}
		
		Collections.foreach(map.entrySet(), function);
	}
	
	public static <K,V> V getOrElse(Map<? extends K, ? extends V> map, K key, V defaultValue) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		return map.containsKey(key) ? map.get(key) : defaultValue;
	}
	
	public static <K, V, D> Map<D, Map<K, V>> groupBy(Map<? extends K, ? extends V> map, Function<Entry<? extends K, ? extends V>, D> function) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<D, Map<K, V>> newMap = new HashMap<D, Map<K,V>>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			D key = function.apply(entry);
			newMap.putAll(add(newMap, key, add(getOrElse(newMap, key, new HashMap<K, V>()), entry.getKey(), entry.getValue())));
		}
		
		return newMap;
	}
	
	public static <K, V> Pair<K, V> head(Map<? extends K, ? extends V> map) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Entry<? extends K, ? extends V> entry = map instanceof NavigableMap ? ((NavigableMap<? extends K, ? extends V>)map).firstEntry() : map.entrySet().iterator().next();
		return new Pair<K, V>(entry.getKey(), entry.getValue());
	}
	
	public static <K, V> Map<K, V> init(Map<? extends K, ? extends V> map) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		return slice(map, 0, map.size() - 1);
	}
	
	public static <K, V> Pair<K, V> last(Map<? extends K, ? extends V> map) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Entry<? extends K, ? extends V> lastEntry = null;
		if (map instanceof NavigableMap) {
			lastEntry = ((NavigableMap<? extends K, ? extends V>)map).lastEntry();
		} else {
			Iterator<? extends Entry<? extends K, ? extends V>> iterator = map.entrySet().iterator();
		    while (iterator.hasNext()) {
		    	lastEntry = iterator.next();
		    }
		}
		
		return new Pair<K, V>(lastEntry.getKey(), lastEntry.getValue());
	}
	
	public static <K, V, K1> Map<K1, V> map(Map<? extends K, ? extends V> map, Function<? super K, ? extends K1> function) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<K1, V> newMap = new HashMap<K1, V>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			newMap.put(function.apply(entry.getKey()), entry.getValue());
		}
		
		return newMap;
	}
	
	public static <K, V, V1> Map<K, V1> mapValues(Map<? extends K, ? extends V> map, Function<? super V, ? extends V1> function) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<K, V1> newMap = new HashMap<K, V1>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			newMap.put(entry.getKey(), function.apply(entry.getValue()));
		}
		
		return newMap;
	}
	
	public static <K, V> Pair<Map<K, V>, Map<K, V>> partition(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		return new Pair<Map<K, V>, Map<K, V>>(filter(map, predicate), filterNot(map, predicate));
	}
	
	/**
	 * Selects an interval of elements. Note: might return different results for different runs, unless the underlying collection type is ordered.
	 * 
	 * @param map
	 * @param from
	 * @param until
	 * @return
	 */
	public static <K, V> Map<K, V> slice(Map<? extends K, ? extends V> map, int from, int until) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		PreConditions.checkArgument(from < until, "begin index must be less than end index.");
		PreConditions.checkArgument(until < map.size(), "end index must be less than map size (map size = " + map.size() + ")");
		
		Map<K, V> newMap = new HashMap<K, V>();
		Iterator<? extends Entry<? extends K, ? extends V>> iterator = map.entrySet().iterator();
		
		//Skip unnecessary entries
		for (int i = 0; i < from; i++) {
			iterator.next();
		}
		
		for (int i = from; i < until; i++) {
			Entry<? extends K, ? extends V> entry = iterator.next();
			newMap.put(entry.getKey(), entry.getValue());
		}
		
		return newMap;
	}
	
	public static <K, V> Map<K, V> subtract(Map<? extends K, ? extends V> map, K key) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		PreConditions.checkArgument(key != null, "No key was specified.");
		
		Map<K, V> newMap = new HashMap<K, V>();
		newMap.putAll(map);
		if (newMap.containsKey(key)) {
			newMap.remove(key);
		}
		
		return newMap;
	}
	
	public static <K, V> Map<K, V> tail(Map<? extends K, ? extends V> map) {
		return slice(map, 1, map.size());
	}
	
	/**
	 * Selects the first {@code n} elements.
	 * 
	 * @param map
	 * @param n
	 * @return
	 */
	public static <K, V> Map<K, V> take(Map<? extends K, ? extends V> map, int n) {
		return slice(map, 0, n);
	}
	
	/**
	 * Splits this list into two at a given position.
	 * 
	 * @param map
	 * @param index
	 * @return
	 */
	public static <K, V> Pair<Map<K, V>, Map<K, V>> splitAt(Map<? extends K, ? extends V> map, int index) {
		return new Pair<Map<K, V>, Map<K, V>>(slice(map, 0, index), slice(map, index, map.size()));
	}
	
	/**
	 * Selects last {@code n} elements.
	 * 
	 * @param map
	 * @param n
	 * @return
	 */
	public static <K, V> Map<K, V> takeRight(Map<? extends K, ? extends V> map, int n) {
		return slice(map, map.size() - n, map.size());
	}
	
	/**
	 * Takes longest prefix of elements that satisfy a predicate.
	 * 
	 * @param predicate
	 * @return
	 */
	public static <K, V> Map<K, V> takeWhile(Map<? extends K, ? extends V> map, Predicate<Entry<? extends K, ? extends V>> predicate) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		Map<K, V> newMap = new HashMap<K, V>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			if (!predicate.apply(entry)) {
				break;
			}
			
			newMap.put(entry.getKey(), entry.getValue());
		}
		
		return newMap;
	}
	
//	/**
//	 * Converts this immutable map to an array.
//	 * 
//	 * @param map
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static <K, V> Pair<K, V>[] toArray(Map<K, V> map) {
//		List<Pair<K, V>> list = toList(map);
//		return list == null ? null : list.toArray(new Pair[list.size()]);
//	}
	
	/**
	 * Converts the map to a list.
	 * 
	 * @param map
	 * @return
	 */
	public static <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> map) {
		PreConditions.checkArgument(map != null, "No map was specified.");
		
		List<Pair<K, V>> listPairs = new ArrayList<Pair<K,V>>();
		for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
			listPairs.add(new Pair<K, V>(entry.getKey(), entry.getValue()));
		}
		
		return listPairs;
	}
}
