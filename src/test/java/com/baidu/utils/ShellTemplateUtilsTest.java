package com.baidu.utils;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/24.
 */
public class ShellTemplateUtilsTest {

    @Test
    public void testRun() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("text", "123");
        params.put("what", "456");
        String res = ShellTemplateUtils.getString("shell/test", params);

        String excepted = "cat 123\n" +
                "echo 456\n" +
                "echo 123";
        Assert.assertEquals(excepted, res);
    }

    @Test
    public void testRunUnExist() throws Exception {
        Assert.assertEquals(null, ShellTemplateUtils.getString("unexist", new HashMap<>()));
    }

    @Test
    public void testEmptyText() throws Exception {
        Assert.assertEquals(StringUtils.EMPTY, ShellTemplateUtils.getString("shell/empty", new HashMap<>()));

    }
}