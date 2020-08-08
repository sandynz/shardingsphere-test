package test.shardingsphere.sharding.pg.varchar;

import javax.sql.DataSource;
import test.shardingsphere.sharding.pg.PgDataSourceFactory;

public class ShardingPgVarcharProxyTest {
    
    public static void main(String[] args) throws Exception {
        DataSource dataSource = PgDataSourceFactory.getProxyDataSource();
        System.out.println("dataSource=" + dataSource);
        PgVarcharTcDao pgVarcharTcDao = new PgVarcharTcDao(dataSource);
        final long id = 1L;
        pgVarcharTcDao.delete(id);
        pgVarcharTcDao.insert(new PgVarcharTc().setId(id).setRealName("name1"));
        PgVarcharTc pgVarcharTc = pgVarcharTcDao.query(id);
        System.out.println("pgVarcharTc=" + pgVarcharTc);
    }
    
}
