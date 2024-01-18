package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Tinh implements Serializable
{
	private static ArrayList<Tinh> dsTinh;
	private String tenTinh;
	private int Matinh;
	
	public Tinh()
	{
		//this.creatDSTinh();
	}
	public Tinh(String tenTinh, int matinh) {
	
		this.tenTinh = tenTinh;
		Matinh = matinh;
		//this.creatDSTinh();
	}
	
	public String getTenTinh() {
		return tenTinh;
	}
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	public int getMatinh() {
		return Matinh;
	}
	public void setMatinh(int matinh) {
		Matinh = matinh;
	}
	
	@Override
	public String toString() {
		return "Tinh [tenTinh=" + tenTinh + ", Matinh=" + Matinh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Matinh, tenTinh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return Matinh == other.Matinh && Objects.equals(tenTinh, other.tenTinh);
	}
	
	
	public  static ArrayList<Tinh> getDSTinh()
	{
		URL url = Tinh.class.getResource("dsTinh.txt");
		String path= url.toString();
		
		//	path.replace("file:/", "");
	
		//	System.out.println(path);
		String s= path.substring(6, path.length());
		//	System.out.println(s);
		File file = new File(s);
		try {
			Scanner scan= new Scanner(file);
			dsTinh= new ArrayList<Tinh>();
			int index=0;
			while (scan.hasNext())
			{
				String name=scan.nextLine();
				Tinh tinh= new Tinh(name,index);
				dsTinh.add(tinh);
				
				index++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsTinh;
	}
	

	
}
