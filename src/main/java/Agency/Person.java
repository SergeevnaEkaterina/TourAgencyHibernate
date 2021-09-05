package Agency;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@DynamicInsert

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private long phoneNumber;
    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
    private List<Way> ways = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(long id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public Person(String name, String lastName, long phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Person() {

    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Way> getBooks() {
        return ways;
    }

    public void setBooks(List<Way> ways) {
        this.ways = ways;
    }
}
