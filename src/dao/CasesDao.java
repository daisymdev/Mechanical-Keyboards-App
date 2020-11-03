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
	private final String CREATE_NEW_CASE_QUERY = "INSERT INTO cases(material, size_percentage) VALUES(?, ?)";
	private final String DELETE_CASE_BY_ID_QUERY = "DELETE FROM cases WHERE case_id_pk = ?";

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
		ResultSet rs = ps.executeQuery(); //queries that only select
		rs.next();
		
		return populateCase(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	public void createNewCase(String caseName, String sizePercentage) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CASE_QUERY);
		ps.setString(1, caseName);
		ps.setString(2, sizePercentage);
		ps.executeUpdate(); //queries that create, update, or delete

	}
	
	public void deleteCaseById(int id) throws SQLException {
		switchesDao.deleteSwitchesByCaseId(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_CASE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Cases populateCase(int id, String material, String sizePercentage) throws SQLException{
		return new Cases(id, material, sizePercentage, switchesDao.getSwitchesByCaseId(id));
	}
}
