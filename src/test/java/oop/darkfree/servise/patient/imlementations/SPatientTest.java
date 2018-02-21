package oop.darkfree.servise.patient.imlementations;

import oop.darkfree.dao.patient.implementations.DaoPatient;
import oop.darkfree.dao.patient.interfaces.IDaoPatient;
import oop.darkfree.models.patient.implementation.Patient;
import oop.darkfree.models.person.implementation.Person;
import oop.darkfree.servise.patient.interfaces.ISPatient;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 05.06.17.
 */
public class SPatientTest {
    ISPatient service;
    IDaoPatient dao;

    public SPatientTest() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(new Person(1,"1","1","1"),0));
        patients.add(new Patient(new Person(2,"2","2","2"),0));
        patients.add(new Patient(new Person(3,"3","3","3"),0));
        dao = new DaoPatient(patients);
        service = new SPatient(dao);
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());
    }

    @Test
    public void getPatient() throws Exception {
        Assert.assertEquals(1,service.getPatient(1).getPerson().getId());
    }

    @Test
    public void createPatient() throws Exception {
        service.createPatient(new Patient(new Person(4,"4","4","4"),0));
        Assert.assertEquals(4,service.getPatient(4).getPerson().getId());
    }

    @Test
    public void updatePatient() throws Exception {
        service.updatePatient(2,new Patient(new Person(5,"5","5","5"),0));
        Assert.assertEquals(5,service.getPatient(5).getPerson().getId());
    }

    @Test
    public void deletePatient() throws Exception {
        int size = service.getAll().size();
        service.deletePatient(3);
        Assert.assertEquals(true,size>service.getAll().size());
    }

}