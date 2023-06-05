package domain.entity;

public class User {
    private int id;
    private String active;
    private String fullName;
    private String cpf;
    private double income;
    private int profileType;
    
    public User() {};

    public User(int id, String active, String fullName, String cpf, double income, int profileType) {
        this.id = id;
        this.active = active;
        this.fullName = fullName;
        this.cpf = cpf;
        this.income = income;
        this.profileType = profileType;
    }

    public User(String active, String fullName, String cpf, double income, int profileType) {
        this.active = active;
        this.fullName = fullName;
        this.cpf = cpf;
        this.income = income;
        this.profileType = profileType;
    }

    public int getId() {
        return id;
    }

    public String getActive() {
        return active;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public double getIncome() {
        return income;
    }

    public int getProfileType() {
        return profileType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", active='" + active + '\'' +
                ", fullName='" + fullName + '\'' +
                ", cpf='" + cpf + '\'' +
                ", income=" + income +
                ", profileType=" + profileType +
                '}';
    }
}
