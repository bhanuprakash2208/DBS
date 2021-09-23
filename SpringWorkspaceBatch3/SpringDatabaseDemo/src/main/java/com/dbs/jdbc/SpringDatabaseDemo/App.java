package com.dbs.jdbc.SpringDatabaseDemo;
import javax.sql.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.dbs.jdbc.SpringDatabaseDemo.database.EmpDB;
import com.dbs.jdbc.SpringDatabaseDemo.model.Employee;
@Configuration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext context
       = new AnnotationConfigApplicationContext(App.class);
		
		
       EmpDB db = context.getBean(EmpDB.class); 
       //Employee e1 = new Employee(3,"sai", "Hyderabad"); 
       //db.insertEmployee(e1);
		 
      for(Employee emp:db.getAllEmployees())
    	  System.out.println(emp);
      
      System.out.println("-------------Getting through eid-----------");
      Employee e=db.getEmployeeById(2);
      System.out.println(e); 
		 
    }
   
    // database connection parameter
    // DataSource
    @Bean
    public DataSource dataSource()
    {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setUrl("jdbc:mariadb://localhost:3307/dbs");
    	ds.setUsername("root");
    	ds.setDriverClassName("org.mariadb.jdbc.Driver");
    	ds.setPassword("root");
    	System.out.println("ds created "+ds);
    	return ds;
    }
    
	
	  @Bean 
	  public JdbcTemplate template() {
		  return new JdbcTemplate(dataSource());
	  }
	 
    
}

