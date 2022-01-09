/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.shardingsphere.metadta;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
public class ShardingJdbcMetadataTest {
    
    @Test
    public void loadPrimaryKeys() throws Exception {
        try (ShardingSphereDataSource dataSource = MetadataDataSourceFactory.getMySQLAutoTablesJdbcDataSource();
             Connection connection = dataSource.getConnection()) {
            Set<String> primaryKeys = loadPrimaryKeys(connection, "t_order");
            log.info("primaryKeys={}", primaryKeys);
        }
    }
    
    private Set<String> loadPrimaryKeys(final Connection connection, final String tableName) throws SQLException {
        Set<String> result = new LinkedHashSet<>();
        try (ResultSet resultSet = connection.getMetaData().getPrimaryKeys(connection.getCatalog(), connection.getSchema(), tableName)) {
            while (resultSet.next()) {
                result.add(resultSet.getString("COLUMN_NAME"));
            }
        }
        return result;
    }
}
