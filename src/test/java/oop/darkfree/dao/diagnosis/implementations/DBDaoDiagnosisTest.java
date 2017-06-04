package oop.darkfree.dao.diagnosis.implementations;

import oop.darkfree.dao.diagnosis.interfaces.IDaoDiagnosis;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 04.06.17.
 */
public class DBDaoDiagnosisTest {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    IDaoDiagnosis dao;

    public DBDaoDiagnosisTest() {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/oop");
        dataSource.setUsername("root");
        dataSource.setPassword("Qawasadedrdf102030");
        dao = new DBDaoDiagnosis(dataSource);
    }


    @Test
    public void createDiagnosis() throws Exception {
        Diagnosis diagnosis = new Diagnosis("Test of creation",new Medicine("Test of creation", EMedicineType.Mixture,"Test of creation",30.0),"Test of creation",30);
        dao.createDiagnosis(diagnosis);
        Assert.assertEquals(diagnosis.getDiagnosis().intern(),dao.getDiagnosis("Test of creation").getDiagnosis().intern());
    }

    @Test
    public void getDiagnosis() throws Exception {
        Assert.assertEquals("Test of creation",dao.getDiagnosis("Test of creation").getDiagnosis().intern());
    }

    @Test
    public void updateDiagnosis() throws Exception {
        Diagnosis diagnosis = new Diagnosis("Test of creation",new Medicine("Test of creation", EMedicineType.Mixture,"Test of creation",30.0),"Test of creation",30);
        dao.updateDiagnosis("Test of creation",diagnosis);
        Assert.assertEquals(diagnosis.getDiagnosis().intern(),dao.getDiagnosis("Test of creation").getDiagnosis().intern());
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(false,dao.getAll().isEmpty());
    }

    @Test
    public void deleteDiagnosis() throws Exception {
        dao.deleteDiagnosis("Test of creation");
    }

}