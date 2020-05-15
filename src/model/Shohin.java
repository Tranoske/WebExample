package model;

public class Shohin {
	private int sid;
	private String sname;
	private int tanka;
//	こんすとらくた
	public Shohin() {
	}
	public Shohin(int sid, String sname, int tanka) {
		this.sid = sid;
		this.sname = sname;
		this.tanka = tanka;
	}
//	げったーせったー
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return sname;
	}
	public void setName(String name) {
		this.sname = name;
	}
	public int getTanka() {
		return tanka;
	}
	public void setTanka(int tanka) {
		this.tanka = tanka;
	}

}
