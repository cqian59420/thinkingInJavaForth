package annotation;

import java.io.Serializable;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
public class Student implements Serializable {

    private String name;

    private int age;

    private String studentId;

    public String getName() {
        return name;
    }

    @ValueBind(value = "aa",type = ValueBind.fieldBind.String)
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @ValueBind(value ="12",type = ValueBind.fieldBind.INT)
    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    @ValueBind(value ="12ab",type = ValueBind.fieldBind.INT)
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
