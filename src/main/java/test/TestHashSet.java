package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bkc on 25/04/2017.
 */
public class TestHashSet {
    public static void testHashSet(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>();
        for (Integer item : list) {
            set.add(item);
        }

        System.out.println(set);
        if (set.contains(1)) {
            System.out.println("Y");
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(5);
        testHashSet(list);

    }
}
