package lecture.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import lecture.model.LectureDao;
import lecture.vo.Lecture;

public class LectureService {

	private LectureDao ldao = new LectureDao();
	
	public LectureService() {
		
	}
	
	public Lecture loginCheck(String id, String pw) {
		Connection conn = getConnection();
		Lecture member = ldao.loginCheck(conn, id, pw);
		close(conn);
		return member;
	}

	public int insertLecture(Lecture member) {
		Connection conn =getConnection();
		int result = ldao.insertLecture(conn, member);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Lecture selectLecture(String userid) {
		
		Connection conn = getConnection();
		Lecture member = ldao.selectLecture(conn, userid);
		close(conn);
		return member;
		
	}

	public int deleteLecture(String id) {
		Connection conn = getConnection();
		
		int result = ldao.deleteLecture(conn, id);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateLecture(Lecture member) {
		Connection conn = getConnection();
		int result = ldao.updateLecture(conn, member);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Lecture> selectList() {
		Connection conn = getConnection();
		ArrayList<Lecture> result = ldao.selectList(conn);
		close(conn);
		return result;
	}

	public int upadateLoginOK(String userid, String loginok) {
		Connection conn = getConnection();
		int result = ldao.updateLoginOK(conn, userid, loginok);
		if (result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Lecture> selectSearchUserid(String keyword) {
		Connection conn = getConnection();
		ArrayList<Lecture> result = ldao.selectSearchUserid(conn, keyword);
		close(conn);
		return result;
	}

	public ArrayList<Lecture> selectSearchGender(String keyword) {
		Connection conn = getConnection();
		ArrayList<Lecture> result = ldao.selectSearchGender(conn, keyword);
		close(conn);
		return result;
	}

	public ArrayList<Lecture> selectSearchAge(String keyword) {
		Connection conn = getConnection();
		ArrayList<Lecture> result = ldao.selectSearchAge(conn, keyword);
		close(conn);
		return result;
	}

	public ArrayList<Lecture> selectSearchEnroll(Date begin, Date end) {
		Connection conn = getConnection();
		ArrayList<Lecture> result = ldao.selectSearchEnroll(conn, begin, end);
		close(conn);
		return result;
	}

	public ArrayList<Lecture> selectSearchLoginok(String keyword) {
		Connection conn = getConnection();
		ArrayList<Lecture> result = ldao.selectSearchLoginok(conn, keyword);
		close(conn);
		return result;
	}

	public int selectCheckId(String userid) {
		Connection conn = getConnection();
		int idcount = ldao.selectCheckId(conn,userid);
		close(conn);
		return idcount;
	}
}
