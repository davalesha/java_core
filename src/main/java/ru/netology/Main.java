package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JSplitPane.LEFT;
//import static jdk.internal.org.jline.reader.impl.DefaultParser.Bracket.SQUARE;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String fileNameCSV = "C:\\Users\\svdav\\java_project\\task5_1\\src\\main\\resources\\data.csv";//"data.csv";
        String fileNameXML = "C:\\Users\\svdav\\java_project\\task5_1\\src\\main\\resources\\data.xml";

        // csv->json
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        List<Employee> list = parseCSV(columnMapping, fileNameCSV);
        list.forEach(System.out::println);

        String json = listToJson(list);
        System.out.println(json);
        writeString(json, "csv");

        // xml->json
        System.out.println("-----xml------");
        list = parseXML(fileNameXML);
        json = listToJson(list);
        System.out.println(json);
        writeString(json, "xml");
    }

    private static List<Employee> parseCSV(String[] columnMapping, String filename) {
        List<Employee> list = null;
        try (CSVReader csvReader = new CSVReader(new FileReader(filename))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            list = csv.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static String listToJson(List<Employee> list) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        String json = gson.toJson(list, listType);

        System.out.println("-------");
        return json;
    }

    private static void writeString(String json, String name) {
        try (FileWriter file = new
                FileWriter(name + "_data.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Employee> parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        List<Employee> list = new ArrayList<>();
        // построитель документа
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //дерево документа из файла
        Document doc = builder.parse(new File(fileName));
        //Корневой элемент
        Node root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());
        NodeList employees = root.getChildNodes();
        //просматриваем все эл-ты подкорневого
        for (int i = 0; i < employees.getLength(); i++) {
            Node employeeNode = employees.item(i);
            System.out.println("Элемент: " + employeeNode.getNodeName());
            if (employeeNode.getNodeType() != Node.TEXT_NODE) {
                Employee employee = new Employee();
                NodeList employeeNodeList = employeeNode.getChildNodes();
                for (int j = 0; j < employeeNodeList.getLength(); j++) {
                    Node employeeChild = employeeNodeList.item(j);
                    if (employeeChild.getNodeType() != Node.TEXT_NODE) {
                        String nameNode = employeeChild.getNodeName();
                        String valueNode = employeeChild.getChildNodes().item(0).getTextContent();

                        System.out.println(nameNode + ":" + valueNode);
                        switch (nameNode) {
                            case "id": {
                                employee.setId(Long.parseLong(valueNode));
                                break;
                            }
                            case "firstName": {
                                employee.setFirstName(valueNode);
                                break;
                            }
                            case "lastName": {
                                employee.setLastName(valueNode);
                                break;
                            }
                            case "country": {
                                employee.setCountry(valueNode);
                                break;
                            }
                            case "age": {
                                employee.setAge(Integer.parseInt(valueNode));
                                break;
                            }
                        }
                    }
                }
                list.add(employee);
            }
        }
        return list;
    }

}


