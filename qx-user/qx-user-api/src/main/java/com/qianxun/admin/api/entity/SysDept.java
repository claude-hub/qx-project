package com.qianxun.admin.api.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Data //set get
@Accessors(chain=true) //链式调用
public class SysDept implements Serializable// entity --orm--- db_table
{
	private Integer id;
	private Integer parentId;
	private Integer sort;
	private Date createdAt;
	private Date updatedAt;
	private Integer status;
	private String dbSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
}
