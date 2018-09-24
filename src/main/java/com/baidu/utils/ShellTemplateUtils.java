package com.baidu.utils;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/24.
 */
public class ShellTemplateUtils {

    public static String PARAM = "${%s}";

    public static String getString(String filePath, Map<String, String> params) {
        String target = null;
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
            if (in == null) {
                return null;
            }
            target = IOUtils.toString(in, "utf-8");
        } catch (IOException e) {
            return null;
        } finally {
            IOUtils.closeQuietly(in);
        }
        if (MapUtils.isEmpty(params) || StringUtils.isBlank(target)) {
            return target;
        }
        for (Map.Entry<String, String> entry : params.entrySet()) {
            target = target.replace(String.format(PARAM, entry.getKey()), entry.getValue());
        }
        return target;
    }
}
