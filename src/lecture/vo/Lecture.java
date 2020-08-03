package lecture.vo;

public class Lecture implements java.io.Serializable{
	private final static long serialVersionUID = 1232342343L;
	
	private String lcode;
	private String lname;
	private String category;
	private int capacity;
	private String termno;
	private String ltime;
	private String professorid;
	private String room;
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lecture(String lcode, String lname, String category, int capacity, String termno, String ltime,
			String professorid, String room) {
		super();
		this.lcode = lcode;
		this.lname = lname;
		this.category = category;
		this.capacity = capacity;
		this.termno = termno;
		this.ltime = ltime;
		this.professorid = professorid;
		this.room = room;
	}
	@Override
	public String toString() {
		return "Lecture [lcode=" + lcode + ", lname=" + lname + ", category=" + category + ", capacity=" + capacity
				+ ", termno=" + termno + ", ltime=" + ltime + ", professorid=" + professorid + ", room=" + room + "]";
	}
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getTermno() {
		return termno;
	}
	public void setTermno(String termno) {
		this.termno = termno;
	}
	public String getLtime() {
		return ltime;
	}
	public void setLtime(String ltime) {
		this.ltime = ltime;
	}
	public String getProfessorid() {
		return professorid;
	}
	public void setProfessorid(String professorid) {
		this.professorid = professorid;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	
}
