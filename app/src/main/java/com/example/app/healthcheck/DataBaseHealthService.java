package com.example.app.healthcheck;

import javax.sql.DataSource;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DataBaseHealthService {

    private final DataSource dataSource;
    private boolean isDatabaseUp = false;

    public DataBaseHealthService(DataSource dataSource) {
        this.dataSource = dataSource;
        refreshStatus();
    }

    public void refreshStatus() {
        try (Connection connection = dataSource.getConnection()) {
            this.isDatabaseUp = connection.isValid(3);
        } catch (SQLException e) {
            this.isDatabaseUp = false;
        }
    }

    public boolean isDatabaseReachable() {
        return isDatabaseUp;
    }
}