package com.snr.javaweb.dao;

import com.snr.javaweb.entity.Member;

public interface MemberDao {
	int insert(String id, String string, String name, String phone, String email);
	Member get(String id);
	int insert(Member member);
}
