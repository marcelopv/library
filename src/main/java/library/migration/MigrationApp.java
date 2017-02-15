package library.migration;

import org.flywaydb.core.Flyway;

public class MigrationApp {

    public static void main(String[] args){
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:postgresql://localhost:5432/library", "mvargas", null);
        flyway.migrate();
    }

}
