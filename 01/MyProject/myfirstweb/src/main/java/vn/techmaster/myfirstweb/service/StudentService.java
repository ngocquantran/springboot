package vn.techmaster.myfirstweb.service;

import vn.techmaster.myfirstweb.model.Student;

import java.util.ArrayList;

public class StudentService {
    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("111","Trần Hoàng Mai","10A1"));
        students.add(new Student("112","Trần Văn Nam","10A2"));
        students.add(new Student("113","Trần Bá Dương","10A3"));
        return students;
    }

    public ArrayList<Student> addNewStudent(ArrayList<Student> students,String id,String name, String className){
        students.add(new Student(id,name,className));
        return students;
    }
}
