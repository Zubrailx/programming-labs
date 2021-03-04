package com.company.manager;

import java.io.*;

public class FileManager{

    private String fileInputName;
    private String fileOutputName;

    private StringBuilder sb = new StringBuilder();
    private String fileName;

    private File file;

    public void setFileInputName(String fileInputName){
        this.fileInputName = fileInputName;
    }

    public void setFileOutputName(String fileOutputName){
        this.fileOutputName = fileOutputName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }


    public void createNewFile() {

        try{
        file = new File(fileName);
            boolean created = file.createNewFile();
            if(created){
                System.out.println("Файл " + file.getName() + " был создан");
       //         System.out.println(file.getPath());
            }
            else{
                System.out.println("Файл создан не был, так как уже существует");
            }
        }
        catch(IOException ex){
            System.err.println("Произошла ошибка при создании файла " + ex);
        }
        catch(NullPointerException ex){
            System.err.println("Файл не был указан " + ex);
        }
    }
    public void readFromFile(){
         FileInputStream fileInputStream = null;
         InputStreamReader inputStreamReader = null;

        try{
            fileInputStream = new FileInputStream(fileInputName);
            inputStreamReader = new InputStreamReader(fileInputStream);

            sb = new StringBuilder();

            while (inputStreamReader.ready()){
                sb.append((char)inputStreamReader.read());
            }
            System.out.println("Данные из файла были записаны в строку. Для получения вывода вызовите метод printSB()");
        }catch (IOException ex){
            System.err.println("Произошла ошибка при добавлении файла во входящий поток " + ex);
        }catch(NullPointerException ex){
            System.err.println("Не указан файл, из которого следует читать данные " + ex);
        }
        finally{
            try{
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if(inputStreamReader != null){
                    inputStreamReader.close();
                }
                }catch(IOException ex){
                System.err.println("Произошла ошибка при закрытии " + ex);
            }
        }
    }

    public void writeToFile(String str){
        FileOutputStream fileOutputStream = null;
        PrintWriter printWriter = null;

        try{
            fileOutputStream = new FileOutputStream(fileOutputName);
            printWriter = new PrintWriter(fileOutputStream);

            printWriter.println(str);
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

    public String getString(){
        if (sb.toString().equals("")){
            return "nothing";
        }
        else return sb.toString();
    }
}
