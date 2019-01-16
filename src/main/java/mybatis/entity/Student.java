package mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author yaodw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer classId;
    private Class aClass;
    private Integer schoolId;
    private School school;

    public Student(String name, Integer classId, Integer schoolId) {
        this.name = name;
        this.classId = classId;
        this.schoolId = schoolId;
    }
}
