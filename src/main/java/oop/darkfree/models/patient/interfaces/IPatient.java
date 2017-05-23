package oop.darkfree.models.patient.interfaces;

import oop.darkfree.models.person.interfaces.IPerson;

/**
 * Created by Darkfree on 07.03.2017.
 */
public interface IPatient {
    IPerson getPerson();
    void setPerson(IPerson person);
    Integer getYear();
    void setYear(Integer year);
}
