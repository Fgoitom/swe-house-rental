package miu.edu.helper;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class RoleInitializer {

    private final JdbcTemplate jdbcTemplate;

    public RoleInitializer(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void initializeRoles() {
        String[] roles = { "Admin", "Owner", "Renter", "Guest" };

        for (String role : roles) {
            if (!roleExists(role)) {
                insertRole(role);
            }
        }
    }

    private boolean roleExists(String roleName) {
        String sql = "SELECT COUNT(*) FROM roles WHERE name = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, roleName);
        return count != null && count > 0;
    }

    private void insertRole(String roleName) {
        String sql = "INSERT INTO roles (name) VALUES (?)";
        jdbcTemplate.update(sql, roleName);
    }
}
