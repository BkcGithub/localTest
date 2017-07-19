package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkc on 25/04/2017.
 */
public class FeebList {
    public static List<Integer> fibonacci(int n) {

        List<Integer> returnList = new ArrayList<Integer>();
        if (n == 0) {
            returnList.add(0);
            return returnList;
        }
        int start = 0;
        int end = 1;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = start + end;
            returnList.add(result);
            start = end;
            end = result;
        }
        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(11));
    }
}
