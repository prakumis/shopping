package com.nyp.shopping.web.listener;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nyp.shopping.common.constants.ShopConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * Listener for logback to read external configuration.
 * 
 * @author epaldeb
 */
public class LogbackConfigListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(LogbackConfigListener.class);
	private String serverHomeDir;

	public void contextInitialized(ServletContextEvent sce) {
		serverHomeDir = System.getProperty(ShopConstants.SERVER_HOME);
		System.out.println("LogbackConfigListener.contextInitialized()::"
				+ serverHomeDir);
		String configFile = serverHomeDir + File.separator + "shop"
				+ File.separator + "configuration" + File.separator
				+ "logback.xml";
		System.out.println("LogbackConfigListener.contextInitialized()::"
				+ configFile);

		try {
			loadConfig(configFile);
		} catch (Exception e) {
			logger.error("Unable to read config file", e);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	private void loadConfig(String externalConfigFileLocation)
			throws IOException, JoranException {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

		File externalConfigFile = new File(externalConfigFileLocation);
		if (!externalConfigFile.exists()) {
			throw new IOException(
					"Logback External Config File Parameter does not reference a file that exists");
		} else {
			if (!externalConfigFile.isFile()) {
				throw new IOException(
						"Logback External Config File Parameter exists, but does not reference a file");
			} else {
				if (!externalConfigFile.canRead()) {
					throw new IOException(
							"Logback External Config File exists and is a file, but cannot be read.");
				} else {
					JoranConfigurator configurator = new JoranConfigurator();
					configurator.setContext(lc);
					lc.reset();
					String logDir = serverHomeDir + File.separator + "shop"
							+ File.separator + "log";
					lc.putProperty("LOG_LOC", logDir);
					configurator.doConfigure(externalConfigFileLocation);

					logger.info("Configured Logback with config file from: "
							+ externalConfigFileLocation);
				}
			}
		}
	}
}
