package com.dbs.jdbc.SpringDatabaseDemo.database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.dbs.jdbc.SpringDatabaseDemo.model.Employee;
@Repository
public class EmpDB {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertEmployee(Employee emp)
	{
		String sql = "insert into employee values(?,?,?)";
		this.jdbcTemplate.update(sql, emp.getEid(), emp.getCity(), emp.getEname());
		return true;
	}
	
	public List<Employee> getAllEmployees(){
		
		return this.jdbcTemplate.query("select * from employee",new EmpMapper());
		
	}


	 public Employee getEmployeeById(int eid){
	        
		 String sql="select * from employee where eid=?";
	     return this.jdbcTemplate.queryForObject(sql, new EmpMapper(),eid);
	    }
	 
	class EmpMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee e1 = new Employee();
			e1.setCity(rs.getString(2));
			e1.setEid(rs.getInt(1));
			e1.setEname(rs.getString("ename"));
			return e1;
		}
		
	}
	
	
}