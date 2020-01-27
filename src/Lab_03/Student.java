package Lab_03;
public class Student
{
    String val;
    private int id;
    private String stdName;
    private int age;
    private String username;
    private String password;
    private String cource;

    public Student() {
    }

    public Student(int id, String stdName, int age, String username, String password, String cource) {
        this.id = id;
        this.stdName = stdName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.cource = cource;
    }
    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}