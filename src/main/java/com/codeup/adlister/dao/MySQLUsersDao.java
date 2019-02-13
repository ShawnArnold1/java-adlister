package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users
{

    private Connection connection = null;

    public MySQLUsersDao(Config config)
    {
        try
        {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Error connecting to the database!", e);
        }

    }

    @Override
    public User findByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return showUser(rs);
    }






    private User showUser(ResultSet rs)
    {
        User user = new User();
        try
        {
            user.setId(rs.getLong(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;

    }



    @Override
    public Long insert(User user) throws SQLException
    {
        String query = "insert into users(username, password, email) values (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);

    }
}
