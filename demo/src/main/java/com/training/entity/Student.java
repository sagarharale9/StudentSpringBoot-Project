package com.training.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Student {
    private int id;
    private String name;
    private String gender;
    private String course;
    private List<String> hobbies;

    // Constructor
    public Student(int id, String name, String gender, String course, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.hobbies = hobbies;
    }


    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", course='" + course + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
