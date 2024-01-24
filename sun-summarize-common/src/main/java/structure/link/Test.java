package structure.link;

/**
 * Test
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 * @since: 2024年01月24日 09:55:00
 */
public class Test {
	public static void main(String[] args) {
		ListNode linkNodeManager = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3).build();

		LinkNodePrint.printlnListNode(linkNodeManager);
	}
}
