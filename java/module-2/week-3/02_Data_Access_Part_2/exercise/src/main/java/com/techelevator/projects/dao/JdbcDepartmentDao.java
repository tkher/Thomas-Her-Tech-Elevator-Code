package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT +
				" WHERE d.department_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				department = mapRowToDepartment(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect to Database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data violation", e);
		}
		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect to Database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data violation", e);
		}
		
		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		Department newDepartment = new Department();

		try {
			String sql = "INSERT INTO department (name) " +
					"VALUES (?) " +
					"RETURNING department_id;";

			int newDeptmentId = jdbcTemplate.queryForObject(sql, int.class, department.getName());
			newDepartment = getDepartmentById(newDeptmentId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect to Database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data violation", e);
		}
		return newDepartment;
//		throw new DaoException("createDepartment() not implemented");
	}

	@Override
	public Department updateDepartment(Department department) {
		Department updateDepartment = null;

		try {
			String sql = "UPDATE department SET department_id=?, name=?;";
			int numberOfRows = jdbcTemplate.update(sql, department.getId(), department.getName());

			if (numberOfRows == 0) {
				throw new DaoException("No rows returned");
			} else {
				updateDepartment = getDepartmentById(department.getId());
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect to Database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data violation", e);
		}

		return updateDepartment;
	}

	@Override
	public int deleteDepartmentById(int id) {
		int numberOfRows = 0;

		String sql = "DELETE FROM department " +
				"WHERE department_id = ?;";

		try {
			numberOfRows = jdbcTemplate.update(sql, id);
		}catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect to Database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data violation", e);
		}

		return numberOfRows;
	}


	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
