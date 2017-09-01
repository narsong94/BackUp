package com.snr.javaweb.dao;

import java.util.List;

import com.snr.javaweb.entity.Notice;
import com.snr.javaweb.entity.NoticeView;

public interface NoticeDao {
	List<NoticeView> getList(int page, String query);
	int getCount();
	NoticeView get(String id);
	int update(String id, String title, String content);
	int insert(String title, String content);
}
