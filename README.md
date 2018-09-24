# 作用
动态替换文件中的${key}

# 使用举例
> Map<String,String> map = new HashMap<String,String>;  
> map.put("key","value");  
> StringTemplateUtils.getString("any/in/classpath/file",map);  
