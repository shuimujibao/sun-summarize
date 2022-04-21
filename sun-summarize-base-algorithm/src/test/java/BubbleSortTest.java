import org.junit.Test;
import sort.BubbleSort;

import java.util.Arrays;

/**
 * BubbleSortTest
 *
 * @summary BubbleSortTest
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月21日 15:07:00
 */
public class BubbleSortTest {

	@Test
	public void test() {
		int[] nums = new int[]{7, 5, 4, 8};
		BubbleSort.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
