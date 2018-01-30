package xyz.raultaylor.spaceflygun.engine.loaders;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by raultaylor on 28.01.18.
 */

public class XMLLoader {
    File file;
    DocumentBuilder documentBuilder;

    public XMLLoader(File file){
        this.file = file;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
    }

    public boolean loadObjects(Object object){
        Document document;
        try {
            document = documentBuilder.parse(file);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }catch (SAXException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
