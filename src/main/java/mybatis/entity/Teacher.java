package mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author yaodw
 */
@Data
@ToString(exclude = {"classes"})
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer schoolId;
    private School school;
    private Set<Class> classes = new HashSet<>();

    public Teacher(String name, Integer schoolId) {
        this.name = name;
        this.schoolId = schoolId;
    }

}
