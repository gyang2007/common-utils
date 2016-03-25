package com.gyang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public final class CloserUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloserUtil.class);

    private CloserUtil() {

    }

    public static void close(Closeable... cs) {
        if (cs == null)
            return;
        for (Closeable c : cs) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable e) {
                    LOGGER.warn("资源关闭时出错:" + c.getClass().getName(), e);
                }
            }
        }
    }

    public static void close(ResultSet... cs) {
        if (cs == null)
            return;
        for (ResultSet c : cs) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable e) {
                    LOGGER.warn("资源关闭时出错:" + c.getClass().getName(), e);
                }
            }
        }
    }

    public static void close(Statement... cs) {
        if (cs == null)
            return;
        for (Statement c : cs) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable e) {
                    LOGGER.warn("资源关闭时出错:" + c.getClass().getName(), e);
                }
            }
        }
    }

    public static void close(Connection... connections) {
        if (connections == null)
            return;
        for (Connection c : connections) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable e) {
                    LOGGER.warn("资源关闭时出错:" + c.getClass().getName(), e);
                }
            }
        }
    }
}
