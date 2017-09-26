package com.nosixtools.config.common.properties;

import com.nosixtools.config.common.ConfigurationHandler;

import java.io.Closeable;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DefaultPropertiesHandler extends PropertiesHandler implements Closeable {

	private Map<String,String> propertiesMap = new ConcurrentHashMap<String, String>();
	private ConfigurationHandler configurationHandler;
	
	public DefaultPropertiesHandler(File file) {
		super(file);
		this.configurationHandler = ConfigurationHandler.monitor(this);
	}

	public DefaultPropertiesHandler(File file, Integer interval) {
		super(file, interval);
	}

	@Override
	public void doEventHandler(Map<String, String> settings) {
		propertiesMap.putAll(settings);
	}

	public Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}

	@Override
	public void close() {
		this.configurationHandler.stop();
	}
}
