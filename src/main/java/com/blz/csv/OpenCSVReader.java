package com.blz.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    public static void main(String[] args) throws IOException, CsvException {

        /** By Pojo class we are reading
         *
         */

        String csvPath = "C:\\java\\AnnotationAndThirdPartyLibrary\\src\\main\\resources\\User.csv";
        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
        List<CSVUser> csvUsers = csvToBean.parse();

        System.out.println(csvUsers);


        /** First way we read the class
         *
         */
//        String csvPath = "C:\\java\\AnnotationAndThirdPartyLibrary\\src\\main\\resources\\User.csv";
//        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
//
//        CSVReader csvReader = new CSVReader(reader);
//
//        String[] nextRecord;
//        //int count = 0;
//        csvReader.readNext();
        /**Traverse the data from array value **/
//        while ((nextRecord = csvReader.readNext()) != null) {
//            //count++;
//            // if(count==1){
//            //continue;
//            //csvReader.skip(2);
//            // }
//            System.out.println("Name : " + nextRecord[0]);
//            System.out.println("Email : " + nextRecord[1]);
//            System.out.println("Phone : " + nextRecord[2]);
//            System.out.println("Country : " + nextRecord[3]);
//            System.out.println();
//        }

        /** Second way read the class
         *
         */

//        String csvPath = "C:\\java\\AnnotationAndThirdPartyLibrary\\src\\main\\resources\\User.csv";
//        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
//
//        CSVReader csvReader = new CSVReader(reader);
//        List<String[]> list = csvReader.readAll();

      /**Iterate the data from list **/
//        for (String[] array : list
//        ) {
//            System.out.println("Name : " + array[0]);
//            System.out.println("Email : " + array[1]);
//            System.out.println("Phone : " + array[2]);
//            System.out.println("Country : " + array[3]);
//            System.out.println();
//        }
    }
}
