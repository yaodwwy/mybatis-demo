package mybatis.mapper;

import mybatis.entity.Class;
import mybatis.entity.School;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yaodw
 */
public interface SchoolMapper extends Mapper<School> {

    @Select("select * from School where id = #{id}")
    @Results({
            @Result(column = "id", property = "classes",
                    many = @Many(select = "mybatis.mapper.ClassMapper.listClassesBySchoolId")
            ),
            @Result(column = "id", property = "students",
                    many = @Many(select = "mybatis.mapper.StudentMapper.listStudentsBySchoolId")
            )
    })
    School get(Integer id);

    @Select("select * from School")
    @Results({
            @Result(column = "id", property = "classes",
                    many = @Many(select = "mybatis.mapper.ClassMapper.listClassesBySchoolId")
            ),
            @Result(column = "id", property = "students",
                    many = @Many(select = "mybatis.mapper.StudentMapper.listStudentsBySchoolId")
            )
    })
    List<School> page();
}
