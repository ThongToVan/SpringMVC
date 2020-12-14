/**
 * 
 */
package se.iuh.edu.vn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import se.iuh.edu.vn.beans.Employee;

/**
 * @author ToThong
 *
 */
public class EmployeeDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee p) {
		String sql = "insert into Employee(NAME,SALARY,DESIGNATION) values('" + p.getName() + "'," + p.getSalary()
				+ ",'" + p.getDesignation() + "')";

		return template.update(sql);

	}

	public int update(Employee p) {

		String sql = "update Employee set name='" + p.getName() + "',salary=" + p.getSalary() + ",designation='"
				+ p.getDesignation() + "'where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from Employee where id= " + id + "";
		return template.update(sql);

	}

	public Employee getEmpById(int id) {
		String sql = "select * from Employee where id=?";
		// return template.queryForObject(sql, new Object[] {id});
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public List<Employee> getEmployee() {
		return template.query("select * from Employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub

				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}

		});

	}

}
