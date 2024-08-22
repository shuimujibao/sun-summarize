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
}
//leetcode submit region end(Prohibit modification and deletion)

}
