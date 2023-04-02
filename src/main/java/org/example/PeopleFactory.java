package org.example;

import java.util.Random;

public class PeopleFactory {
    private Excel_names provider;

    public PeopleFactory(Excel_names provider) {
        this.provider = provider;
    }

    public Person createPerson(String type) {
        Person person = null;
        String gender = generateGender();
        String middlename = generateMiddleName(gender);
        String name = generateName(gender);
        System.out.println(gender);

        if (type.equals("professor")) {
            String second_name = generateLastName(gender);
            person = new Professor(name, second_name, middlename);

        } else if (type.equals("student")) {
            String second_name = generateStudentLastName(gender);
            person = new Student(name, second_name, middlename);
        }
        return person;
    }

    private String generateGender() {
        Random random = new Random();
        int n = random.nextInt(2);
        if (n == 0) {
            return "female";

        } else {
            return "male";
        }
    }

    private String generateLastName(String gender) {
        String second_name;
        System.out.println(gender);
        if (gender.equals("male")) {
            second_name = provider.getMale_teacher_lastname();
            System.out.println("M_sn" + second_name);
        } else {
            second_name = provider.getFemale_teacher_lastname();
            System.out.println("F_sn" + second_name);
        }
        return second_name;
    }

    private String generateMiddleName(String gender) {
        System.out.println(gender);
        String name;
        if (gender.equals("male")) {
            name = provider.getMale_middlename();
            System.out.println("M_mn" + name);
        } else {
            name = provider.getFemale_middlename();
            System.out.println("F_mn" + name);
        }

        return name;
    }

    private String generateStudentLastName(String gender) {
        System.out.println(gender);
        String name;
        if (gender.equals("male")) {
            name = provider.getMale_student_lastname();
        } else {
            name = provider.getFemale_student_lastname();
        }
        return name;
    }

    private String generateName(String gender) {
        System.out.println(gender);
        String name;
        if (gender.equals("male")) {
            name = provider.getMale_firstname();
        } else {
            name = provider.getFemale_firstname();
        }
        return name;
    }

}

