package structure.link;

/**
 * LinkNodeManager
 *
 * @summary LinkNodeManager
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年08月23日 16:06:00
 */
public class LinkNodeManager {

	/**
	 * 当前链表
	 */
	private ListNode head;

	/**
	 * 实例化
	 *
	 * @return LinkNodeManager
	 */
	public static LinkNodeManager builder() {
		return new LinkNodeManager();
	}

	/**
	 * 新增当前结点的下一个结点
	 *
	 * @param nextVal 结点值
	 * @return LinkNodeManager
	 */
	public LinkNodeManager addNextNode(int nextVal) {
		if (head == null) {
			head = new ListNode(nextVal);
		}
		ListNode newNode = new ListNode(nextVal);

		head.setNext(newNode);

		return this;
	}

	/**
	 * 获取当前链表
	 *
	 * @return ListNode
	 */
	public ListNode build() {
		return this.head;
	}
}
