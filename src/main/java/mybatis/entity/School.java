package mybatis.entity;

import lombok.*;

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
@EqualsAndHashCode(exclude = {"classes", "students"})
@ToString(exclude = {"classes", "students"})
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Set<Class> classes = new HashSet<>();
    private Set<Student> students = new HashSet<>();

    public int classesSize() {
        return getClasses().size();
    }
    public int studentsSize() {
        return getStudents().size();
    }
}

