/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.pool.OracleConnectionCacheManager;

import java.util.Properties;
import java.sql.*;

public class Pool {

    private final static String CACHE_NAME = "MYCACHE";
    private static OracleDataSource ods = null;

    static {
        System.out.println("OracleDataSource Initialization");
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            ods.setUser("muni");
            ods.setPassword("muni123");
            // caching parms
            ods.setConnectionCachingEnabled(true);
            ods.setConnectionCacheName(CACHE_NAME);
            Properties cacheProps = new Properties();
            cacheProps.setProperty("MinLimit", "1");
            cacheProps.setProperty("MaxLimit", "4");
            cacheProps.setProperty("InitialLimit", "1");
            cacheProps.setProperty("ConnectionWaitTimeout", "5");
            cacheProps.setProperty("ValidateConnection", "true");

            ods.setConnectionCacheProperties(cacheProps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * private constructor for static class
     */
    private Pool() {
    }


    public static Connection getConnection() throws SQLException {
        if (ods == null) {
            throw new SQLException("OracleDataSource is null.");
        }
        return ods.getConnection();
    }

    public static void closePooledConnections() throws SQLException {
        if (ods != null) {
            ods.close();
        }
    }

    public static void listCacheInfos() throws SQLException {
        OracleConnectionCacheManager occm
                = OracleConnectionCacheManager.getConnectionCacheManagerInstance();
        System.out.println(occm.getNumberOfAvailableConnections(CACHE_NAME)
                + " connections are available in cache " + CACHE_NAME);
        System.out.println(occm.getNumberOfActiveConnections(CACHE_NAME)
                + " connections are active");

    }
}
