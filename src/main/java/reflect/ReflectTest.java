package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String[] args)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException,
        InvocationTargetException {
        Class mclass = Class.forName("reflect.UserInfo");

        System.out.println("---输出---");
        System.out.println(mclass.getName());
        System.out.println(mclass.getSimpleName());


        Field[] fields = mclass.getFields();

        System.out.println("---输出所有属性---");
        for (Field field : fields) {
            String fieldName = field.getName();
            Class type = field.getType();
            int access = field.getModifiers();

            System.out.println(access + "-" + type + "-" + fieldName);

        }

        System.out.println("---输出所有方法---");
        Method[] methods = mclass.getMethods();

        for (Method method : methods) {
            String methodName = method.getName();      //方法名称
            int methodFangWen = method.getModifiers(); //访问修饰符
            Class methodRetrunType = method.getReturnType();//返回类型

            Class [] methodParameter = method.getParameterTypes();//方法的参数列表
            System.out.println(Modifier.toString(methodFangWen)+" "+methodRetrunType.getSimpleName()+" "+methodName+"(");
        }

        //如何执行指定的方法
        System.out.println("------------反射执行方法--------------------");
        String name ="getMyInfo";
        Class[] parameterTypes = new Class[3];
        parameterTypes[0]= String.class;
        parameterTypes[1]= String.class;
        parameterTypes[2]= Integer.class;

        Method me = mclass.getDeclaredMethod(name, parameterTypes);
        Object obj = mclass.newInstance();
        Object[] arg = new Object[3];
        arg[0]="范晶晶";
        arg[1]="AAA风景区";
        arg[2]=new Integer(18);
        me.invoke(obj, arg);

        Method method = mclass.getDeclaredMethod("getAge");
        Object object = mclass.newInstance();
        method.invoke(object);

    }
}
