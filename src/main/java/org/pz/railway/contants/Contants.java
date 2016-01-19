package org.pz.railway.contants;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Contants {
	public static final String NOT_BLANK_MESSAGE = "这个值不能为空！";
	public static Map<Integer, String> TYPES = null;
	public static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static Map<Integer, String> ROLES = null;
	
	public final static String ADMIN = "ADMIN";
	public final static String USER = "USER";
	public final static String MEMBER = "MEMBER";
	public final static String LEADER = "LEADER";
	public final static String CONTROLLER = "CONTROLLER";
	
	public final static String ROLE_ADMIN = "ROLE_" + ADMIN;
	public final static String ROLE_USER = "ROLE_" + USER;
	public final static String ROLE_MEMBER = "ROLE_" + MEMBER;
	public final static String ROLE_LEADER = "ROLE_" + LEADER;
	public final static String ROLE_CONTROLLER = "ROLE_" + CONTROLLER;
	
	public final static Integer ROLE_ADMIN_ID = 100;
	public final static Integer ROLE_USER_ID = 0;
	public final static Integer ROLE_MEMBER_ID = 10;
	public final static Integer ROLE_LEADER_ID = 20;
	public final static Integer ROLE_CONTROLLER_ID = 30;
	
	static {		
		TYPES = new HashMap<Integer, String>();
		TYPES.put(0, "无");
		TYPES.put(1, "集团");
		TYPES.put(2, "公司");
		TYPES.put(3, "分公司");
		TYPES.put(4, "部门");
		TYPES.put(5, "班");
		TYPES.put(6, "组");
		
		ROLES = new HashMap<Integer, String>();
		ROLES.put(ROLE_USER_ID, "其他");
		ROLES.put(ROLE_MEMBER_ID, "组员");
		ROLES.put(ROLE_LEADER_ID, "组长");
		ROLES.put(ROLE_CONTROLLER_ID, "控制室");
	}
}
