package com.example.mybatis;

import com.zaxxer.hikari.HikariDataSource;


public class DataSourceMonitoring implements  DataSourceMonitoringMBean {

    private HikariDataSource dataSource;

    public DataSourceMonitoring(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int getnumActive() {
        return dataSource.getHikariPoolMXBean() != null ? dataSource.getHikariPoolMXBean().getActiveConnections() : 0;
    }

    @Override
    public int getnumIdle() {
        return dataSource.getHikariPoolMXBean() != null ? dataSource.getHikariPoolMXBean().getIdleConnections() : 0;
    }

    @Override
    public int getmaxActive() {
        return dataSource.getHikariConfigMXBean().getMaximumPoolSize();
    }

    @Override
    public int getmaxTotal() {
        return dataSource.getHikariConfigMXBean().getMaximumPoolSize();
    }

}

