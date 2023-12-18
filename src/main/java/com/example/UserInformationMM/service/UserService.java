package com.example.UserInformationMM.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class UserService {

    public String getUser(String firstname, String lastname) throws IOException {

        String[] HEADERS = {"id", "firstname", "lastname", "email", "profession", "dateCreated", "country", "city"};

        String id = "";
        String fname = "";
        String lname = "";
        String email = "";
        String profession = "";
        String dateCreated = "";
        String country = "";
        String city = "";

        try{
            Reader reader = new FileReader("src/main/resources/UserInformation.csv");

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            Iterable<CSVRecord> records = csvFormat.parse(reader);

            for (CSVRecord record : records){
                id = record.get("id");
                fname = record.get("firstname");
                lname = record.get("lastname");
                email = record.get("email");
                profession = record.get("profession");
                dateCreated = record.get("dateCreated");
                country = record.get("country");
                city = record.get("city");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return id + " " + fname + " " + lname + " " + email + " " + profession + " " + dateCreated + " " + country + " " + city;
    }
}
