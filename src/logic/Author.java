package logic;

import java.time.LocalDate;
import java.time.Period;

public class Author {
    private int id;
    private String name;

    private String country;

    private LocalDate birthday;

    public Author(int id, String name, String country, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge(){
        return Period.between( birthday, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

