package config;

import model.CdDisk;
import model.CdPlayer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by dmakarov on 9/21/2015.
 */
@Configuration
@ComponentScan(basePackages = {"dao.jdbc", "services.coreServices"})
public class JDBCTemplateConfig {
    @Bean(name="beatlesBean")
    @Qualifier("yellowBean")
    public CdDisk getBeatlesBean () {
        return new CdDisk();
    }

    @Bean(name="cdPlayer")
    public CdPlayer getCdPlayer () {
        return new CdPlayer(getBeatlesBean());
    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:testData.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
