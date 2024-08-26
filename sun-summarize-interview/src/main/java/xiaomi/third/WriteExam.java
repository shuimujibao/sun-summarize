package xiaomi.third;

/**
 * @description: 2147483647-> 二十一亿四千七百四十八万三千六百四十七
 * @author: xy.sun06
 * @create: 2024-08-26 08:18
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExam {


	/**
	 * 数组转中文
	 * <p>
	 * 1.数字单位转换拼接
	 * 2.数组切割，每四位一组
	 * 每一组数字 前缀0保留一个，尾缀0删除
	 *
	 * @param n 数字
	 * @return String
	 */
	private static String numberToChineseWithFourBit(int n) {
		StringBuilder result = new StringBuilder();

		// 单位
		String[] units = {"", "十", "百", "千", "万", "十", "百", "千", "亿"};

		// 数字
		String[] digits = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

		// 进制基准
		int unitPoint = 10;
		int unitIndex = 0;

		// 0出现标志
		boolean flag = Boolean.TRUE;

		while (n > 0) {
			// 计算每位的数字和其对应的单位
			int digit = (n % unitPoint) / (unitPoint / 10);
			int unit = unitIndex;

			// 获取当前位的数字和单位对应的汉字
			String digitChinese = digits[digit];
			String unitChinese = units[unit];

			// 当前位等于0，每四位处理一次； part=0是四位数的最后一位，part=3是四位数的第一位；前缀0保留一个，尾缀0删除
			int part = unitIndex % 4;

			if (unitChinese.equals(units[4])
				|| unitChinese.equals(units[8])) {
				flag = Boolean.TRUE;
			}

			if (digit == 0 && part == 0) {
				result.append(unitChinese);
			}
			if (digit == 0 && part != 0 && flag) {
				result.append(digitChinese);
				flag = Boolean.FALSE;
			}

			// 当前位不等于0，直接拼接
			if (digit != 0) {
				result.append(unitChinese);
				result.append(digitChinese);
			}

			// 减去已经处理的位对应的值
			n = n - digit * unitPoint / 10;

			// 获取下一位基准
			unitIndex++;
			unitPoint = unitPoint * 10;
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		int maxValue = 100002060;
		System.out.println(maxValue);
		System.out.println(WriteExam.numberToChineseWithFourBit(maxValue));
	}
}
