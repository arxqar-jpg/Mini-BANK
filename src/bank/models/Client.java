
package bank.models;

public class Client {
    private String name;
    private int age;
    private String phone;

    public Client(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
}
