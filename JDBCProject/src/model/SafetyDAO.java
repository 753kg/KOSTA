package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;


public class SafetyDAO {
	public int countSafetyByLoc(String location_name) {
		int result = 0;
		List<String> names = new ArrayList<String>();
		String sql = 
				"select count(*) from SAFETY_RESTAURANTS where location_name = (select village from hotplaces where hotplace_name = '연신내' )";

		Connection conn = DBUtil.getConnection();
		//PreparedStatement st = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//st = conn.prepareStatement(sql);
			//st.setString(1, location_name);
			//rs = st.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
				//names.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return result;
	}
}
