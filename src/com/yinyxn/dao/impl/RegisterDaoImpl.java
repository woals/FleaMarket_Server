package com.yinyxn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yinyxn.dao.RegisterDao;
import com.yinyxn.utils.DBUtils;
import com.yinyxn.vo.Register;

public class RegisterDaoImpl implements RegisterDao{

	Connection con = DBUtils.getConnetion();
	
	@Override
	public boolean userRegister(Register register) {
		
		String sql = "insert into userRegister values(seq_register.NEXTVAL,?,?,?,default)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, register.getName());
			pst.setString(2, register.getPassword());
			pst.setString(3, register.getPhone());
			int n = pst.executeUpdate();
			if (n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
