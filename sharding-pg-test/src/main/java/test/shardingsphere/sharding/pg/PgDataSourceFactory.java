package test.shardingsphere.sharding.pg;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.postgresql.Driver;

public class PgDataSourceFactory {
    
    public static DataSource getJdbcDataSource() throws IOException, SQLException {
        File file = new File(PgDataSourceFactory.class.getClassLoader().getResource("META-INF/sharding-tables-pg-jdbc.yaml").getFile());
        return YamlShardingSphereDataSourceFactory.createDataSource(file);
    }
    
    public static DataSource getProxyDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(Driver.class.getName());
        config.setMaximumPoolSize(5);
        config.setJdbcUrl("jdbc:postgresql://localhost:3307/sharding_db");
        config.setUsername("root");
        config.setPassword("root");
        // for debug
        config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(600));
        return new HikariDataSource(config);
    }
    
    public static DataSource getRawJdbcDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(Driver.class.getName());
        config.setMaximumPoolSize(5);
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/test1");
        config.setUsername("postgres");
        config.setPassword("test");
        // for debug
        config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(600));
        return new HikariDataSource(config);
    }
    
}
