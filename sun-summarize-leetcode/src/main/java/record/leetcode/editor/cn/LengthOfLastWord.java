package record.leetcode.editor.cn;
//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为 5。
//
//
// 示例 2：
//
//
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为 4。
//
//
// 示例 3：
//
//
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为 6 的“joyboy”。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅有英文字母和空格 ' ' 组成
// s 中至少存在一个单词
//
//
// Related Topics字符串
//
// 👍 721, 👎 0
//
//
//
//

public class LengthOfLastWord {
	public static void main(String[] args) {
		Solution solution = new LengthOfLastWord().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLastWord(String s) {
			int len = s.length();
			if (len == 0) return 0;
			// 倒着遍历
			int index = len - 1;
			// 跳过末尾的空格
			while (index >= 0 && s.charAt(index) == ' ') {
				index--;
			}
			// 记录最后一个word的长度
			int lastWordLength = 0;
			while (index >= 0 && s.charAt(index) != ' ') {
				lastWordLength++;
				index--;
			}
			return lastWordLength;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
