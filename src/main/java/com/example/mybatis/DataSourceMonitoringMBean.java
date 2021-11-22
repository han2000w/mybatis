package com.example.mybatis;

public interface DataSourceMonitoringMBean {
    int getnumActive();
    int getnumIdle();
    int getmaxActive();
    int getmaxTotal();
}

