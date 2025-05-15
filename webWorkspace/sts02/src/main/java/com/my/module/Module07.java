package com.my.module;

import java.util.Properties;

import org.apache.log4j.Logger;

public class Module07 implements MyModule {
	Logger logger=Logger.getLogger(getClass());
	Properties props;
	
	public void setProps(Properties props) {
		this.props = props;
	}

	@Override
	public void func01() {
		// DEBUG < INFO < WARN < ERROR < FATAL
		logger.debug(props);
		logger.info(props);
		logger.warn(props);
		logger.error(props);
		logger.fatal(props);
	}

}
