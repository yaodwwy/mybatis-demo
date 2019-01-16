package mybatis;

import lombok.extern.slf4j.Slf4j;
import mybatis.entity.Class;
import mybatis.entity.Teacher;
import mybatis.mapper.ClassMapper;
import mybatis.mapper.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testStudentRepo() {
        log.debug("查出所有老师信息包含学校、班级信息");
        log.debug("-------------------------------");
        long start = System.currentTimeMillis();
        teacherMapper.page().forEach(teacher -> {
            System.out.println(teacher);
            teacher.getClasses().forEach(System.out::println);
        });
        log.debug("---------------" + (System.currentTimeMillis() - start) + " 毫秒" + "----------------");
    }
}
