package mybatis.mapper;

import mybatis.entity.Student;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.provider.ExampleProvider;

import java.util.List;

public interface StudentMapper extends Mapper<Student> {

    @Select("select * from Student where class_id=#{classId}")
    @Results({
            @Result(column = "class_id", property = "classId")
    })
    List<Student> listStudentsByClassId(Integer classId);

    @Select("select * from Student where school_id=#{schoolId}")
    @Results({
            @Result(column = "school_id", property = "schoolId")
    })
    List<Student> listStudentsBySchoolId(Integer schoolId);

    @Select("select * from Student")
    @Results({
            @Result(column = "class_id", property = "classId"),
            @Result(column = "class_id", property = "aClass",
                    one = @One(select = "mybatis.mapper.ClassMapper.get")
            ),
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_id", property = "school",
                    one = @One(select = "mybatis.mapper.SchoolMapper.get")
            ),
    })
    List<Student> page();

}
