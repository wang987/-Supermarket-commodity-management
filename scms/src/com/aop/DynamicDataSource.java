package com.aop;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ��ɭ
 * @Time 2016-11-20 14:49:01
 * @describe ��ʹ���������ö�����Դ������ӣ���ؼ�����
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DataSourceContextHolder.getDbInfo();
	}

}
