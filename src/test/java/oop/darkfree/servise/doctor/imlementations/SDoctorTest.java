package oop.darkfree.servise.doctor.imlementations;

import oop.darkfree.dao.doctor.implementations.DaoDoctor;
import oop.darkfree.dao.doctor.interfaces.IDaoDoctor;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.person.implementation.Person;
import oop.darkfree.servise.doctor.interfaces.ISDoctor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 05.06.17.
 */
public class SDoctorTest {
    ISDoctor service;
    IDaoDoctor dao;

    public SDoctorTest() {
        List<Doctor> list = new ArrayList<>();
        list.add(new Doctor(new Person(1,"1","1","1"),null,0,0.0));
        list.add(new Doctor(new Person(2,"2","2","2"),null,0,0.0));
        list.add(new Doctor(new Person(3,"3","3","3"),null,0,0.0));
        dao = new DaoDoctor(list);
        service = new SDoctor(dao);
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());
    }

    @Test
    public void getDoctor() throws Exception {
        Assert.assertEquals(2,service.getDoctor(2).getPerson().getId());
    }

    @Test
    public void createDoctor() throws Exception {
        service.createDoctor(new Doctor(new Person(4,"4","4","4"),null,0,0.0));
        Assert.assertEquals(4,service.getDoctor(4).getPerson().getId());
    }

    @Test
    public void updateDoctor() throws Exception {
        service.updateDoctor(1,new Doctor(new Person(5,"5","5","5"),null,0,0.0));
        Assert.assertEquals(5,service.getDoctor(5).getPerson().getId());
    }

    @Test
    public void deleteDoctor() throws Exception {
        int size = service.getAll().size();
        service.deleteDoctor(2);
        Assert.assertEquals(true,size>service.getAll().size());
    }

}