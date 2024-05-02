package Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IdRetriever<T> {

    public int getId(T obj) {
        try {
            Method getIdMethod = obj.getClass().getMethod("getId");

            return (int) getIdMethod.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return -1;
        }
    }
}