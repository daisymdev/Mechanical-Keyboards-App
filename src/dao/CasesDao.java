package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cases;

public class CasesDao {
	
	private static Connection connection;
	private static SwitchesDao switchesDao;
	private final static String GET_CASES_QUERY = "SELECT * FROM cases";

	public CasesDao() {
		connection = DBConnection.getConnection();
		switchesDao = new SwitchesDao();
	}
	
	public List<Cases> getCases() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CASES_QUERY).executeQuery();
		List<Cases> Cases = new ArrayList<Cases>();
		
		while (rs.next()) {
			Cases.add(populateCase(rs.getInt(1), rs.getString(2)));
		}
		
		return Cases;
	}
	
	private Cases populateCase(int id, String material) throws SQLException{
		return new Cases(id, material, switchesDao.getSwitchesByCaseId(id));
	}
}
