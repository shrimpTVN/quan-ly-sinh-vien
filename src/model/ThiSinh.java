package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ThiSinh implements Serializable
{
	private String maThiSinh;
	private String hoVaTen;
	private Tinh queQuan;
	private Date ngaySinh;
	private boolean GioiTinh;
	private float diem1, diem2, diem3;

	public ThiSinh()
	{
		
	}
	
	public ThiSinh(String maThiSinh,String hoVaTen, Tinh queQuan, Date ngaySinh, boolean gioiTinh, float diem1,
			float diem2, float diem3) {

		this.maThiSinh = maThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.hoVaTen = hoVaTen;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
	}

	public String getMaThiSinh() {
		return maThiSinh;
	}

	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	public Tinh getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public float getDiem1() {
		return diem1;
	}

	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}

	public float getDiem2() {
		return diem2;
	}

	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}

	public float getDiem3() {
		return diem3;
	}

	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}

	
	@Override
	public String toString() {
		return "ThiSinh [maThiSinh=" + maThiSinh + ", hoVaTen=" + hoVaTen + ", queQuan=" + queQuan + ", ngaySinh="
				+ ngaySinh + ", GioiTinh=" + GioiTinh + ", diem1=" + diem1 + ", diem2=" + diem2 + ", diem3=" + diem3
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(GioiTinh, diem1, diem2, diem3, hoVaTen, maThiSinh, ngaySinh, queQuan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThiSinh other = (ThiSinh) obj;
		return GioiTinh == other.GioiTinh && Float.floatToIntBits(diem1) == Float.floatToIntBits(other.diem1)
				&& Float.floatToIntBits(diem2) == Float.floatToIntBits(other.diem2)
				&& Float.floatToIntBits(diem3) == Float.floatToIntBits(other.diem3)
				&& Objects.equals(hoVaTen, other.hoVaTen) && Objects.equals(maThiSinh, other.maThiSinh)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(queQuan, other.queQuan);
	}
	
	
	
}
