import com.ex02.student.po.Student;
import com.ex02.student.utils.StudentDBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
public class StudentTest {
    SqlSession sqlSession = StudentDBUtil.getSession();
    int count = -1;
    Student student;
    @Test
    public void findStudentBySno() {


        // 精确查询测试
        Student student = sqlSession.selectOne("com.ex02.student.po.Student.selectStudentBySno", "100000001");
        System.out.println(student);
    }
    @Test
    public void findStudentAll() {
        // 模糊查询测试
        List<Student> list = sqlSession.selectList("com.ex02.student.po.Student.selectStudentBySname", "小");
        for (Student stu : list)
            System.out.println(stu);
    }

    @Test
    public void insertStudent() {
        // 插入记录测试
        student = new Student();
        student.setSno("100000005");
        student.setSname("河北菜花");
        student.setSsex("男");
        student.setSnative("广东汕头");
        student.setMno(2);
        count = sqlSession.insert("com.ex02.student.po.Student.insertStudent", student);
        sqlSession.commit();
        System.out.println("成功插入了" + count + "条记录。");
    }
    // 补充删除记录测试
    @Test void deleteStudent(){
        int result = sqlSession.delete("com.ex02.student.po.Student.deleteStudentBySno", "100000004");
        sqlSession.commit();
        System.out.println("成功删除了" + (result > 0 ? "1条" : "0条") + "记录。");
    }


    // 补充更新记录测试
    @Test void updateStudent(){
        Student studentToUpdate = new Student();
        studentToUpdate.setSno("100000001");
        studentToUpdate.setSname("唐三");
        studentToUpdate.setSsex("女");

        int result = sqlSession.update("com.ex02.student.po.Student.updateStudent", studentToUpdate);
        sqlSession.commit();
        System.out.println("成功更新了" + (result > 0 ? "1条" : "0条") + "记录。");
    }
}

