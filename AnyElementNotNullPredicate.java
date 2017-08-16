package java321254.com.predicate;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.apache.commons.collections4.Predicate;

public class AnyElementNotNullPredicate<T> implements Predicate<T>, Serializable{

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 9000200860282119942L;
 
  /** The Constant INSTANCE. */
  @SuppressWarnings("rawtypes")
  public static final Predicate INSTANCE = new AnyElementNotNullPredicate<Object>();


  /**
   * Not null element predicate.
   *
   * @param <T> the generic type
   * @return the predicate
   */
  @SuppressWarnings("unchecked")
  public static <T> Predicate<T> anyElementNotNullPredicate() {
      return (Predicate<T>) INSTANCE;
  }


  /**
   * Instantiates a new not null element predicate.
   */
  private AnyElementNotNullPredicate() {
      super();
  }

  /* (non-Javadoc)
   * @see org.apache.commons.collections4.Predicate#evaluate(java.lang.Object)
   */
  public boolean evaluate(final T object) {
    if(object == null) return false;
    for (Field f : object.getClass().getDeclaredFields()) {
      f.setAccessible(true);
      try {
        Object value = f.get(object);
        if (value != null) return true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /**
   * Read resolve.
   *
   * @return the object
   */
  private Object readResolve() {
    return INSTANCE;
  }
}

