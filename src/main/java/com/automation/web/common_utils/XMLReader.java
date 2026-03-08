package com.automation.web.common_utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.automation.web.Report_Utils.ReportManager;

public class XMLReader {

	ArrayList<String> dataList = new ArrayList<String>();
	HashSet<String> list = new HashSet<String>();

	public String xmlReader(String nodename, String nodevalue) {
		String Data = "";
		try {

			File file = new File((ConfigReader.getValue("xmlPath")));

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName(nodename);
			Node node = nodeList.item(0);
			Element eElement = (Element) node;
			Data = eElement.getElementsByTagName(nodevalue).item(0).getTextContent();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return Data;

	}

	public int getXMLCount(String nodename, String xmlPath) {

		int count = 0;
		try {
			// Load the XML file
			File inputFile = new File(xmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xpath = XPathFactory.newInstance().newXPath();
			// Get all the elements with tag name "number"
			NodeList nodeList = (NodeList) xpath.compile(nodename).evaluate(doc, XPathConstants.NODESET);

			// Iterate over the resulting nodes
			for (int i = 0; i < nodeList.getLength(); i++) {
				// Get the current node
				String value = nodeList.item(i).getTextContent();

				count++;
			}
			System.out.println("Number of nodes: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public ArrayList<String> getXMLDataForPArticularNode(String nodename, String xmlPath) {

		String data;
		try {
			// Load the XML file
			File inputFile = new File(xmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xpath = XPathFactory.newInstance().newXPath();
			// Get all the elements with tag name "number"
			NodeList nodeList = (NodeList) xpath.compile(nodename).evaluate(doc, XPathConstants.NODESET);

			// Iterate over the resulting nodes
			for (int i = 0; i < nodeList.getLength(); i++) {
				// Get the current node
				String value = nodeList.item(i).getTextContent();

				dataList.add(value);

			}
			System.out.println("data: " + dataList.clone());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (ArrayList<String>) dataList.clone();
	}

	public HashSet<String> GettingNodeElements(String tagname, String xmlpathh) {
		try {
			// Load the XML file
			File inputFile = new File(xmlpathh);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// Get the "employee" elements
			NodeList employeeList = doc.getElementsByTagName(tagname);

			// Print the desired tags of each employee
			for (int i = 0; i < employeeList.getLength(); i++) {
				Node employeeNode = employeeList.item(i);
				if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element employeeElement = (Element) employeeNode;
					System.out.println();

					printElementTag(employeeElement, "NAME");
					printElementTag(employeeElement, "AGE");
					printElementTag(employeeElement, "DOB");
					printElementTag(employeeElement, "PHONE_NO");
					printElementTag(employeeElement, "EMAIL");
					printElementTag(employeeElement, "ADDRESS");
				}
			}
			System.out.println(list.clone());
			ReportManager.logInfo(list.clone() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (HashSet<String>) list.clone();
	}

	private void printElementTag(Element element, String tagName) {
		NodeList nodeList = element.getElementsByTagName(tagName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element subElement = (Element) nodeList.item(i);

			list.add(subElement.getTagName());
		}

	}
}
