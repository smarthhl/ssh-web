package org.creditease.cn.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SqlTemplateUtils {
	private static Properties properties;
	static {
		try {
			properties = new Properties();
			properties.load(SqlTemplateUtils.class
					.getResourceAsStream("/sqlTemplate.properties"));
			parseXMLConfigFile();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void parseXMLConfigFile() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(SqlTemplateUtils.class
				.getResourceAsStream("/sqlTemplate.xml"));
		Element rootEle = doc.getDocumentElement();
		NodeList nl = rootEle.getElementsByTagName("item");
		for (int i = 0; i < nl.getLength(); i++) {
			Element node = (Element) nl.item(i);
			NodeList nl1 = node.getElementsByTagName("name");
			if (nl1.getLength() > 0) {
				String name = ((Element) nl1.item(0)).getTextContent();
				String value = null;
				NodeList nl2 = node.getElementsByTagName("value");
				if (nl2.getLength() > 0) {
					value = ((Element) nl2.item(0)).getTextContent();
				}
				properties.put(name, value);
			} else {
				continue;
			}
		}

	}

	/**
	 * 根据标识名获取sql模板
	 * 
	 * @Title: getSqlTemplate
	 * @Description: TODO
	 * @param @param name
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getSqlTemplate(String name) {
		return properties.getProperty(name, "");
	}
}
