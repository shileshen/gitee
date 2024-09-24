import com.ex02.student.mapper.StudentMapper1;
import com.ex02.student.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

public class StudentMapper1Test {
    StudentMapper1 mapper =null;
    SqlSession sqlSession =null;
    @Before
    public void setUp() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(StudentMapper1.class);
    }



    @Test
    public void selectStudentBySno() {
        Student student = mapper.selectStudentBySno("100000001");
        System.out.println(student);
    }

    @Test
    public void selectStudentBySname() {
        List<Student> students = mapper.selectStudentBySname("刘");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void insertStudent() {
        Student newStudent = new Student();
        newStudent.setSno("100000005");
        newStudent.setSname("河北菜花");
        newStudent.setSsex("男");
        newStudent.setSnative("广东汕头");
        newStudent.setMno(2);

        int result = mapper.insertStudent(newStudent);
        assertEquals(1, result);
        sqlSession.commit();

        Student insertedStudent = mapper.selectStudentBySno("100000005");
        assertNotNull(insertedStudent);
    }

    @Test
    public void deleteStudentBySno() {
        int result = mapper.deleteStudent("100000005");
        assertEquals(1, result);
        sqlSession.commit();

        Student deletedStudent = mapper.selectStudentBySno("100000005");
        assertNull(deletedStudent);
    }

    @Test
    public void updateStudent() {
        Student studentToUpdate = mapper.selectStudentBySno("100000001");
        assertNotNull(studentToUpdate);

        studentToUpdate.setSname("唐三"); // 更新姓名

        int result = mapper.updateStudent(studentToUpdate);
        assertEquals(1, result);
        sqlSession.commit();

        Student updatedStudent = mapper.selectStudentBySno("100000001");
        assertEquals("唐三", updatedStudent.getSname());
    }
    // 请补全其他代码，完成对stu表的其他操作
    // ……
    @After
    public void tearDown() throws Exception {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
