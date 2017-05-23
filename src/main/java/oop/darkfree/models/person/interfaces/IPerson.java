package oop.darkfree.models.person.interfaces;

/**
 * Created by Darkfree on 07.03.2017.
 */
public interface IPerson {
    String getInfo();
    int getId();
    void setId(int id);
    String getSurname();
    void setSurname(String surname);
    String getName();
    void setName(String name);
    String getFathername();
    void setFathername(String fathername);
}
