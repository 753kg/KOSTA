package com.kosta.day14;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	List<Board> boardList = new ArrayList<Board>();
	
	public List<Board> getBoardList(){
		boardList.add(new Board("제목1", "내용1"));
		boardList.add(new Board("제목2", "내용2"));
		boardList.add(new Board("제목3", "내용3"));
		
		return boardList;
	}
}
