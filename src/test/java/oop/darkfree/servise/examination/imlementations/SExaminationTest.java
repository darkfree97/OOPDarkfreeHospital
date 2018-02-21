package oop.darkfree.servise.examination.imlementations;

import oop.darkfree.dao.examination.implementations.DBDaoExaminations;
import oop.darkfree.dao.examination.implementations.DaoExamination;
import oop.darkfree.dao.examination.interfaces.IDaoExamination;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.examination.implementation.Examination;
import oop.darkfree.models.examinationsJournal.implementation.ExaminationsJournal;
import oop.darkfree.models.examinationsJournal.interfaces.IExaminationsJournal;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import oop.darkfree.models.patient.implementation.Patient;
import oop.darkfree.models.person.implementation.Person;
import oop.darkfree.servise.examination.interfaces.ISExamination;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 05.06.17.
 */
public class SExaminationTest {
    ExaminationsJournal log = new ExaminationsJournal(true);
    ISExamination services;
    private static int count;

    public SExaminationTest() {
        List<Examination> examinations = new ArrayList<>();
        log.getExaminations().forEach(p->{
            examinations.add((Examination) p);
        });
        count = examinations.size();
        services = new SExamination(new DaoExamination(examinations));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(count,services.getAll().size());
    }

    @Test
    public void getExamination() throws Exception {
        Assert.assertEquals( 0,services.getExamination(0).getId().intValue());
    }

    @Test
    public void createExamination() throws Exception {
        services.createExamination(new Examination(100,new Patient(new Person(100,"1","1","1"),0),new Doctor(),new Diagnosis(),new MedicalLab(),new Date()));
        Assert.assertEquals(100,services.getExamination(100).getId().intValue());
    }

    @Test
    public void updateExamination() throws Exception {
        services.updateExamination(log.getExaminationsIDs()-1,new Examination(101,new Patient(new Person(101,"1","1","1"),0),new Doctor(),new Diagnosis(),new MedicalLab(),new Date()));
        Assert.assertEquals(101,services.getExamination(101).getId().intValue());
    }

    @Test
    public void deleteExamination() throws Exception {
        services.deleteExamination(0);
        Assert.assertEquals(true,services.getAll().size()<log.getExaminationsIDs());
    }

    @Test
    public void showAll() throws Exception {
        services.showAll();
    }

    @Test
    public void getAllProfit() throws Exception {
        Assert.assertEquals(true,services.getAllProfit().doubleValue() > 10.0);
    }

    @Test
    public void getProfitByDate() throws Exception {
        Assert.assertEquals(true,services.getProfitByDate(new Date()).doubleValue() > 10.0);
    }

    @Test
    public void getFiveTheMostCost() throws Exception {
        Assert.assertEquals(5,services.getFiveTheMostCost().size());
    }

    @Test
    public void getNominantToBonus() throws Exception {
        Assert.assertEquals(3,services.getNominantToBonus(3).size());
    }

    @Test
    public void getLossesLabs() throws Exception {
        Assert.assertEquals(2,services.getLossesLabs(2).size());
    }

}