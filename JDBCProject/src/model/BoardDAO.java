package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import util.LoggableStatement;

public class BoardDAO {
	// board insert
	// board select
	public List<BoardVO> selectAll() {
		List<BoardVO> boardlist = new ArrayList<>();
		
		String sql = "select * from board order by 1";
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO board = makeBoard(rs);
				boardlist.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return boardlist;
	}
	
	public BoardVO selectByNo(int board_seq) {
		BoardVO board = null;
		
		String sql = "select * from board where board_seq = ?";
		// String sql2 = "update board set board_viewcount = board_viewcount + 1 where board_seq = ?";
		String sql2 = "update board set board_viewcount = nvl(board_viewcount, 0) + 1 where board_seq = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			//updateViewCount(board_seq);
			st = new LoggableStatement(conn, sql2);
			//st = conn.prepareStatement(sql2);
			st.setInt(1, board_seq);
			st.executeUpdate();
			
			st = new LoggableStatement(conn, sql);
			//st = conn.prepareStatement(sql);
			st.setInt(1, board_seq);
			rs = st.executeQuery();

			System.out.println("SQL문 확인:" + ((LoggableStatement) st).getQueryString());
			while(rs.next()) {
				board = makeBoard(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return board;
	}
	
	public int insertBoard(BoardVO board) {
		int result = 0;
		String sql = "insert into board values(board_no_sequence.nextval, ?, ?, ?, sysdate, 0, ?, ?)";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, board.getBoard_title());
			st.setString(2, board.getBoard_contents());
			st.setInt(3, board.getBoard_writer());
			//st.setDate(4, board.getBoard_date());
			//st.setInt(4, board.getBoard_viewcount());
			st.setString(4, board.getBoard_password());
			st.setString(5, board.getBoard_image());
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		
		return result;
	}
	
	// board update
	public int updateBoard(int board_seq, String board_password, 
			String board_title, String board_contents, String board_image) {
		int result = 0;
		String sql = 
				" update board" +
				" set board_title = ?, board_contents = ?, board_image = ?, board_date = sysdate" +
				" where board_seq = ? and board_password = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			
			st.setString(1, board_title);
			st.setString(2, board_contents);
			st.setString(3, board_image);
			st.setInt(4, board_seq);
			st.setString(5, board_password);

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		
		return result;
	}
	
//	public void updateViewCount(int board_seq) {
//		String sql = 
//				" update board" +
//				" set board_viewcount = board_viewcount + 1" +
//				" where board_seq = ?";
//		
//		Connection conn = DBUtil.getConnection();
//		PreparedStatement st = null;
//		
//		try {
//			st = conn.prepareStatement(sql);
//			st.setInt(1, board_seq);
//			st.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.dbClose(null, st, conn);
//		}
//		
//		
//	}
	
	// board delete
	public int deleteBoard(int board_seq, String board_password) {
		
		String sql = 
				" delete from board" +
				" where board_seq = ? and BOARD_PASSWORD = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		int result = 0;
		
		// 비밀번호 같은지 확인
		// BoardVO board = selectByNo(board_seq);
		
		try {
			// if(!board.getBoard_password().equals(board_password)) throw new SQLException("[알림]비밀번호 오류");
			st = conn.prepareStatement(sql);
			st.setInt(1, board_seq);
			st.setString(2, board_password);
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		
		return result;
	}
	// board id로 select... view count 증가해야함... update set

	private BoardVO makeBoard(ResultSet rs) throws SQLException {
		// ResultSset에서 읽어서 VO 객체를 만든다.
		BoardVO board = new BoardVO();
		board.setBoard_seq(rs.getInt("board_seq"));
		board.setBoard_title(rs.getString("board_title"));
		board.setBoard_contents(rs.getString("board_contents"));
		board.setBoard_writer(rs.getInt("board_writer"));
		board.setBoard_date(rs.getDate("board_date"));
		board.setBoard_viewcount(rs.getInt("board_viewcount"));
		board.setBoard_password(rs.getString("board_password"));
		board.setBoard_image(rs.getString("board_image"));
		return board;
	}
}
