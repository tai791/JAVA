
public class Diem {
	int sbd;
	String ten, gender, chonTh;
	float toan, van, anh, tohop;
	public Diem() {
		
	}
	public Diem(int sbd, String ten, String gender, String chonTh, float toan, float van, float anh, float tohop ) {
		this.sbd = sbd;
		this.ten = ten;
		this.gender = gender;
		this.chonTh = chonTh;
		this.toan = toan;
		this.van = van;
		this.anh = anh;
		this.tohop = tohop;
	}
	public int getSbd() {
		return sbd;
	}
	public void setId(int sbd) {
		this.sbd = sbd;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getChonTh() {
		return chonTh;
	}
	public void setChonTh(String chonTh) {
		this.chonTh = chonTh;
	}
	public float getToan() {
		return toan;
	}
	public void setToan(float toan) {
		this.toan = toan;
	}
	public float getVan() {
		return van;
	}
	public void setVan(float van) {
		this.van = van;
	}
	public float getAnh() {
		return anh;
	}
	public void setAnh(float anh) {
		this.anh = anh;
	}
	public float getTohop() {
		return tohop;
	}
	public void setTohop(float tohop) {
		this.tohop = tohop;
	}

}


