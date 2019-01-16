package mybatis.mapper;

import mybatis.entity.Teacher;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TeacherMapper extends Mapper<Teacher> {

    @Select("select * from Teacher where id in (select class_id from class_teacher where class_id = #{classId})")
    List<Teacher> listTeacherByClassId(Integer classId);

    @Select("select * from Teacher")
    @Results({
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_id", property = "school",
                    one = @One(select = "mybatis.mapper.SchoolMapper.get")
            ),
            @Result(column = "id", property = "classes",
                    many = @Many(select = "mybatis.mapper.ClassMapper.listClassesByTeacherId")
            )
    })
    List<Teacher> page();
}
