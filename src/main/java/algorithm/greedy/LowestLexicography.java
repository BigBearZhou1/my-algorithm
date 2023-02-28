package algorithm.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestLexicography {
    /**
     * 深度优先遍历
     * 找出所有的组合可能
     * 比较这些组合的字典序中最小的
     * @param strs 字符串集合
     * @return 字典序最小的全排列字符串
     */
    public String lowestStringDfs(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        List<String> all = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        process(all, used, "", strs);
        String lowest = all.get(0);
        for (int i = 1; i < all.size(); i++) {
            if (lowest.compareTo(all.get(i)) > 0) {
                lowest = all.get(i);
            }
        }
        return lowest;
    }

    private void process(List<String> all, Set<Integer> used, String cur, String[] strs) {
        if (used.size() == strs.length) {
            all.add(cur);
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                process(all, used, cur + strs[i], strs);
                used.remove(i);
            }
        }
    }
}
