/**
 * 
 */
package za.co.sindi.common.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Bienfait Sindi
 * @since 27 October 2015
 *
 */
public final class Beans {

	private static final Object[] EMPTY_ARGUMENTS = {};
	
	private Beans() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static Object getPropertyValue(Object bean, String propertyName) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PreConditions.checkArgument(bean != null, "No bean has been specified.");
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if (propertyDescriptor.getName().equals(propertyName)) {
					return propertyDescriptor.getReadMethod().invoke(bean, EMPTY_ARGUMENTS);
				}
			}
		}
		
		return null;
	}
}
