package test.shardingsphere.sharding.pg.varchar;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class PgVarcharTc {
    
    private Long id;
    
    private String realName;
    
}
