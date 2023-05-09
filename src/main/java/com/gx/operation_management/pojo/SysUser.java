package com.gx.operation_management.pojo;



import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;


	private String username;


	private String password;


	private String name;


	private String phone;


	private String headUrl;

	private Long deptId;

	private Long postId;


	private String description;


	private String openId;


	private Integer status;


	private String postName;
	//部门

	private String deptName;
}

