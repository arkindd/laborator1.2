package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Excel_names {
    private XSSFWorkbook wb;
    Random rand = new Random();


    ArrayList<String> english_courses = new ArrayList<String>();
    ArrayList<String> english_professors = new ArrayList<String>();
    ArrayList<String> english_uni = new ArrayList<String>();
    ArrayList<String> russian_courses = new ArrayList<String>();
    ArrayList<String> male_teacher_lastname = new ArrayList<String>();
    ArrayList<String> female_teacher_lastname = new ArrayList<String>();
    ArrayList<String> female_firstname = new ArrayList<String>();
    ArrayList<String> male_firstname = new ArrayList<String>();
    ArrayList<String> male_middlename = new ArrayList<String>();
    ArrayList<String> female_middlename = new ArrayList<String>();
    ArrayList<String> male_student_lastname = new ArrayList<String>();
    ArrayList<String> female_student_lastname = new ArrayList<String>();

    public void run_for_names(String file) {
        loadFile(file);
        readNames();
        close();
    }
    public void run_for_courses(String file) {
        loadFile(file);
        readCourses();
        close();
    }



    public void loadFile(String file) {

        try {
            wb = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException ex) {
            Logger.getLogger(Excel_names.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void close() {
        try {
            wb.close();
        } catch (IOException ex) {
            Logger.getLogger(Excel_names.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void readNames() {
        XSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        for (int r = 1; r < 60; r++) {
            XSSFRow row = sheet.getRow(r);
            male_teacher_lastname.add(String.valueOf(row.getCell(1)));
            female_teacher_lastname.add(String.valueOf(row.getCell(2)));
            female_firstname.add(String.valueOf(row.getCell(3)));
            male_firstname.add(String.valueOf(row.getCell(4)));
            male_middlename.add(String.valueOf(row.getCell(5)));
            female_middlename.add(String.valueOf(row.getCell(6)));
            male_student_lastname.add(String.valueOf(row.getCell(7)));
            female_student_lastname.add(String.valueOf(row.getCell(8)));
        }
    }


    private void readCourses() {
        XSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        for (int r = 1; r < 16; r++) {
            XSSFRow row = sheet.getRow(r);
            english_courses.add(String.valueOf(row.getCell(0)));
            english_professors.add(String.valueOf(row.getCell(1)));
            english_uni.add(String.valueOf(row.getCell(2)));
            russian_courses.add(String.valueOf(row.getCell(3)));
        }
    }


    public String getFemale_firstname() {
        int number = rand.nextInt(female_firstname.size());
        return female_firstname.get(number);
    }

    public String getFemale_middlename() {
        int number = rand.nextInt(female_middlename.size());
        return female_middlename.get(number);
    }

    public String getFemale_teacher_lastname() {
        int n = rand.nextInt(female_teacher_lastname.size());
        return female_teacher_lastname.get(n);
    }

    public String getMale_firstname() {
        int n = rand.nextInt(male_firstname.size());
        return male_firstname.get(n);
    }

    public String getMale_student_lastname() {
        int n = rand.nextInt(male_student_lastname.size());
        return male_student_lastname.get(n);
    }

    public String getFemale_student_lastname() {
        int n = rand.nextInt(female_student_lastname.size());
        return female_student_lastname.get(n);
    }

    public String getMale_middlename() {
        int n = rand.nextInt(male_middlename.size());
        return male_middlename.get(n);
    }

    public String getMale_teacher_lastname() {
        int n = rand.nextInt(male_teacher_lastname.size());
        return male_teacher_lastname.get(n);
    }
    public String getEnglish_courses() {
        int n = rand.nextInt(english_courses.size());
        return english_courses.get(n);
    }

    public String getEnglish_professors() {
        int n  = rand.nextInt(english_professors.size());
        return english_professors.get(n);
    }

    public String getEnglish_uni() {
        int n = rand.nextInt(english_uni.size());
        return english_uni.get(n);
    }

    public String getRussian_courses() {
        int n = rand.nextInt(russian_courses.size());
        return russian_courses.get(n);
    }
}
