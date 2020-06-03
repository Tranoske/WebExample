package model;

import java.sql.Timestamp;

public class Kban {
	private int kid;
	private Timestamp hi;
	private String name;
	private String bun;
	public Kban(int kid, Timestamp hi, String name, String bun) {
		this.kid = kid;
		this.hi = hi;
		this.name = name;
		this.bun = bun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBun() {
		return bun;
	}
	public void setBun(String bun) {
		this.bun = bun;
	}
	public int getKid() {
		return kid;
	}
	public Timestamp getHi() {
		return hi;
	}
}
