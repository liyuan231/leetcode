package JAVA.serialable;

import java.io.Serializable;

public class School implements Serializable {
    private static final long serialVersionUID = -144554034752678805L;
    private String schoolName;
    private String location;

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public School() {
    }

    public School(String schoolName, String location) {
        this.schoolName = schoolName;
        this.location = location;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
