package oop.darkfree.models.doctor.implementation;

import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.person.interfaces.IPerson;


/**
 * Created by Darkfree on 07.03.2017.
 */

public class Doctor implements IDoctor {
    private IPerson person ;//id name surname fathername
    private String profession;
    private Integer experience;
    private Double valueOfExam;

    public Doctor() {
    }

    public Doctor(IPerson person, String profession, Integer experience, Double valueOfExam) {
        this.person = person;
        this.profession = profession;
        this.experience = experience;
        this.valueOfExam = valueOfExam;
    }

    public void setPerson(IPerson person) {
        this.person = person;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getCostOfExam() {
        return valueOfExam;
    }

    public void setValueOfExam(Double valueOfExam) {
        this.valueOfExam = valueOfExam;
    }

    @Override
    public IPerson getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return  "\n  Doctor:\n     " + person.toString() +
                "\n     profession - " + profession +
                "\n     experience - " + experience +
                "\n     valueOfExam - " + valueOfExam + "\n";
    }
}
