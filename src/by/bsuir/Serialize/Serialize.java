package by.bsuir.Serialize;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

/**
 * The type Serialize.
 *
 * @param <T> the type parameter
 */
public class Serialize<T> implements ISerialize<T>{

    public ArrayList<T> deserialize(String filePath){
        ArrayList<T> list = null;
        XMLDecoder decoder = null;
        try
        {
            if (validateXMLByXSD(new File(filePath), new File(filePath.substring(0, filePath.indexOf(".") + 1)+"xsd")))
            {
                // Reading the object from a file
                FileInputStream file = new FileInputStream(filePath);
                decoder=new XMLDecoder(new BufferedInputStream(file));

                // Method for deserialization of object
                list = (ArrayList<T>)decoder.readObject();

                decoder.close();
                file.close();
            }
        }
        catch(Exception ex)
        {
            System.out.println("IOException is caught");
        }

        return list;
    }

    public void serialize(String filePath, ArrayList<T> list){
        XMLEncoder encoder=null;
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            //ObjectOutputStream out = new ObjectOutputStream(file);
            encoder=new XMLEncoder(new BufferedOutputStream(file));

            // Method for serialization of object
            encoder.writeObject(list);

            encoder.close();
            //out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }

    private boolean validateXMLByXSD(File xml, File xsd) throws SAXException, IOException {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("e");
        }
        return true;
    }
}
