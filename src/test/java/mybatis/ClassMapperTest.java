package mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import mybatis.entity.Class;
import mybatis.mapper.ClassMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassMapperTest {

    @Autowired
    private ClassMapper classMapper;

    @Test
    public void testClassMapper(){
        log.debug("查出所有班级的信息包含老师、学生、学校信息");
        log.debug("-------------------------------");
        long start = System.currentTimeMillis();
        Page<Class> page = PageHelper.startPage(1, 80);
        List<Class> content = classMapper.page();
        System.out.println(page);
        int pages = page.getPages();
        long total = page.getTotal();
        content.forEach(aClass -> {
            System.out.println(aClass);
            aClass.getTeachers().forEach(System.out::println);
            aClass.getStudents().forEach(System.out::println);
        });
        log.debug("---------------" + (System.currentTimeMillis() - start) + " 毫秒" + "----------------");
    }

}
