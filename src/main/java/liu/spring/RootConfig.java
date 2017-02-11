package liu.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.naming.NamingException;

/**
 * Created by wtswindows7 on 2017/2/10.
 */


@Configuration
@ComponentScan(basePackages = "liu")
@MapperScan(basePackages = "liu")
public class RootConfig {

    private static String diver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql://localhost:3306/YOUR_INSTANCE_NAME";

    private static String user = "YOUR_NAME";

    private static String pwd = "YOUR_PASSWORD";

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(diver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws NamingException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext ap) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("liu");
        return sessionFactory;
    }

}
