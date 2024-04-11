package genshuixue.second;

import lombok.Data;

import java.util.List;

/**
 * @description: 目录对象
 * @author: xy.sun06
 * @create: 2024-04-01 08:23
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
@Data
public class DirectoryVo {

	private Integer bankId;

	private List<DirectoryVo> children;

	private String href;

	private String id;

	private Integer open;

	private Integer parentId;

	private String title;
}
