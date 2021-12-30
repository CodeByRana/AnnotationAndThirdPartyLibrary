package com.blz.csv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndJSON {
    public static void main(String[] args) {

        String csvFile  = "C:\\java\\AnnotationAndThirdPartyLibrary\\src\\main\\resources\\User.csv"; //Read the data from csv file
        String jsonFile = "C:\\java\\AnnotationAndThirdPartyLibrary\\src\\main\\resources\\User.json"; //Writing the data in json file

        /**Reading from CSV File and writing Json File
         *
         */
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFile));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
            List<CSVUser> csvUsers = csvToBean.parse();
            System.out.println(csvUsers);

            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            System.out.println(json);
            FileWriter writer = new FileWriter(jsonFile);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(jsonFile));
            CSVUser[] csvUser = gson.fromJson(br, CSVUser[].class);
            System.out.println(Arrays.asList(csvUser));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
