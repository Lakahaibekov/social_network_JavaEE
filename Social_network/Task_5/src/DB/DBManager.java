package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aralasu_kz?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserById(Long id){
        User user = null;
        try {
            PreparedStatement statement;

            statement = con.prepareStatement("SELECT * FROM users WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("picture_url")
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();

        }
        return user;
    }

    public static User getUser(String email){
        User user = null;
        try {
            PreparedStatement statement;

            statement = con.prepareStatement("SELECT * FROM users WHERE email = ?");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("picture_url")
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();

        }
        return user;
    }

    public static boolean addUser(User user){
        int rows = 0;
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO users(id,email, password, full_name, birth_date, picture_url)"+
                    "VALUES (null,?,?,?,?,?)");

            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFull_name());
            statement.setString(4,user.getBirth_date());
            statement.setString(5,user.getPicture_url());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean updateUser(User user){
        int rows = 0;
        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "UPDATE users SET full_name = ?, birth_date = ? WHERE id = ?");

            statement.setString(1,user.getFull_name());
            statement.setString(2,user.getBirth_date());
            statement.setLong(3,user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean updatePassword(User user){
        int rows = 0;
        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "UPDATE users SET password = ? WHERE id = ?");

            statement.setString(1,user.getPassword());
            statement.setLong(2,user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean updateURL(User user){
        int rows = 0;
        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "UPDATE users SET picture_url = ? WHERE id = ?");

            statement.setString(1,user.getPicture_url());
            statement.setLong(2,user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean addPost(Posts post){
        int rows = 0;
        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "INSERT INTO posts (id,authod_id, title, short_content, content, post_date)"+
                    "VALUES (null,?,?,?,?, NOW())");

            statement.setLong(1,post.getAuthod_id().getId());
            statement.setString(2,post.getTitle());
            statement.setString(3,post.getShort_content());
            statement.setString(4,post.getContent());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static Posts getPost(Long id){

        Posts post = null;

        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "SELECT p.id, p.authod_id, p.title, p.short_content, p.content, p.post_date, u.full_name "+
                    "FROM posts p "+
                    "INNER JOIN users u ON (u.id = p.authod_id )" +
                    "WHERE p.id = ? ");

            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                post = new Posts(
                        resultSet.getLong("id"),
                        new User(
                                resultSet.getLong("authod_id"),
                                null,null,
                                resultSet.getString("full_name"),
                                null,null
                        ),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getDate("post_date")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return post;
    }

    public static ArrayList<Posts> getAllPosts(Long id){

        ArrayList<Posts> posts = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "SELECT * FROM posts  WHERE authod_id = ? "+
                    "ORDER BY post_date DESC");

            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                posts.add(new Posts(
                        resultSet.getLong("id"),
                        DBManager.getUserById(resultSet.getLong("authod_id")),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getDate("post_date")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static void deletePost(Long id) {
        try {
            PreparedStatement statement = con.prepareStatement("" +
                    "delete from posts where id = ?");
            statement.setLong(1,id);
            statement.execute();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean savePost(Posts post){
        int rows = 0;
        try {
            PreparedStatement statement = con.prepareStatement("" +
                    "update posts set authod_id = ?, title = ?,short_content = ?, content = ?" +
                    "where id = ?");
            statement.setLong(1,post.getAuthod_id().getId());
            statement.setString(2,post.getTitle());
            statement.setString(3,post.getShort_content());
            statement.setString(4,post.getContent());
            statement.setLong(5,post.getId());
            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows>0;
    }


    public static ArrayList<Posts> getAllPosts2(){

        ArrayList<Posts> posts = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(""+
                    "SELECT * FROM posts "+
                    "ORDER BY post_date DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                posts.add(new Posts(
                        resultSet.getLong("id"),
                        DBManager.getUserById(resultSet.getLong("authod_id")),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getDate("post_date")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }
}
