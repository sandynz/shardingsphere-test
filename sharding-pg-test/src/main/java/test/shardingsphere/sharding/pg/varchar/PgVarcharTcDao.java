package test.shardingsphere.sharding.pg.varchar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class PgVarcharTcDao {
    
    private final DataSource dataSource;
    
    public PgVarcharTcDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void delete(long id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "delete from varchar_tc where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                int updateCount = statement.executeUpdate();
                System.out.println("delete count=" + updateCount);
            }
        }
    }
    
    public void insert(PgVarcharTc pgVarcharTc) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "insert into varchar_tc (id, real_name) values (?, ?)";
            if (pgVarcharTc.getId() == null) {
                sql = "insert into varchar_tc (real_name) values (?)";
            }
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                if (pgVarcharTc.getId() != null) {
                    statement.setLong(1, pgVarcharTc.getId());
                    statement.setString(2, pgVarcharTc.getRealName());
                } else {
                    statement.setString(1, pgVarcharTc.getRealName());
                }
                int updateCount = statement.executeUpdate();
                System.out.println("insert count=" + updateCount);
            }
        }
    }
    
    public PgVarcharTc query(long id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "select * from varchar_tc where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        System.err.println("no record found");
                        return null;
                    }
                    PgVarcharTc pgVarcharTc = new PgVarcharTc();
                    pgVarcharTc.setId(resultSet.getLong("id"));
                    pgVarcharTc.setRealName(resultSet.getString("real_name"));
                    return pgVarcharTc;
                }
            }
        }
    }
    
}
