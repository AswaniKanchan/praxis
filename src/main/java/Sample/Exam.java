package Sample;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.*;

public class Exam {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new ByteArrayInputStream(message.getBytes("UTF-8")));

        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("entry");
        HashMap<String, List<Integer>> msgFreq = new HashMap();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String id = eElement.getAttribute("rollno");
                String msg = eElement
                        .getElementsByTagName("message")
                        .item(0)
                        .getTextContent();
                if(msgFreq.containsKey(msg)){
                    msgFreq.get(msg).add(Integer.parseInt(id));
                } else{
                    List<Integer> freq = new ArrayList<>();
                    freq.add(Integer.parseInt(id));
                    msgFreq.put(msg, freq);
                }
            }
        }
        return msgFreq.get(message);
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<log>\n" +
                        "    <entry id=\"1\">" +
                        "        <message>Application started</message>" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">" +
                        "        <message>Application ended</message>" +
                        "    </entry>" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        xml.replace("\n","");
        for(int id: ids)
            System.out.println(id);
    }
}