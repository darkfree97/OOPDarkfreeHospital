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
    }

    @Test
    public void createMedicalLab() throws Exception {
    }

    @Test
    public void updateMedicalLab() throws Exception {
    }

    @Test
    public void deleteMedicalLab() throws Exception {
    }
}