package oop.darkfree.servise.diagnosis.imlementations;

import oop.darkfree.dao.diagnosis.implementations.DaoDiagnosis;
import oop.darkfree.dao.diagnosis.interfaces.IDaoDiagnosis;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.servise.diagnosis.interfaces.ISDiagnosis;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 05.06.17.
 */
public class SDiagnosisTest {
    ISDiagnosis service;
    IDaoDiagnosis dao;

    public SDiagnosisTest() {
        List<Diagnosis> list = new ArrayList<>();
                list.add(new Diagnosis("Захворювання 0",null,"1",1));
                list.add(new Diagnosis("Захворювання 1",null,"2",2));
                list.add(new Diagnosis("Захворювання 2",null,"3",3));
        dao = new DaoDiagnosis(list);
        service = new SDiagnosis(dao);
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());
    }

    @Test
    public void getDiagnosis() throws Exception {
        Assert.assertEquals("Захворювання 2",service.getDiagnosis("Захворювання 2").getDiagnosis().intern());
    }

    @Test
    public void createDiagnosis() throws Exception {
            service.createDiagnosis(new Diagnosis("Захворювання 3",null,"4",4));
            Assert.assertEquals("Захворювання 3",service.getDiagnosis("Захворювання 3").getDiagnosis().intern());
    }

    @Test
    public void updateDiagnosis() throws Exception {
            service.updateDiagnosis("Захворювання 2",new Diagnosis("Захворювання 3",null,"4",4));
            Assert.assertEquals("Захворювання 3",service.getDiagnosis("Захворювання 3").getDiagnosis().intern());
    }

    @Test
    public void deleteDiagnosis() throws Exception {
            service.deleteDiagnosis("Захворювання 2");
            Assert.assertEquals(2,service.getAll().size());
    }

}