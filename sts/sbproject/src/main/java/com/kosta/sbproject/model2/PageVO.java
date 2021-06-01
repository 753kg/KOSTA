package com.kosta.sbproject.model2;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Getter;

@Getter
public class PageVO {

	private static final int DEFAULT_SIZE = 10;		// 한 페이지에 몇 건
	private static final int DEFAULT_MAX_SIZE = 50;	// 한 페이지에 최대 50건
	
	int page;
	int size;
	String type;		// 조회 조건(제목, 내용, 작성자)
	String keyword;		// 조회할 값
	
	public PageVO() {
		this.page = 1;
		this.size = DEFAULT_SIZE;
	}
	
	// setter 직접 구현
	public void setPage(int page) {
		this.page = page < 0 ? 1 : page;
	}
	
	public void setSize(int size) {
		this.size = (size < DEFAULT_SIZE || size > DEFAULT_MAX_SIZE) ? DEFAULT_SIZE : size;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Pageable makePaging(int direction, String... props) {
		Sort.Direction dir = direction == 0 ? Sort.Direction.DESC : Sort.Direction.ASC;
		return PageRequest.of(this.page - 1, this.size, dir, props);
	}
}