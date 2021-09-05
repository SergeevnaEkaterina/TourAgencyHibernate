package LibraryService;

import javax.persistence.*;

@Entity

public class Way {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private long user_id;
    private String name;
    private long price;

    public Way(long id, long user_id, String name, long price) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Way() {
    }

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPerson_id() {
        return user_id;
    }

    public void setAuthor_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
