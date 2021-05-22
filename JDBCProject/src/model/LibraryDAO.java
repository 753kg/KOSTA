package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class LibraryDAO {
	
	public int signUp(MemberVO member) {
		int result = 0;
		String sql = 
				" insert into members(m_id, m_pass, m_name, birth, phone)" +
				" values(?, ?, ?, ?, ?)";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, member.getM_id());
			st.setString(2, member.getM_pass());
			st.setString(3, member.getM_name());
			st.setDate(4, member.getBirth());
			st.setString(5, member.getPhone());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		
		return result;
	}
	
	public int quitMembers(String userID, String userPW) {
		int result = 0;
		String sql = "delete from members where m_id = ? and m_pass = ? and borr_count = 0";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userID);
			st.setString(2, userPW);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
	
	public int logIn(String userID, String userPW) {
		int result = 0;
		String sql = "select * from members where m_id = ? and m_pass = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userID);
			st.setString(2, userPW);
			rs = st.executeQuery();
			
			if(rs.next()) result = 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
				
		return result;
	}
	
	public List<BookVO> selectAll(){
		List<BookVO> booklist = new ArrayList<>();
		
		String sql = 
				" select b_code, b_name, author, pub, pub_date, cover, "+
				" b_status, return_date, rsv_status" +
				" from search_books_view";
				
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				BookVO book = makeBookVO(rs);
				booklist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return booklist;
	}
	
	public List<BookVO> selectByBookName(String bookName){
		List<BookVO> booklist = new ArrayList<>();
		
		String sql = 
				" select b_code, b_name, author, pub, pub_date, cover, " +
				" b_status, return_date, rsv_status" +
				" from search_books_view" +
			    " where b_name like '%'||?||'%'";
				
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, bookName);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BookVO book = makeBookVO(rs);
				booklist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return booklist;
	}
	
	public List<BookVO> selectByAuthor(String author){
		List<BookVO> booklist = new ArrayList<>();
		
		String sql = 
				" select b_code, b_name, author, pub, pub_date, cover, " +
				" b_status, return_date, rsv_status" +
				" from search_books_view" +
			    " where author like '%'||?||'%'";
				
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, author);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BookVO book = makeBookVO(rs);
				booklist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return booklist;
	}
	
	public List<BookVO> selectByCategory(String category){
		List<BookVO> booklist = new ArrayList<>();
		
		String sql = 
				" select b_code, b_name, author, pub, pub_date, cover, " +
				" b_status, return_date, rsv_status" +
				" from search_books_view" +
			    " where category like '%'||?||'%'";
				
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, category);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BookVO book = makeBookVO(rs);
				booklist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return booklist;
	}
	
	public String borrowBook(int b_code, String userID) {
		String message = null;
		String sql = "{call borrow(?, ?, ?)}";
		
		Connection conn = DBUtil.getConnection();
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall(sql);
			st.registerOutParameter(3, java.sql.Types.VARCHAR);
			st.setInt(1, b_code);
			st.setString(2, userID);
			st.executeQuery();
			
			message = st.getString(3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return message;
	}
	
	public String returnBook(int b_code, String m_id) {
		String message = null;
		String sql = "{call returnBook(?, ?, ?)}";
		
		Connection conn = DBUtil.getConnection();
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall(sql);
			st.registerOutParameter(3, java.sql.Types.VARCHAR);
			st.setInt(1, b_code);
			st.setString(2, m_id);
			st.executeQuery();
			
			message = st.getString(3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return message;
	}
	
	public String rsvBook(int b_code, String m_id) {
		String message = null;
		String sql = "{call rsvBook(?, ?, ?)}";
		
		Connection conn = DBUtil.getConnection();
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall(sql);
			st.registerOutParameter(3, java.sql.Types.VARCHAR);
			st.setInt(1, b_code);
			st.setString(2, m_id);
			st.executeQuery();
			
			message = st.getString(3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return message;
	}
	
	public String rsvBookReturn(int b_code, String m_id) {
		String message = null;
		String sql = "{call rsvBookReturn(?, ?, ?)}";
		
		Connection conn = DBUtil.getConnection();
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall(sql);
			st.registerOutParameter(3, java.sql.Types.VARCHAR);
			st.setInt(1, b_code);
			st.setString(2, m_id);
			st.executeQuery();
			
			message = st.getString(3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return message;
	}
	
	public String rsvBookBorrow(String m_id) {
		String message = null;
		String sql = "{call rsvBookBorrow(?, ?)}";
		
		Connection conn = DBUtil.getConnection();
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall(sql);
			st.registerOutParameter(2, java.sql.Types.VARCHAR);
			st.setString(1, m_id);
			st.executeQuery();
			
			message = st.getString(2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return message;
	}
	
	public BorrowVO selectRsvBook(String m_id){
		// 대출코드, 책 이름, 작가, 빌린날짜, 반납날짜, 대출상태
		BorrowVO borr = null;
		String sql = "select borr_code, b_code, b_name, author, borr_date, return_date, borr_status, rsv_member "
				+ " from borrows join books using(b_code)"
				+ " where rsv_member = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, m_id);
			rs = st.executeQuery();
			while(rs.next()) {
				borr = makeBorrVO(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		
		return borr;
	}
	
	// 대출내역조회
	public List<BorrowVO> selectBorrowing(String m_id){
		// 대출코드, 책 이름, 작가, 빌린날짜, 반납날짜, 대출상태
		List<BorrowVO> borrlist = new ArrayList<>();
		String sql = 
				" select borr_code, b_code, b_name, author, borr_date, return_date, borr_status, rsv_member" +
				" from borrowing_view join books using(b_code)" +
				" where m_id = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, m_id);
			rs = st.executeQuery();
			while(rs.next()) {
				BorrowVO borr = makeBorrVO(rs);
				borrlist.add(borr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		
		return borrlist;
	}
	
	public List<BorrowVO> selectBorrHistory(String m_id){
		List<BorrowVO> borrlist = new ArrayList<>();
		
		String sql = 
				" select borr_code, b_code, b_name, author, borr_date, return_date, borr_status, rsv_member" +
				" from borrows join books using(b_code)" +
				" where m_id = ?" +
				" order by return_date desc";
				
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, m_id);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BorrowVO borr = makeBorrVO(rs);
				borrlist.add(borr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return borrlist;
	}
	
	public int extendsDate(int b_code, String m_id) {
		int result = 0;
		String sql = 
				" update borrowing_view" +
				" set return_date = return_date + 7" +
				" where b_code = ? and m_id = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, b_code);
			st.setString(2, m_id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
	
	
	
	public int updateMember(String pw, String phone, String m_id) {
		int result = 0;
		String sql = 
				" update members" +
				" set m_pass = ?, phone = ?" +
				" where m_id = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, pw);
			st.setString(2, phone);
			st.setString(3, m_id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
	
	private BorrowVO makeBorrVO(ResultSet rs) throws SQLException {
		BorrowVO borr = new BorrowVO();
		borr.setBorr_code(rs.getInt("borr_code"));
		borr.setB_code(rs.getInt("b_code"));
		borr.setB_name(rs.getString("b_name"));
		borr.setAuthor(rs.getString("author"));
		borr.setBorr_date(rs.getDate("borr_date"));
		borr.setReturn_date(rs.getDate("return_date"));
		borr.setBorr_status(rs.getString("borr_status"));
		borr.setRsv_member(rs.getString("rsv_member"));
		return borr;
	}
	

	private BookVO makeBookVO(ResultSet rs) throws SQLException {
		BookVO book = new BookVO();
		book.setB_code(rs.getInt("b_code"));
		book.setB_name(rs.getString("b_name"));
		book.setAuthor(rs.getString("author"));
		book.setPub(rs.getString("pub"));
		book.setPub_date(rs.getDate("pub_date"));
		book.setCover(rs.getString("cover"));
		book.setB_status(rs.getString("b_status"));
		book.setReturn_date(rs.getString("return_date"));
		book.setRsv_status(rs.getString("rsv_status"));
		return book;
	}
}
