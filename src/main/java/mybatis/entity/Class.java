package mybatis.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author yaodw
 */
@Data
@EqualsAndHashCode(exclude = {"teachers","students"})
@ToString(exclude = {"teachers","students"})
@NoArgsConstructor
@AllArgsConstructor
public class Class {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer schoolId;
    private School school;
    private Set<Teacher> teachers = new HashSet<>();
    private Set<Student> students = new HashSet<>();

    public Class(String name, Integer schoolId) {
        this.name = name;
        this.schoolId = schoolId;
    }

    public int getTeachersSize() {
        return getTeachers().size();
    }

    public int getStudentsSize() {
        return getTeachers().size();
    }
}

