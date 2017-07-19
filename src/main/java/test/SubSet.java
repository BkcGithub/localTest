package test;

import java.util.ArrayList;

/**
 * Created by bkc on 26/04/2017.
 */
public class SubSet {
    public static void main(String[] args) {
        int i = 2 << 3;
        System.out.println(i);
        System.out.println(5&1);
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> subList) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << subList.size();
        for (int i = 0; i < max; i++) {
            int index = 0;
            int temp = i;
            ArrayList<Integer> currentCharList = new ArrayList<Integer>();
            while (temp > 0) {
                if ((temp & 1) > 0) {
                    currentCharList.add(subList.get(index));
                }
                temp >>= 1;
                index++;
            }
            allsubsets.add(currentCharList);
        }
        return allsubsets;
    }
}
