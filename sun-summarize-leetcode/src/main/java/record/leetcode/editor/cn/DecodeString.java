package record.leetcode.editor.cn;

//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
// 示例 1：
//
//
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//
//
// 示例 2：
//
//
//输入：s = "3[a2[c]]"
//输出："accaccacc"
//
//
// 示例 3：
//
//
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//
//
// 示例 4：
//
//
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 30
//
// s 由小写英文字母、数字和方括号
// '[]' 组成
// s 保证是一个 有效 的输入。
// s 中所有整数的取值范围为
// [1, 300]
//
//
// Related Topics 栈 递归 字符串 👍 1718 👎 0

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString{
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	// 字符入栈
	// stackInput = 3[a2[c]]
	// stackOutput =  null
	// ======================
	// ======================
	// stackInput 开始出栈
	// stackInput中 ] 出栈，此时stackOutput为空，直接入栈， 此时stackOutput = ]
	// stackInput中 ] 出栈，字符集合charCollection为空时，非符号字符直接入栈，
	//                     反之检查与stackOutput中的最近入栈的符号latestChar是否匹配，未匹配成功，直接入栈，此时stackOutput = ]]
	// stackInput中 c 出栈，字符集合charCollection为空时，非符号字符直接入栈，
	//                     反之检查与stackOutput中的最近入栈的符号latestChar是否匹配，未匹配成功，直接入栈，此时stackOutput = c]]
	// stackInput中 [ 出栈，字符集合charCollection为空时，非符号字符直接入栈，
	//                     反之检查与stackOutput中的最近入栈的符号latestChar是否匹配，匹配成功，stackOutput开始出栈直至最近入栈的符号，
	//                     并记录此期间出栈的字符集合charCollection=c，此时stackOutput = ]
	// stackInput中 2 出栈， 字符集合charCollection不为空时，循环charCollection再次写入stackOutput栈中，此时stackOutput = c c ]
	// stackInput中 a 出栈， 字符集合charCollection为空时，非符号字符直接入栈，，此时stackOutput = a c c ]
	// stackInput中 [ 出栈， 字符集合charCollection为空时，非符号字符直接入栈，
	//                      反之检查与stackOutput中的最近入栈的符号latestChar是否匹配，匹配成功,stackOutput开始出栈直至最近入栈的符号，
	//                      并记录此期间出栈的字符集合charCollection=acc，此时stackOutput =
	// stackInput中 3 出栈   字符集合charCollection不为空时，循环charCollection再次写入stackOutput栈中，此时stackOutput = a c c a c c a c c
	// ===stackOutput出栈反转即为结果==
    public String decodeString(String s) {
	    // 字符串入栈记录
	    Stack<Character> stackInput = new Stack<>();
	    // 字符串出栈记录
	    Stack<Character> stackOutput = new Stack<>();

	    // 字符入栈
	    char[] charArray = s.toCharArray();
	    for (char c : charArray) {
		    stackInput.add(c);
	    }

	    // stackInput中最近出栈符号
	    LinkedList<Character> latestChar = new LinkedList<>();
	    // stackOutput中最近等待循环的字符串
	    StringBuilder repeatChar = new StringBuilder();

	    while (!stackInput.isEmpty()) {

		    Character pop = stackInput.pop();

		    if (stackOutput.isEmpty()) {
			    stackOutput.push(pop);
			    continue;
		    }

		    // 一、stackInput出栈字符非符号 && repeatChar不为空，此时pop必为数字
		    if (!this.isFuHaoChar(pop) && repeatChar.length() > 0) {
			    // 循环组织字符串
			    int times = pop - '0';
			    for (; times > 0; times--) {
				    repeatChar.append(repeatChar);
			    }
			    // 再次入栈
			    int length = repeatChar.length();
			    while (length > 0) {
				    stackOutput.add(repeatChar.charAt(length--));
			    }
		    }

		    // 二、stackInput出栈字符非符号 && repeatChar为空，此时直接入栈
		    if (!this.isFuHaoChar(pop) && repeatChar.length() == 0) {
			    stackOutput.add(pop);
		    }

		    // 三、stackInput出栈字符为符号 && 与stackOutput存在符号匹配
		    if (this.isFuHaoChar(pop) && this.isMatch(pop, latestChar.getFirst())) {
			    Character stopFuHao = latestChar.getFirst();
			    while (stackOutput.peek() != stopFuHao) {
				    repeatChar.append(stackOutput.peek());
			    }
			    latestChar.removeFirst();
		    }

		    // 四、stackInput出栈字符为符号 && 与stackOutput不存在符号匹配
		    if (this.isFuHaoChar(pop) && !this.isMatch(pop, latestChar.getFirst())) {
			    stackOutput.add(pop);
			    latestChar.add(pop);
		    }
	    }

	    StringBuilder res = new StringBuilder();
	    while (!stackOutput.isEmpty()) {
		    res.append(stackOutput.pop());
	    }
	    return res.reverse().toString();
    }

	/**
	 * 判断当前字符是否是符号
	 *
	 * @param s 字符
	 * @return Boolean
	 */
	private Boolean isFuHaoChar(Character s) {
		return s == '[' || s == ']';
	}

	/**
	 * 检查当前两字符是否为匹配的括号
	 *
	 * @param s1 左括号
	 * @param s2 右括号
	 * @return Boolean
	 */
	private Boolean isMatch(Character s1, Character s2) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('[', ']');
		return map.get(s1).equals(s2);
	}


	/**
	 * 创建数字栈，在遍历编码字符串过程中记录出现的数字
	 * Deque<Integer> numStack = new LinkedList<>();
	 * <p>
	 * 创建字符栈，在遍历编码字符串过程中记录出现的字符串
	 * Deque<StringBuilder> strStack = new LinkedList<>();
	 * <p>
	 * 输入字符串 3[a2[c]]
	 * <p>
	 * 遍历到3  计算出 digit = 3
	 * 遍历到[  numStack栈中,此时为digit = 3，strStack栈中res此时为空，重置digit && res
	 * 遍历到a  res新增a
	 * 遍历到2  计算出 digit = 2
	 * 遍历到[  numStack栈中,此时为3->2,strStack栈中为a,重置digit && res
	 * 遍历到c  res新增c
	 * 遍历到]  numStack出栈2，
	 *
	 *
	 *
	 *
	 * <a href="https://blog.algomooc.com/LeetCode/%E7%AC%AC%E4%B8%80%E5%91%A8/%E7%AC%AC%E5%85%AD%E5%A4%A9/LeetCode%20394%E3%80%81%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%A7%A3%E7%A0%81.html#%E4%B8%80%E3%80%81%E9%A2%98%E7%9B%AE%E6%8F%8F%E8%BF%B0">...</a>
	 *
	 * @param s 待解码字符串
	 * @return String
	 */
	public String decodeString2(String s) {
		// 创建数字栈，在遍历编码字符串过程中记录出现的数字
		Deque<Integer> numStack = new LinkedList<>();

		// 创建字符栈，在遍历编码字符串过程中记录出现的字符串
		Deque<StringBuilder> strStack = new LinkedList<>();

		// 在访问编码字符串的过程中，用来记录访问到字符串之前出现的数字，一开始为 0
		int digit = 0;

		// 在访问编码字符串的过程中，把得到的结果存放到 res 中
		StringBuilder res = new StringBuilder();

		// 从头到尾遍历编码字符串
		for (int i = 0; i < s.length(); i++) {

			// 在遍历过程中，字符会出现 4 种情况

			// 先获取此时访问的字符
			char ch = s.charAt(i);

			// 1、如果是数字，需要把字符转成整型数字
			// 注意数字不一定是 1 位，有可能是多位
			// 比如 123a，在字母 a 的前面出现了 123，表示 a 重复出现 123 次
			// 那么一开始 ch 为 1，当访问到 ch 为 2 的时候，1 和 2 要组成数字 12
			// 再出现 3 ，12 和 3 组成数字 123
			if (Character.isDigit(ch)) {

				// 先将字符转成整型数字 ch-‘0’
				// 补充知识：将字符'0'-'9'转换为数字，只需将字符变量减去'0'就行
				// 因为字符和数字在内存里都是以 ASCII 码形式存储的
				// 减去 '0' ，其实就是减去字符 '0' 的 ASCII 码，而字符 '0' 的 ASCII 码是 30
				// 所以减去'0'也就是减去30，然后就可以得到字符对应的数字了。
				int num = ch - '0';

				// 再将这个数字和前面存储的数字进行组合
				// 1 和 2 组成数字 12，也就是 1 * 10 + 2 = 12
				// 12 和 3 组成数字 123，也就是 12 * 10 + 3 = 123
				digit = digit * 10 + num;

				// 2、如果是字符
			} else if ((ch >= 'a' && ch <= 'z')) {

				// 说明它就出现一次，可以直接存放到 res 中
				res.append(ch);

				// 3、如果是"["
				// 出现了嵌套的内层编码字符串，而外层的解码需要等待内层解码的结果
				// 那么之前已经扫描的字符需要存放起来，等到内层解码之后再重新使用
			} else if (ch == '[') {

				// 把数字存放到数字栈
				numStack.push(digit);

				// 把外层的解码字符串存放到字符串栈
				strStack.push(res);

				// 开始新的一轮解码
				// 于是，digit 归零
				digit = 0;

				// res 重新初始化
				res = new StringBuilder();

				// 4、如果是"]"
			} else if (ch == ']') {

				// 此时，内层解码已经有结果，需要把它和前面的字符串进行拼接

				// 第一步，先去查看内层解码的字符串需要被重复输出几次
				// 比如 e3[abc]，比如内层解码结果 abc 需要输出 3 次
				// 通过数字栈提取出次数
				int count = numStack.poll();

				// 第二步，通过字符串栈提取出之前的解码字符串
				StringBuilder outString = strStack.poll();

				// 第三步，不断的把内层解码的字符串拼接起来
				for (int j = 0; j < count; j++) {

					// 拼接到 outString 后面，拼接 count 次
					outString.append(res.toString());
				}

				// 再把此时得到的结果赋值给 res
				res = outString;
			}
		}

		// 返回解码成功的字符串
		return res.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
