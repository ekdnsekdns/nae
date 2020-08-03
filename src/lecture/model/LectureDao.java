package lecture.model;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import lecture.vo.Lecture;

public class LectureDao {

	public LectureDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Lecture loginCheck(Connection conn, String userid, String userpwd) {
		Lecture member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where userid = ? and userpwd = ? and login_ok = 'Y'";
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Lecture();
				
	
				
				//System.out.println(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public int insertLecture(Connection conn, Lecture member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?,sysdate,sysdate, default)";
		
		try {
			pstmt = conn.prepareStatement(query);

			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public Lecture selectLecture(Connection conn, String userid) {
		
		Lecture member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Lecture m = new Lecture();
	
				
				member = m;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
	
		return member;
	}

	public int deleteLecture(Connection conn, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from member where userid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateLecture(Connection conn, Lecture member) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = "update member set userpwd = ?, age = ?, "
				+ " phone = ?, username = ?, gender = ?, email = ?, hobby = ?, etc = ?, lastmodified = sysdate "
				+ "where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);

			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Lecture> selectList(Connection conn) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Lecture m = new Lecture();

				
				list.add(m);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int updateLoginOK(Connection conn, String userid, String loginok) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update member set login_ok = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginok);
			pstmt.setString(2, userid);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}

	public ArrayList<Lecture> selectSearchUserid(Connection conn, String keyword) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where userid like ?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "%" + keyword + "%" );
			rset = stmt.executeQuery();
			while(rset.next()) {
				Lecture m = new Lecture();

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Lecture> selectSearchGender(Connection conn, String keyword) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where gender like ?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "%" + keyword + "%");
			rset = stmt.executeQuery();
			while(rset.next()) {
				Lecture m = new Lecture();
	
				
				list.add(m);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Lecture> selectSearchAge(Connection conn, String keyword) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String query = "select * from member where age between ? and ?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(keyword));
			stmt.setInt(2, Integer.parseInt(keyword) + 9);
			rset = stmt.executeQuery();
			while(rset.next()) {
				Lecture m = new Lecture();
	
				
				list.add(m);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Lecture> selectSearchEnroll(Connection conn, Date begin, Date end) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where enroll_date between ? and ?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setDate(1, begin);
			stmt.setDate(2, end);
			rset = stmt.executeQuery();
			while(rset.next()) {

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Lecture> selectSearchLoginok(Connection conn, String keyword) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where login_ok = ?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			rset = stmt.executeQuery();
			while(rset.next()) {

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int selectCheckId(Connection conn, String userid) {
		int idcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(userid) from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				idcount = rset.getInt(1);
				System.out.println("idcnt : " + idcount);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return idcount;
	}

}
