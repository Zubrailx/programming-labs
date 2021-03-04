package com.company;

import com.company.manager.FileManager;

import java.io.IOException;
import java.util.TreeMap;

import com.company.parser.XMLParser;
import com.company.standard.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager fileManager = new FileManager();
        XMLParser xmlParser = new XMLParser();

//        if (args.length > 0){
//            if (!args[0].equals("")){
//            fileManager.setFileInputName(args[0]);
//            }
//        }
        String InputFile = "D:\\Development projects\\Java Projects\\University\\lab5\\src\\com\\company\\files\\inputFile.txt";
        String OutputFile = "D:\\Development projects\\Java Projects\\University\\lab5\\src\\com\\company\\files\\outputFile.txt";

        TreeMap<Integer, Dragon> treeMap = new TreeMap<Integer, Dragon>();

        fileManager.setFileInputName(InputFile);
        xmlParser.parse(InputFile, treeMap);
//        System.out.println(treeMap.get(1213));
        xmlParser.unparse(OutputFile, treeMap);
    }
}