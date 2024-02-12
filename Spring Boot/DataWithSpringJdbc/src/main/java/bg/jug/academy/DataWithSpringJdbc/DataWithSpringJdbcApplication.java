package bg.jug.academy.DataWithSpringJdbc;

import bg.jug.academy.DataWithSpringJdbc.module.EmployeeEntity;
import bg.jug.academy.DataWithSpringJdbc.module.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DataWithSpringJdbcApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate; //from spring-jdbc library = org.springframework.jdbc.core

    @Autowired
    private EmployeeMapper employeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(DataWithSpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Integer employeesCount = countEmployees();
        EmployeeEntity employeeById = getEmployeeById("1");
        List<EmployeeEntity> employees = getEmployees();

        insertEmployee();
    }

    private void insertEmployee() {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.setTableName("Employees");
        simpleJdbcInsert.execute(Map.of("id", "120", "name", "Ivanov", "salary", 2000L));

        jdbcTemplate.update("UPDATE Employees SET name = 'Petrov' WHERE id=120");
    }

    private Integer countEmployees() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM employees", Integer.class);
    }

    private EmployeeEntity getEmployeeById(String id) {
//        return jdbcTemplate.queryForObject("SELECT id, name, salary from hrm.employees where id = %s".formatted(id), new EmployeeMapper()); //queryForObject(String sql, RowMapper<T> rowMapper)
        return jdbcTemplate.queryForObject("SELECT id, name, salary from hrm.employees where id = %s".formatted(id), employeeMapper); //queryForObject(String sql, RowMapper<T> rowMapper)
    }

    private List<EmployeeEntity> getEmployees() {
//		jdbcTemplate.queryForList("SELECT id, name, salary from hrm.employees");
//        return jdbcTemplate.query("SELECT id, name, salary from hrm.employees", new EmployeeMapper());  //query(String sql, RowMapper<T> rowMapper)
        return jdbcTemplate.query("SELECT id, name, salary from hrm.employees", employeeMapper);  //query(String sql, RowMapper<T> rowMapper)
    }
}
