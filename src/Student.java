public class Student {
    private String mail;
    private String name;

    public Student(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }

    public String getMail() {
        return mail;
    }
    public String getName() {
        return name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    } //Serves no immediate purpose, but exists if we theoretically need to change the Student object or make a new object
    public void setName(String name) {
        this.name = name;
    }
}
