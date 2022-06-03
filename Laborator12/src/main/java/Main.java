import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class clazz= null;
        try {
            clazz = Class.forName("persoana.Persoana");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Metodele sunt:");
        assert clazz != null;
        Method[] metode = clazz.getDeclaredMethods();
        for (Method method : metode) {
            System.out.println(method.toString());
        }


        List<Method> teste = new ArrayList<>();
        for (Method method : metode) {
            if (method.isAnnotationPresent(Test.class) == true) {
                teste.add(method);
            }
        }
        System.out.println("Testele sunt:");
        System.out.println(teste);
        List<Method> statice = teste.stream()
                .filter(method -> Modifier.isStatic(method.getModifiers()))
                .collect(Collectors.toList());

        System.out.println("Testele statice sunt:");
        System.out.println(statice);

        for(Method m : statice)
        {
            Object retobj;
            retobj = m.invoke(new Object());
            System.out.println(retobj);
        }



    }
}
