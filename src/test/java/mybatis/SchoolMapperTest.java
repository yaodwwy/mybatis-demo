package mybatis;

import lombok.extern.slf4j.Slf4j;
import mybatis.entity.Class;
import mybatis.mapper.ClassMapper;
import mybatis.mapper.SchoolMapper;
import mybatis.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SchoolMapperTest {

    @Autowired
    private SchoolMapper schoolMapper;

    @Test
    public void testSchooMapper() {
        log.debug("查出所有学校的信息");
        log.debug("-------------------------------");
        long start = System.currentTimeMillis();
        schoolMapper.selectAll().forEach(school -> {
            System.out.println(school);
            System.out.println(school.studentsSize() + "名学生");
            System.out.println(school.classesSize() + "个班级");
        });
        log.warn(System.currentTimeMillis() - start + "毫秒");
        log.debug("-------------------------------");
    }

    @Test
    public void testSchoolMapperIncludeClass() {

        log.debug("查出所有学校的信息包含班级、学生");
        log.debug("-------------------------------");
        long start = System.currentTimeMillis();
        schoolMapper.page().forEach(school -> {
            System.out.println(school);
            System.out.println(school.studentsSize() + "名学生");
            System.out.println(school.classesSize() + "个班级");
        });
        log.warn(System.currentTimeMillis() - start + "毫秒");
        log.debug("-------------------------------");
    }
}
