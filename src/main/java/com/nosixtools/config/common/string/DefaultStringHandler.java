package com.nosixtools.config.common.string;

import com.nosixtools.config.common.ConfigurationHandler;

import java.io.Closeable;
import java.io.File;

public class DefaultStringHandler extends StringHandler implements Closeable {

	private String content = null;
	private ConfigurationHandler configurationHandler;
	
	public DefaultStringHandler(File file) {
		super(file);
		this.configurationHandler = ConfigurationHandler.monitor(this);
	}
	
	public DefaultStringHandler(File file, Integer interval) {
		super(file, interval);
	}
	
	@Override
	public void doEventHandler(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public void close() {
		this.configurationHandler.stop();
	}
}
