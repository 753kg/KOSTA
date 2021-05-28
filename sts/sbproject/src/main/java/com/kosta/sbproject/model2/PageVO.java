package com.kosta.sbproject.model2;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Getter;

@Getter
public class PageVO {

	private static final int DEFAULT_SIZE = 3;		// 한 페이지에 몇 건
	private static final int DEFAULT_MAX_SIZE = 50;	// 한 페이지에 최대 50건
	
	int page;
	int size;
	
	public PageVO() {
		this.page = 1;
		this.size = DEFAULT_SIZE;
	}
	
	public void setPage(int page) {
		this.page = page < 0 ? 1 : page;
	}
	
	public void setSize(int size) {
		this.size = (size < DEFAULT_SIZE || size > DEFAULT_MAX_SIZE) ? DEFAULT_SIZE : size;
	}

	public Pageable makePaging(int direction, String... props) {
		Sort.Direction dir = direction == 0 ? Sort.Direction.DESC : Sort.Direction.ASC;
		return PageRequest.of(this.page - 1, this.size, dir, props);
	}
}