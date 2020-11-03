package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Switches;

public class SwitchesDao {
	
	private Connection connection;
	private final String GET_SWITCHES_BY_CASE_ID_QUERY = "SELECT * FROM switches WHERE case_id_fk = ?";
	private final String DELETE_SWITCHES_BY_CASE_ID_QUERY = "DELETE FROM switches WHERE case_id_fk = ?";
	private final String CREATE_NEW_SWITCHES_QUERY = "INSERT INTO switches(manufacturer, terms, name, case_id_fk) VALUES(?, ?, ?, ?)";
	private final String DELETE_SWITCHES_BY_SWITCH_ID_QUERY = "DELETE FROM switches WHERE switches_id_pk = ?";
	
	public SwitchesDao() {
		connection = DBConnection.getConnection();
	}

	public List<Switches> getSwitchesByCaseId(int caseId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SWITCHES_BY_CASE_ID_QUERY);
		ps.setInt(1,  caseId);
		ResultSet rs = ps.executeQuery();
		List<Switches> switches = new ArrayList<Switches>();
		
		while (rs.next()) {
			switches.add(new Switches(rs.getInt(1), rs.getString(2)));
		}
		return switches; 
	}
	
	public void deleteSwitchesByCaseId(int caseId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SWITCHES_BY_CASE_ID_QUERY);
		ps.setInt(1, caseId);
		ps.executeUpdate();
	}
	
	public void createNewSwitches(String manufacturer, String terms, String name, int caseId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_SWITCHES_QUERY);
		ps.setString(1, manufacturer);
		ps.setString(2, terms);
		ps.setString(3, name);
		ps.setInt(4, caseId);
		ps.executeUpdate();
	}
	
	public void deleteSwitchesbySwitchId(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SWITCHES_BY_SWITCH_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
