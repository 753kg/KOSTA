package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long>{
	
	// pdsno는 entity에 없음. DB에만 존재
	// sql문장에 자동으로 들어감
	@Query(value = "select b.pid, count(f) "
			+ " from PDSBoard b left outer join b.file2 f "
			+ " group by b.pid")
	public List<Object[]> countFileByBoardNo();

	@Query(value = "select b.pid, b.pname, b.pwriter, f.fno, f.pdsfilename"
			+ " from PDSBoard b left outer join b.file2 f ")
	public List<Object[]> getBoardWithFile();
	
	// board에서 첨부파일(pdsfile) 수정하기
	// update문장 작성시에는 @Modifying 필요
	@Modifying
	@Query("update from PDSFile f set f.pdsfilename = ?2 where f.fno = ?1")
	public int updatePDSFile(long fno, String fname);
}
