package com.nexo.sourcing.SourcingAutomationNexo;


/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

/**
*
* @author Jalal Mekmassi
*/
public class XmlUtils {
    private static Document doc;
    private static final String FILE_NAME = "D:\\data\\dto21215\\Documents\\NetBeansProjects\\TestApp\\src\\XML\\xml-data.xml";
    

    public static String retrieveElementByXMLtag(String xPathExpression) throws XPathExpressionException {
        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xpath.compile(xPathExpression);
        return expr.evaluate(doc, XPathConstants.STRING).toString();
    }

    public static void readXmlData() throws SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        try {
            builder = domFactory.newDocumentBuilder();
            doc = builder.parse(FILE_NAME);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
    }
}


/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/





