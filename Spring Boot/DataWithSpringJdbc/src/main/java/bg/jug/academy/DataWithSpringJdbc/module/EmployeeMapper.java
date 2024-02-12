package bg.jug.academy.DataWithSpringJdbc.module;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<EmployeeEntity> {
    @Override
    public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmployeeEntity(rs.getString("id"), rs.getString("name"), rs.getLong("salary"));
    }
}
