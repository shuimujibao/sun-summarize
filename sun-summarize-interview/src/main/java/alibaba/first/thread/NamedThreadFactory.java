package alibaba.first.thread;

import java.util.concurrent.ThreadFactory;

/**
 * 集成线程工厂重写
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年03月30日 10:58:00
 */
public class NamedThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		return null;
	}
}
