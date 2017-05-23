package oop.darkfree.models.doctor.interfaces;

import oop.darkfree.models.person.interfaces.IPerson;

/**
 * Created by Darkfree on 07.03.2017.
 */
public interface IDoctor {
    IPerson getPerson();
    String toString();
    void setPerson(IPerson person);
    String getProfession();
    Double getCostOfExam();
    void setProfession(String profession);
    Integer getExperience();
    void setExperience(Integer experience);
    void setValueOfExam(Double valueOfExam);
}
