package test;

import com.alibaba.fastjson.JSONObject;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bkc on 25/04/2017.
 */
public class Test {
    public static Object getProperty(Object owner, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class ownerClass = owner.getClass();

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(owner);

        return property;

    }

    static void functionA() {

    }

    public static void main(String[] args) {

        try {
            System.out.println(getProperty(new Test(), "str"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Integer i = 127;

        System.out.println(Integer.reverse(i));

        String str = "a0123456bkc123";

        System.out.println(str.codePointAt(0));
        System.out.println(str.hashCode());
        /*String[] s = {"aa", "sss", "ddd", "fff", "ggg", "hhhh"};
        int[] a = {3, 1, 2};

        List<String> list = Arrays.asList(s);

        int intLen = a.length;

        int index = 0;
        for (int i = 0; i < intLen; i++) {
            System.out.println(list.subList(index,index + a[i]));;
            index = a[i];
        }*/


        /*JSONObject object = new JSONObject();
        Map<String, List<String>> map =new HashMap<String,List<String>>();
        System.out.println(map.get("ss"));

        Set<Integer> setPre = new LinkedHashSet<Integer>();
        setPre.add(1);
        setPre.add(2);
        setPre.add(3);
        setPre.add(4);
        Set<Integer> setNext = new LinkedHashSet<Integer>();
        setNext.add(1);
        setNext.add(3);
        setNext.add(4);

        Set<Integer> ser = new HashSet<Integer>();
        ser.addAll(setPre);
        ser.addAll(setNext);
        System.out.println(ser);
        Collection intersection = CollectionUtils.intersection(setPre,setNext);

        System.out.println(intersection);
*/


        /*Calendar calstart = Calendar.getInstance();
        SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
        try {
            calstart.setTime(DATEFORMAT.parse("2017-07-05"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(calstart.get(Calendar.DAY_OF_WEEK));
        int w = calstart.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        calstart.add(Calendar.DATE, -w);

        System.out.println(calstart.getTime());*/

        Integer.valueOf(1);
        int i6 = 128;
        Integer i7 = 128;
        System.out.println(i6 == i7);




    }
}
