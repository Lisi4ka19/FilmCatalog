package filmcatalog.filmcatalog.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Size(min=2, message = "Name - required field")
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Range(min=1900, max=2300, message = "Incorrect data - Year of issue")
    @Column(name="year_issue")
    private int yearOfIssue;

    @Size(min=2, message = "Producer - required field")
    @Column(name="producer")
    private String producer;

    @Column(name="image")
    private byte[] image;

    @Column(name="username")
    String username;


    public Film() {
    }

    public Film(String name, String description, int yearOfIssue, String producer) {
        this.name = name;
        this.description = description;
        this.yearOfIssue = yearOfIssue;
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", producer='" + producer + '\'' +
                '}';
    }
}



