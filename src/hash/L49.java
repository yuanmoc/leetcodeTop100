package hash;

import utils.StringUtil;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class L49 {

    public static void main(String[] args) {
        String[] randomStringArray = StringUtil.getRandomStringArray(3, 20000);
        List<List<String>> lists = groupAnagrams(randomStringArray);
        for (List<String> list : lists) {
            if (list.size() > 1) {
                System.out.println(list);
            }
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 位数 + 字符大小
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(str);
            map.put(key, strings);
        }
        return new ArrayList<>(map.values());
    }
}
