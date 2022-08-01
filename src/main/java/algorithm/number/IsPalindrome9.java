package algorithm.number;

/**
 * 题目：9. 回文数
 * 解题思路：
 * 1. %取最后一位
 * 2. 新的后半段数字 = 上一个后半段*10+x%10
 * 3. 前半段数字丢弃最后一位x=x%10
 * 4. 后半段大于或者等于前半段就是要判断两个数字是否相等了
 */
public class IsPalindrome9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int lastNum = 0;
        while (lastNum < x) {
            lastNum = lastNum * 10 + x % 10;
            x = x / 10;
        }

        return x == lastNum || lastNum / 10 == x;
    }
}
