package com.company.parser;

import com.company.standard.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class XMLParser {

    public void parse(String InputFilePath, TreeMap<Integer, Dragon> treeMap) {
        try {
            File inputFile = new File(InputFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("dragon");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Integer id;
                String name;
                Double x;
                String yStr;
                String time;
                String ageStr;
                String color;
                String type;
                String character;
                String depthStr;

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    id = Integer.valueOf(eElement.getAttribute("id"));

                    name = (eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());

                    x = Double.valueOf(eElement
                            .getElementsByTagName("coordinateX")
                            .item(0)
                            .getTextContent());

                    yStr = (eElement
                            .getElementsByTagName("coordinateY")
                            .item(0)
                            .getTextContent());

                    time = (eElement
                            .getElementsByTagName("time")
                            .item(0)
                            .getTextContent());

                    ageStr = eElement
                            .getElementsByTagName("age")
                            .item(0)
                            .getTextContent();

                    color = (eElement
                            .getElementsByTagName("color")
                            .item(0)
                            .getTextContent());

                    type = (eElement
                            .getElementsByTagName("type")
                            .item(0)
                            .getTextContent());

                    character = (eElement
                            .getElementsByTagName("character")
                            .item(0)
                            .getTextContent());

                    depthStr = eElement
                            .getElementsByTagName("cave")
                            .item(0)
                            .getTextContent();

                    Coordinates coordinates;
                    coordinates = new Coordinates(x);
                    if (yStr.equals("")) System.out.println("Значение игрика записано не будет записано, т.к null");
                    else {
                        int y = Integer.parseInt(yStr);
                        if (y <= 803) coordinates.setY(y);
                    }

                    DragonCave dragonCave;
                    dragonCave = new DragonCave();
                    if (!depthStr.equals("")) dragonCave.setDepth(Double.parseDouble(depthStr));

                    ZonedDateTime zdtGiven = ZonedDateTime.parse(time);

                    Dragon dragon;
                    dragon = new Dragon(id, name, coordinates, Color.valueOf(color), DragonType.valueOf(type), DragonCharacter.valueOf(character), dragonCave, zdtGiven);
                    if (ageStr.equals("")) System.out.println("Значение age записано не будет записано, т.к null");
                    else if (Long.parseLong(ageStr) > 0) dragon.setAge(Long.parseLong(ageStr));

                    treeMap.put(dragon.getId(), dragon);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка перевода файла из xml. Проверьте правильность написания xml файла");
        }
    }

    public void unparse(String OutputFilePath, TreeMap<Integer, Dragon> treeMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version = \"1.0\"?>\n");
        sb.append("<treemap>\n");
        Set set = treeMap.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            int id = (int) me.getKey();
            sb.append("\t<dragon id=\"").append(id).append("\">\n");
            sb.append("\t\t<name>").append(treeMap.get(id).getName()).append("</name>\n");
            try {
                sb.append("\t\t<coordinateX>" + treeMap.get(id).getCoordinates().getX() + "</coordinateX>\n");
            } catch (NullPointerException ex) {
                sb.append("\t\t<coordinateX></coordinateX>\n");
            }
            sb.append("\t\t<coordinateY>").append(treeMap.get(id).getCoordinates().getY()).append("</coordinateY>\n");
            sb.append("\t\t<time>").append(treeMap.get(id).getCreationDate()).append("</time>\n");
            sb.append("\t\t<age>").append(treeMap.get(id).getAge()).append("</age>\n");
            sb.append("\t\t<color>").append(treeMap.get(id).getColor()).append("</color>\n");
            sb.append("\t\t<type>").append(treeMap.get(id).getType()).append("</type>\n");
            sb.append("\t\t<character>").append(treeMap.get(id).getCharacter()).append("</character>\n");
            try {
                sb.append("\t\t<cave>" + treeMap.get(id).getCave().getDepth() + "</cave>\n");
            } catch (NullPointerException ex) {
                sb.append("\t\t<cave></cave>\n");
            }
            sb.append("\t</dragon>\n");
        }
        sb.append("</treemap>\n");

        FileOutputStream fileOutputStream = null;
        PrintWriter printWriter = null;

        try{
            fileOutputStream = new FileOutputStream(OutputFilePath);
            printWriter = new PrintWriter(fileOutputStream);

            printWriter.println(sb.toString());
            printWriter.flush();
        }
        catch (IOException ex){
            System.err.println("Произошла ошибка при добавлении файла в исходнящий поток\n" + ex);
        }
        catch(NullPointerException ex){
            System.err.println("Не указан файл, куда следует записывать данные " + ex);
        }
        finally{
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (printWriter != null){
                    printWriter.close();
                }
            }
            catch(IOException ex){
                System.err.println("Произошла ошибка при закрытии " + ex);
            }
        }
    }

}
