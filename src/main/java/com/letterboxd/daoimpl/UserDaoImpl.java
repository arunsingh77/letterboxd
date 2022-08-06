package com.letterboxd.daoimpl;

import java.sql.ResultSet;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.letterboxd.dao.UserDao;
import com.letterboxd.model.User;
import com.letterboxd.util.SqlConstants;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User getUser(int userId) {
		Object[] names= {userId};
		int[] types= {Types.INTEGER};
		User user = jdbcTemplate.query(SqlConstants.GET_USER_QUERY,names,types,(ResultSet rs)->{
			if(rs.next()) {
				return new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("phn_no"),rs.getString("status"));
			}
			else {
				return null;
			}
			
		});
		
		return user;
	}

	@Override
	public String addUer(User user) {
		Object[] names= {user.getUserId(),user.getUserName(),user.getPhnNo(),user.getStatus()};
		int[] types= {Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		jdbcTemplate.update(SqlConstants.ADD_USER_QUERY,names,types);
		
		return "Done";
	}

	@Override
	public String updateUser(User user) {
		Object[] names= {user.getUserName(),user.getPhnNo(),user.getStatus(),user.getUserId()};
		int[] types= {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		jdbcTemplate.update(SqlConstants.UPDATE_USER_QUERY,names,types);
		
		return "Done";
	}

}
