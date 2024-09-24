package com.ex02.student.mapper;

import com.ex02.student.po.Student;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper1 {
    Student selectStudentBySno(String sno);
    List<Student> selectStudentBySname(String sname);
    Integer insertStudent(Student student);
    Integer deleteStudent(String sno);
    Integer updateStudent(Student student);

}
// ……
