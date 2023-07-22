package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = PROJECT_SELECT +
				" WHERE p.project_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			if (results.next()) {
				project = mapRowToProject(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect to Database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data violation", e);
		}

		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = PROJECT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Project projectResult = mapRowToProject(results);
				allProjects.add(projectResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}

		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		Project createdProject = new Project();

		String sql = "INSERT into project (name, from_date, to_date) " +
				"VALUES (?,?,?) " +
				"RETURNING project_id;";

		try {
			int newProjectID = jdbcTemplate.queryForObject(sql, int.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());

			createdProject = getProjectById(newProjectID);

		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}

	return createdProject;
	}
	
	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee (employee_id, project_id)  " +
				"VALUES (?, ?); ";

		try {
			jdbcTemplate.update(sql, employeeId, projectId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Cannot connect", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}

	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		int numberOfRows = 0;

		String sql = "DELETE FROM project_employee " +
				"WHERE project_id = ? AND employee_id = ?; ";

		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}

//		return numberOfRows;
	}

	@Override
	public Project updateProject(Project project) {
		Project updatedProject = null;

		String sql = "UPDATE project SET project_id = ?, name = ?, from_date = ?, to_date =?;";

		try {
			jdbcTemplate.update(sql, project.getId(), project.getName(), project.getFromDate(), project.getToDate());

			updatedProject = getProjectById(project.getId());
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
		return updatedProject;
	}
	@Override
	public int deleteProjectById(int projectId) {
		int numberOfRows = 0;

		String sql = "DELETE FROM project WHERE project_id = ?;";

		try {
			numberOfRows = jdbcTemplate.update(sql, projectId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}

		return numberOfRows;

	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
