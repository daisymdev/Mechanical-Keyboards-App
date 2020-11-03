package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cases;

public class CasesDao {
	
	private static Connection connection;
	private static SwitchesDao switchesDao;
	private final static String GET_CASES_QUERY = "SELECT * FROM cases";
	private final String GET_CASE_BY_ID_QUERY = "SELECT * FROM cases WHERE case_id_pk = ?";

	public CasesDao() {
		connection = DBConnection.getConnection();
		switchesDao = new SwitchesDao();
	}
	
	public List<Cases> getCases() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CASES_QUERY).executeQuery();
		List<Cases> Cases = new ArrayList<Cases>();
		
		while (rs.next()) {
			Cases.add(populateCase(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		return Cases;
	}
	
	public Cases getCaseById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CASE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		return populateCase(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	private Cases populateCase(int id, String material, String sizePercentage) throws SQLException{
		return new Cases(id, material, sizePercentage, switchesDao.getSwitchesByCaseId(id));
	}
}
