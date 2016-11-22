package com.aop;

import java.lang.annotation.*;
/**
 * @author 吴森
 * @Time 2016-11-20 14:49:01
 * @describe 一个接口类，便于切换数据源键值队
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.master;
 
    public static String master = "dataSource1";
 
    public static String slave1 = "dataSource2";
 
  
 
}