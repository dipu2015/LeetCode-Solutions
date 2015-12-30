/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int m = 0;
        for (int i=0; i<32; i++) {
            int bit = n & 1;
            n >>= 1;
            m = (m << 1) + bit;
        }
        return m;
    }
}

/*
优化方案：
参考：https://oj.leetcode.com/discuss/27338/8ms-c-code-some-ideas-about-optimization-spoiler
以4位为单位执行反转，将0x0至0xF的反转结果预存在一个长度为16的数组中，反转时直接查询即可。
*/
