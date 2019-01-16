package mybatis;

import lombok.extern.slf4j.Slf4j;
import mybatis.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testStudentMapper() {
        log.debug("查出所有学生信息包含学校、班级、老师、学生信息");
        log.debug("-------------------------------");
        long start = System.currentTimeMillis();
        studentMapper.page().forEach(System.out::println);
        log.debug("---------------" + (System.currentTimeMillis() - start) + " 毫秒" + "----------------");
    }
}
