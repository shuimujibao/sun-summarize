package discount;

import lombok.Getter;

/**
 * UpShiftEnum
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 11:21:00
 */
@Getter
public enum UpShiftEnum {
	UP(0, "升档"),

	DOWN(1, "降档"),

	NONE(2, "无优惠");

	private Integer value;
	private String name;

	UpShiftEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
}
