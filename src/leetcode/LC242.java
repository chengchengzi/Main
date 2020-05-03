package leetcode;

import java.util.Arrays;

public class LC242{
    /**
     *    242.有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *。
     */

    /*
        解法1
        时间复杂度：O(nlogn)
        空间复杂度：O(s.length() + t.length())
        1. 分别将 s 和 t排序，排序都相等则为字母异位词，否则不是
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        if(s.length() == 0 || t.length() == 0){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        char[] sTmp = s.toCharArray();
        char[] tTmp = t.toCharArray();
        Arrays.sort(sTmp);
        Arrays.sort(tTmp);
        return Arrays.equals(sTmp,tTmp);
    }

    /*
        解法2：O(N), O(1)
        1、在a~z中，分别统计s和t中字母的数量，存放在一个int数组中，都相等则为true，不等的则为false
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        if(s.length() == 0 || t.length() == 0){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] != 0){
                return false;
            }
        }
        return true;
    }

}
