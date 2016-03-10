package com.yinyxn.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.yinyxn.vo.Register;


public class DBPageUtils {//数据库分页类
	
	private int max ;//最大页数
	private int total ;//数据总数
	private int page = 1 ; //当前页
	private int size = 5; //每一页数量
	private Vector<Register> datas ;
	
	Connection con = DBUtils.getConnetion();
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getPage() {
		return page ;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public Vector<Register> getDatas() {
		return datas;
	}
	public void setDatas(Vector<Register> datas) {
		this.datas = datas;
	}
	///
	public DBPageUtils(){
		try {
			String sql = "select count(*) from leaveword";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			total = rs.getInt(1);
			max = total%size ==0 ? total/size : total/size + 1;
			
		} catch (Exception e) {
			total = 0 ;
			e.printStackTrace();
		}
	}
	public Vector<Register> getAlls(int p){
		Vector<Register> vector = new Vector<Register>() ;
		try {
			if(p<=0){
				page = 1 ;
			}else if(p>max){
				page = max ;
			}else{
				page = p ;
			}
			String sql = "select * from " +
					"(select l.* , row_number() over(order by id) rn  " +
					"from leaveword l) where rn>? and rn<=?" ;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, size*(page-1));
			pst.setInt(2, size*page);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String topic = rs.getString(3);
				String content = rs.getString(4);
				String time = rs.getString(5);
				Register w = new Register(name,topic,content, time);
				w.setId(id);
				w.setTime(time);
				vector.add(w);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.datas = vector;
		return vector ;
	}

}
