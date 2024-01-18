package model;

import java.util.ArrayList;

public class ThiSinhModel
{
	private ArrayList <ThiSinh> dsThiSinh;
	private boolean updateButton;
	private String fileName;
	
	public ThiSinhModel()
	{
		this.dsThiSinh= new ArrayList<ThiSinh>();
		this.updateButton=false;
		this.fileName="";
	}

	public ThiSinhModel(ArrayList<ThiSinh> dsThiSinh) {

		this.dsThiSinh = dsThiSinh;
		this.fileName="";
		this.updateButton=false;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ThiSinh selected(int index)
	{
		return dsThiSinh.get(index);
	}
	
	public void add(ThiSinh ts)
	{
		this.dsThiSinh.add(ts);
	}
	
	public void delete(int index)
	{
		this.dsThiSinh.remove(index);
	}
	
	public void update(ThiSinh thiSinh, int index)
	{
		dsThiSinh.set(index, thiSinh);
	}
	
	public void setUpdateButton(boolean check)
	{
		this.updateButton=check;
	}
	
	public boolean getUpdateButton()
	{
		return updateButton;
	}

	public int check(String maThiSinh) {
		if (dsThiSinh.size()>0)
		for (int i=0; i<dsThiSinh.size(); i++)
			if (dsThiSinh.get(i).getMaThiSinh().equals(maThiSinh))
				return i;
		
		return -1;
	}
	
	
}
