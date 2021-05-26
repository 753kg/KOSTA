package com.kosta.sbproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.kosta.sbproject.model.PDSBoard;
import com.kosta.sbproject.model.PDSFile;
import com.kosta.sbproject.persistence.PDSBoardRepository;
import com.kosta.sbproject.persistence.PDSFileRepository;

import lombok.extern.java.Log;

@Commit		// @Transactional 가 rollback되지 않도록 하기
@Log
@SpringBootTest
public class PDSBoardTest {

	@Autowired
	PDSBoardRepository boardRepo;
	
	@Autowired
	PDSFileRepository fileRepo;
	
	// @Test
	public void updateBoardAndFile() {
		boardRepo.findById(220L).ifPresent(b -> {
			b.setPname("보드정보수정");
			b.setPwriter("AAA");
			List<PDSFile> flist = b.getFile2();
			PDSFile f = PDSFile.builder().pdsfilename("보드정보수정&파일추가").build();
			flist.add(f);
			// b.setFile2(flist);  	// 안해도 insert 됨...
			boardRepo.save(b);		// 단, cascade, EAGER 되어있어야함.
		});
	}
	
	//@Test
	public void updateFile() {
		fileRepo.findById(215L).ifPresent(file -> {
			file.setPdsfilename("전통적인방법으로수정");
			fileRepo.save(file);
		});
	}
	
	@Transactional	// @Query가 DML인 경우 꼭 쓰기 (insert, delete, update) 자동 rollback
	//@Test
	public void updateFileFromBoardRepo() {
		int result = boardRepo.updatePDSFile(215L, "파일이름수정함");
		log.info("update: " + result + "건");
	}
	
	// @Test
	public void getBoardWithFile() {
		boardRepo.getBoardWithFile().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
	@Test
	public void countFileByBoardNo() {
		boardRepo.countFileByBoardNo().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
	// @Test
	public void selectFileByBoardPid() {
		// board pid로 file 찾기
		boardRepo.findById(220L).ifPresent(b -> {
			log.info(b.getPname());
			log.info(b.getPwriter());
			log.info(b.toString());	// fetch = FetchType.LAZY면 실패 , EAGER면 실행
			log.info("size: " + b.getFile2().size());
		});
	}
	
	//@Test
	public void insertPDSBoardAndPDSFileByEntity() {
		// @OneToMany(cascade = CascadeType.ALL)
		// pdsboard로 pdsboard insert -> 자동으로 pdsfile entity도 insert
		IntStream.range(1, 6).forEach(i -> {
			PDSBoard board = new PDSBoard();
			board.setPname("게시글" + i);
			board.setPwriter("zz" + i);
			
			List<PDSFile> filelist = new ArrayList<>();
			IntStream.range(1, 4).forEach(j -> {
				PDSFile file = new PDSFile();
				file.setPdsfilename("zz파일" + j);
				filelist.add(file);
			});
			board.setFile2(filelist);
			
			boardRepo.save(board);
		});
	}
}
