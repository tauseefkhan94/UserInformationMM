package com.example.UserInformationMM.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    String[] HEADERS = {"id", "firstname", "lastname", "email", "profession", "dateCreated", "country", "city"};

    public String getUser(String firstname, String lastname) throws IOException {

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

                if(Objects.equals(fname, firstname) && Objects.equals(lname, lastname)){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return id + " " + fname + " " + lname + " " + email + " " + profession + " " + dateCreated + " " + country + " " + city;
    }

    public List<String> getuserListBetweenDateRange(String startDate, String endDate) throws IOException {

        String id = "";
        String fname = "";
        String lname = "";
        String email = "";
        String profession = "";
        String dateCreated = "";
        String country = "";
        String city = "";

        List<String> users = new ArrayList<>();

        try{
            Reader reader = new FileReader("src/main/resources/UserInformation.csv");

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date sDate = df.parse(startDate);
            Date eDate = df.parse(endDate);

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            Iterable<CSVRecord> records = csvFormat.parse(reader);

            for (CSVRecord record : records){
                Date date = df.parse(record.get(5));

                id = record.get("id");
                fname = record.get("firstname");
                lname = record.get("lastname");
                email = record.get("email");
                profession = record.get("profession");
                dateCreated = record.get("dateCreated");
                country = record.get("country");
                city = record.get("city");

                if(date.after(sDate) && date.before(eDate)){
                    users.add(id + " " + fname + " " + lname + " " + email + " " + profession + " " + dateCreated + " " + country + " " + city);
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return users;
    }
}
