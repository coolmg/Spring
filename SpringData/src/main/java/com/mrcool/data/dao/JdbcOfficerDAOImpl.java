package com.mrcool.data.dao;

import com.mrcool.data.entities.Officer;
import com.mrcool.data.entities.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class JdbcOfficerDAOImpl implements OfficerDAO {

	private final JdbcTemplate jdbcTemplate;

	private final SimpleJdbcInsert simpleJdbcInsert;

	private final RowMapper<Officer> officerMapper = (ResultSet rs, int rowNum) -> new Officer(rs.getInt("id"), // Java
																												// 8
																												// lambda
																												// expression
			Rank.valueOf(rs.getString("rank")), rs.getString("first_name"), rs.getString("last_name"));

	@Autowired
	public JdbcOfficerDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("officers")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public Officer save(Officer officer) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("rank", officer.getRank());
		parameters.put("first_name", officer.getFirstName());
		parameters.put("last_name", officer.getLastName());
		Integer newId = (Integer) this.simpleJdbcInsert.executeAndReturnKey(parameters);
		officer.setId(newId);
		return officer;
	}

	@Override
	public Optional<Officer> findById(Integer id) {
		try (Stream<Officer> stream = jdbcTemplate.queryForStream("select * from officers where id=?", officerMapper,
				id)) {
			return stream.findAny();
		}
	}

	@Override
	public List<Officer> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM officers", officerMapper);
	}

	@Override
	public long count() {
		return this.jdbcTemplate.queryForObject("select count(*) from officers", Long.class);
	}

	@Override
	public void delete(Officer officer) {
		this.jdbcTemplate.update("DELETE FROM officers WHERE id=?", officer.getId());
	}

	@Override
	public boolean existsById(Integer id) {
		return Boolean.TRUE.equals(this.jdbcTemplate.queryForObject("SELECT EXISTS(SELECT 1 FROM officers where id=?)",
				Boolean.class, id));
	}

}
