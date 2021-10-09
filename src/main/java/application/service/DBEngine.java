package application.service;

import application.model.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBEngine {
    public DBEngine() {
        connection = connect();
    }

    public boolean isConnected() {
        return (connection != null);
    }

    private Connection connection;

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/blog" +
                "?useUnicode=yes&characterEncoding=UTF-8";

        Properties properties = new Properties();
        properties.put("user", System.getenv("DB_USER"));
        properties.put("password", System.getenv("DB_PASSWORD"));

        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            return null;
        }
    }


    public List<Members> listAllMembers() {
        String query = "SELECT * FROM members";

        List<Members> membersList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                long idUser = resultSet.getLong("id_user");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String emailAdress = resultSet.getString("e_mail");
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("passw");
                LocalDateTime registryTime = resultSet.getTimestamp("registry").toLocalDateTime();
                String accessFromDB = resultSet.getString("access").toUpperCase();
                Access access = Access.valueOf(accessFromDB);

                Members members = new Members
                        (idUser,
                         firstName,
                         lastName,
                         emailAdress,
                         userName,
                         password,
                         registryTime,
                         access);

                membersList.add(members);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return membersList;
    }

    public List<Blog> listAllBlog() {
        String query = "SELECT * FROM blog";

        List<Blog> blogList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                long idBlog = resultSet.getLong("id_blog");
                long blogSerial = resultSet.getLong("blog_serial");
                String blogText = resultSet.getString("blog_text");
                LocalDateTime blogTime = resultSet.getTimestamp("blog_time").toLocalDateTime();
                Blog blog = new Blog
                        (idBlog,
                         blogSerial,
                         blogText,
                         blogTime);

                blogList.add(blog);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogList;
    }

    public List<Comment> listAllComment() {
        String query = "SELECT * FROM comment";

        List<Comment> commentList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long idComment = resultSet.getLong("id_comment");
                String commentText = resultSet.getString("comment");
                LocalDateTime commentTime = resultSet.getTimestamp("comment_time").toLocalDateTime();

                Comment comment = new Comment
                        (idComment,
                         commentText,
                         commentTime);

                commentList.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentList;
    }

    public List<BlogSablon> listAllSablon() {
        String query = "SELECT * FROM blog_sablon";
      /*  String query = new QueryBuilder()
                .select(TableName.BLOG_SABLON)
                .build();*/

        List<BlogSablon> sablonList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long idSablon = resultSet.getLong("id_bs");
                String colour = resultSet.getString("sablon_colour");
                String alphabet = resultSet.getString("sablon_alphabet");
                String style = resultSet.getString("style");

                BlogSablon blogSablon = new BlogSablon
                        (idSablon,
                         colour,
                         alphabet,
                         style);

                sablonList.add(blogSablon);
                System.out.println(sablonList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sablonList;
    }
}
