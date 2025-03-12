package com.learning.SpringSecurity.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.learning.SpringSecurity.dao.UserDetailsDao;
import com.learning.SpringSecurity.domain.User;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String GET_USER = "SELECT * FROM users WHERE userName = :name";
	private static final String SAVE_USER = "INSERT INTO users (userName, password) VALUES (:name, :password)";

	@Override
	public User getUserDetailsByUserName(String userName) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", userName);
		return namedParameterJdbcTemplate.queryForObject(GET_USER, params, new BeanPropertyRowMapper<>(User.class));
	}

	@Override
	public User register(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", user.getUserName());
		params.addValue("password", user.getPassword());
		namedParameterJdbcTemplate.update(SAVE_USER, params, keyHolder, new String[] { "id" });
		Number generatedId = keyHolder.getKey();
		if (generatedId != null) {
			user.setId(generatedId.intValue());
		}

		return user;
	}

}
