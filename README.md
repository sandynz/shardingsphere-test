
## Run steps

### PostgreSQL test
- In `sharding-pg-test` module
- Create database `test1`
- Create tables, schema at `pg-test.sql`
- Run `ShardingPgVarcharJdbcTest` / `ShardingPgVarcharProxyTest`

### Metadata test
- In `metadata-test` module
- Refer to `metadata-test.sql`, create databases and tables
- Run unit test `ShardingJdbcMetadataTest.loadPrimaryKeys`
