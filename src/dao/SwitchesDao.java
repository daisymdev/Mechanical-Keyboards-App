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

}
