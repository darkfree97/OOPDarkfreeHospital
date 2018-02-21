package oop.darkfree.servise.medicalLaboratories.imlementations;

import oop.darkfree.dao.medicalLaboratories.implementations.DaoMedLab;
import oop.darkfree.dao.medicalLaboratories.interfaces.IDaoMedLab;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.medicalLaboratories.interfaces.ExtremePoint;
import oop.darkfree.servise.medicalLaboratories.interfaces.ISMedLab;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 05.06.17.
 */
public class SMedLabTest {
    ISMedLab service;
    IDaoMedLab dao;

    public SMedLabTest() {
        List<MedicalLab> medicalLabs = new ArrayList<>();
        medicalLabs.add(new MedicalLab("1","1", ExtremePoint.Low,0.0));
        medicalLabs.add(new MedicalLab("2","2", ExtremePoint.Low,0.0));
        medicalLabs.add(new MedicalLab("3","3", ExtremePoint.Low,0.0));
        dao = new DaoMedLab(medicalLabs);
        service = new SMedLab(dao);
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());
    }

    @Test
    public void getMedicalLab() throws Exception {
        Assert.assertEquals("2",service.getMedicalLab("2").getLabName());
    }

    @Test
    public void createMedicalLab() throws Exception {
        service.createMedicalLab(new MedicalLab("4","4", ExtremePoint.Low,0.0));
        Assert.assertEquals("4",service.getMedicalLab("4").getLabName());
    }

    @Test
    public void updateMedicalLab() throws Exception {
        service.updateMedicalLab("1",new MedicalLab("5","5", ExtremePoint.Low,0.0));
        Assert.assertEquals("5",service.getMedicalLab("5").getLabName());
    }

    @Test
    public void deleteMedicalLab() throws Exception {
        int size = service.getAll().size();
        service.deleteMedicalLab("3");
        Assert.assertEquals(true,size>service.getAll().size());
    }
}