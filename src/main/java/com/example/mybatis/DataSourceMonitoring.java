package com.example.mybatis;

import com.zaxxer.hikari.HikariDataSource;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


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

    @PostConstruct
    public void init() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.test:type=DataSource,name=hikari-pool,context=/");
        DataSourceMonitoring dataSourceMonitoring = new DataSourceMonitoring(dataSource);
        mBeanServer.registerMBean(dataSourceMonitoring, objectName);
    }

}

