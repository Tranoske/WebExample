package model;

public class Gengou {
	private int gengou;
	private int nen;
	public Gengou(int gengou, int nen) {
		this.gengou = gengou;
		this.nen = nen;
	}
	public int getGengou() {
		return gengou;
	}
	public void setGengou(int gengou) {
		this.gengou = gengou;
	}
	public int getNen() {
		return nen;
	}
	public void setNen(int nen) {
		this.nen = nen;
	}

	public int getSeireki() {
		int seireki = 0;
		if(gengou == 1) {
			seireki = 1926+nen-1;
		}else if(gengou == 2) {
			seireki = 1989+nen-1;
		}else if(gengou == 3) {
			seireki = 2019+nen-1;
		}else {
			seireki = 0;
		}

		return seireki;
	}

	public  String getName() {
		String name = null;
		if(gengou == 1) {
			name = "昭和";
		}else if(gengou == 2) {
			name = "平成";
		}else if(gengou == 3) {
			name = "令和";
		}else {
			name = "エラー";
		}
		return name;
	}

}
