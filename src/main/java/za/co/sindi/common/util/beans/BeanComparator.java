/**
 * 
 */
package za.co.sindi.common.util.beans;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

import za.co.sindi.common.utils.Beans;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;

/**
 * Code sampled from <a href="http://stackoverflow.com/questions/1814095/sorting-an-arraylist-of-contacts-based-on-name#answer-1814112">this SO question.</a> and/or <a href="http://grepcode.com/file/repo1.maven.org/maven2/commons-beanutils/commons-beanutils/1.9.2/org/apache/commons/beanutils/BeanComparator.java/">Apache BeanUtils BeanComparator</a>.
 * 
 * @author Bienfait Sindi
 * @since 26 October 2015
 *
 */
public class BeanComparator<T> implements Comparator<T> {

	private String propertyName;

	/**
	 * @param propertyName
	 */
	public BeanComparator(final String propertyName) {
		super();
		PreConditions.checkArgument(!Strings.isNullOrEmpty(propertyName), "No Bean property name was supplied.");
		this.propertyName = propertyName;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		try {
			Object value1 = Beans.getPropertyValue(o1, propertyName);
			Object value2 = Beans.getPropertyValue(o2, propertyName);
			return ((Comparable<Object>)value1).compareTo(value2);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("IllegalAccessException", e);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("InvocationTargetException", e);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("IntrospectionException", e);
		}
	}
}
