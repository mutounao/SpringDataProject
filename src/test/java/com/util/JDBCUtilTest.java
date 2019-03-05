package com.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * @desc:
 * @className: JDBCUtilTest
 * @author: Dong Yu
 * @date: 2019/2/28 16:22
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}