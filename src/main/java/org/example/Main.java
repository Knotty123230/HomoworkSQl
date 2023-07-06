package org.example;

import org.example.service.DatabasePopulateService;

import java.sql.Date;

public class Main {
    public static void main(String[] args){

       new DatabasePopulateService().populateClient("Vitaliy");
       new DatabasePopulateService().populateProject(Date.valueOf("2022-10-12"),
               1, Date.valueOf("2023-01-22"), "Project A");
       new DatabasePopulateService().populateWorker("Vitaliy", "trainee", 1234, 2003);
       new DatabasePopulateService().populateProjectWorker(1,1);
  }
}