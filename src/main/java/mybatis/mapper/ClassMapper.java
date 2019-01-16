package mybatis.mapper;

import mybatis.entity.Class;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yaodw
 */
public interface ClassMapper extends Mapper<Class> {
    @Select("select * from Class where id = #{id}")
    @Results({
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_id", property = "school",
                    one = @One(select = "mybatis.mapper.SchoolMapper.get")
            ),
            @Result(column = "class_id", property = "teachers",
                    many = @Many(select = "mybatis.mapper.TeacherMapper.selectTeacherByClassId")
            ),
            @Result(column = "id", property = "students",
                    many = @Many(select = "mybatis.mapper.StudentMapper.listStudentsByClassId")
            )
    })
    Class get(Integer id);

    @Select("select * from Class")
    @Results({
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_id", property = "school",
                    one = @One(select = "mybatis.mapper.SchoolMapper.get")
            ),
            @Result(column = "class_id", property = "teachers",
                    many = @Many(select = "mybatis.mapper.TeacherMapper.listTeacherByClassId")
            ),
            @Result(column = "id", property = "students",
                    many = @Many(select = "mybatis.mapper.StudentMapper.listStudentsByClassId")
            )
    })
    List<Class> page();

    @Select("select * from Class where id in (select teacher_id from class_teacher where teacher_id = #{teacherId})")
    List<Class> listClassesByTeacherId(Integer teacherId);

    @Select("select * from Class where school_id = #{schoolId}")
    List<Class> listClassesBySchoolId(Integer schoolId);


}
