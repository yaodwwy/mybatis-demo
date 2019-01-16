package mybatis;

import lombok.extern.slf4j.Slf4j;
import mybatis.entity.*;
import mybatis.entity.Class;
import mybatis.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author yaodw
 */
@Slf4j
@MapperScan(basePackages = "mybatis")
@SpringBootApplication
public class MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(SchoolMapper schoolMapper,
                                  TeacherMapper teacherMapper,
                                  StudentMapper studentMapper,
                                  ClassMapper classMapper,
                                  ClassTeacherMapper classTeacherMapper
    ) {
        return args -> {
            log.debug("开始初始化数据");
            Random random = new Random();
            //初始化20个学校
            for (int i = 1; i <= 20; i++) {
                School school = new School();
                school.setName("双叶幼儿园 第" + i + "分校");
                schoolMapper.insert(school);
                Integer schoolId = school.getId();
                //初始化10个班每校
                for (int j = 1; j <= 10; j++) {
                    Class aClass = new Class("第" + i + j + "班", schoolId);
                    System.out.println(aClass+"--->>");
                    classMapper.insert(aClass);
                    Integer classId = aClass.getId();
                    //初始化10个老师每班
                    for (int t = 1; t <= 5; t++) {
                        Teacher teacher = new Teacher("第" + i + j + t + "号老师", schoolId);
                        teacherMapper.insert(teacher);
                        Integer teacherId = teacher.getId();
                        classTeacherMapper.insert(new ClassTeacher(classId, teacherId));
                    }
                    //初始化1个学生每班
                    for (int s = 1; s <= 1; s++) {
                        Student student = new Student("第" + i + j + s + "名学生", random.nextInt(9) + 1, schoolId);
                        studentMapper.insert(student);
                        Integer studentId = student.getId();
                    }

                }
            }

        };
    }
}



