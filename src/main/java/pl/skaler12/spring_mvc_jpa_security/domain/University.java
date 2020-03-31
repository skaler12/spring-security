package pl.skaler12.spring_mvc_jpa_security.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "University")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUniversity")
    private int idUniversity;

    @Column(name = "nameUniversity")
    private String nameUniversity;

    public University() {
    }
    public University(String nameUniversity){
        this.nameUniversity=nameUniversity;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return idUniversity == that.idUniversity &&
                Objects.equals(nameUniversity, that.nameUniversity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUniversity, nameUniversity);
    }

    @Override
    public String toString() {
        return "University{" +
                "idUniversity=" + idUniversity +
                ", nameUniversity='" + nameUniversity + '\'' +
                '}';
    }
}
