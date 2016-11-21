package scms.ssms.aop;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 吴森
 * @Time 2016-11-20 14:49:01
 * @describe 能使代码与配置多数据源配置相接，最关键的类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DataSourceContextHolder.getDbInfo();
	}

}
