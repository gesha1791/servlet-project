package chaplinskiy.servlet.util;

public final class Constants {
    // Connection
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/crud";
    static final String USER = "root";
    static final String PASSWORD = "admin";
    // SQL commands
    // Region database
    public static final String getAllRegionSQL = "SELECT * FROM region";
    public static final String createRegionSQL = "INSERT INTO region (NAME) VALUES (?)";
    public static final String deleteRegionSQL = "DELETE FROM region WHERE ID = (?)";
    public static final String getRegionSQL = "SELECT * FROM region WHERE ID = (?)";
    public static final String updateRegionSQL = "UPDATE region SET name = (?) WHERE ID = (?)";

    // Post database
    public static final String getAllPostSQL = "SELECT * FROM post";
    public static final String createPostSQL = "INSERT INTO post (CONTENT, CREATED, UPDATED) VALUES (?, ?, ?)";
    public static final String deletePostSQL = "DELETE FROM post WHERE ID = (?)";
    public static final String getPostSQL = "SELECT * FROM post WHERE ID = (?)";
    public static final String updatePostSQL = "UPDATE post SET content = ?, updated = ? WHERE ID = ?";

    // User database
    public static final String getAllUserSQL =
            "SELECT user.id, user.firstName, user.lastName, " +
                    "region.name, roleuser.role " +
                    "FROM user " +
                    "JOIN region ON region.id = user.region_id " +
                    "JOIN roleuser ON roleuser.id = user.role_id";

    public static final String getAllPostUserByID = "SELECT post.id, post.content" +
            " FROM user " +
            "JOIN user_post ON user.id = user_post.id_user " +
            "JOIN post ON post.id = user_post.id_post " +
            "WHERE user.id = (?)";

    public static final String getUserById =
            "SELECT user.id, user.firstName, user.lastName, " +
                    "region.name, roleuser.role " +
                    "FROM user " +
                    "JOIN region ON region.id = user.region_id " +
                    "JOIN roleuser ON roleuser.id = user.role_id " +
                    "WHERE user.id = (?)";

    public static final String deleteUserSQL = "DELETE FROM user WHERE ID = (?)";

    public static final String createUserSQL = "INSERT INTO user (firstName, lastName, region_id, role_id) VALUES (?, ?, ?, ?)";
    public static final String updateUserSQL = "UPDATE user SET firstName = (?), lastName = (?), region_id = (?) WHERE ID = (?)";

}
