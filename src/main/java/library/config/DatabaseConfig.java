package library.config;

import javax.sql.DataSource;

public interface DatabaseConfig {

    DataSource createDataSource();

}
