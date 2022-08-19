package com.hmp.server.config;

import lombok.Data;

@Data
public class DatasourceProperties {
    private String userName;
    private String password;
    private String driverClassName;
    private String datasourceUrl;
    private String testQuery;

}
