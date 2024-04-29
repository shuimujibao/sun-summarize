package guazi.third;

/**
 * @description: 输出1-100所有质数
 * @author: xy.sun06
 * @create: 2024-04-26 16:07
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExamOne {
	public static void main(String[] args) {
		allPrimeNumber(100);
	}

	private static void allPrimeNumber(int n) {
		for (int i = 2; i < n; i++) {
			//在这里立一个旗帜
			boolean flag = true;
			//这里要注意j要从2开始，如果从1开始则i除j可以一直除尽，所以上面的i也要从2开始，并且j必须要小于i
			for (int j = 2; j < i; j++) {
				//当i不是质数的时候将flag改为false，并结束循环
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {//flag的值没有被修改，说明i是质数
				System.out.print(i + " ");
			}
		}
	}
}
