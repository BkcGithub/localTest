package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by bkc on 26/04/2017.
 */
public class FindMinChildLink {
    public static List<String> findMinStr(String str, Set<String> set) {

        if (null == str) {
            return new ArrayList<String>();
        }

        int version = 0;
        int tmpVersion = 0;
        int preIndex = 0;

        Set<String> tmpSet = new HashSet<String>();

        Map<Integer, List<String>> countStrMap = new HashMap<Integer, List<String>>();

        int count = str.length();
        for (int i = preIndex; i < count; i++) {
            if (set.contains(String.valueOf(str.charAt(i)))) {
                if (tmpSet.size() == 0) {
                    preIndex = i;
                }

                tmpSet.add(String.valueOf(str.charAt(i)));
                if (tmpSet.size() == set.size()) {
                    tmpVersion++;

                    if (!countStrMap.containsKey(i - preIndex)) {
                        countStrMap.put(i - preIndex, new ArrayList<String>());
                    }

                    countStrMap.get(i - preIndex).add(str.substring(preIndex, i + 1));

                    preIndex++;
                    i = preIndex;
                    tmpSet.clear();
                    continue;
                }
            }

            if (i == count - 1 && tmpVersion == version) {
                break;
            }
        }

        if (countStrMap.size() == 0) {
            return new ArrayList<String>();
        }

        int minCount = 26;
        for (Map.Entry<Integer, List<String>> entry : countStrMap.entrySet()) {
            if (entry.getKey() < minCount) {
                minCount = entry.getKey();
            }
        }

        return countStrMap.get(minCount);
    }

    public static void main(String[] args) {

        List<String> list = findMinStr("dkaokctpcdbdcnaabc", new HashSet<String>() {{
            add("a");
            add("b");
            add("c");
        }});

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(findMinStrs("dkaokctpcdbdcnaabc", new HashSet<String>() {{
            add("a");
            add("b");
            add("c");
        }}));
    }

    public static String findMinStrs(String str, Set<String> set) {
        if (null == str || "".equals(str)) {
            return null;
        }
        List<String> ret = null;

        int strLength = str.length();
        int startGoal = 0;
        int endGoal = 0;
        Set<String> tmpSet = new HashSet<String>();
        Map<Integer,String> map = new TreeMap<Integer, String>();
        for (int i = startGoal; i < strLength; i++) {
            String s = String.valueOf(str.charAt(i));
            if (set.contains(s) && !tmpSet.contains(s)) {
                if (tmpSet.size() == 0) {
                    startGoal = i;
                }
                endGoal = i;
                tmpSet.add(String.valueOf(str.charAt(i)));
            }
            if (set.size() == tmpSet.size()) {
                map.put(endGoal - startGoal,str.substring(startGoal,endGoal+1));
            } else {
                continue;
            }
            tmpSet.clear();
            i = startGoal;
        }

        int minCount = 26;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() < minCount) {
                minCount = entry.getKey();
            }
        }

        return map.get(minCount);
    }
}
