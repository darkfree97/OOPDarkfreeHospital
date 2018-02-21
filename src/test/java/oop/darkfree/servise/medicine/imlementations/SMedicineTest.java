package oop.darkfree.servise.medicine.imlementations;

import oop.darkfree.dao.medicine.implementations.DaoMedicine;
import oop.darkfree.dao.medicine.interfaces.IDaoMedicine;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import oop.darkfree.servise.medicalLaboratories.interfaces.ISMedLab;
import oop.darkfree.servise.medicine.interfaces.ISMedicine;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darkfree on 05.06.17.
 */
public class SMedicineTest {
    ISMedicine service;
    IDaoMedicine dao;

    public SMedicineTest() {
        List<Medicine> medicines = new ArrayList<>();
        medicines.add(new Medicine("1", EMedicineType.Mixture,"1",0.0));
        medicines.add(new Medicine("2", EMedicineType.Mixture,"2",0.0));
        medicines.add(new Medicine("3", EMedicineType.Mixture,"3",0.0));
        dao = new DaoMedicine(medicines);
        service = new SMedicine(dao);
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());
    }

    @Test
    public void getMedicine() throws Exception {
        Assert.assertEquals("1",service.getMedicine("1").getName());
    }

    @Test
    public void createMedicine() throws Exception {
        service.createMedicine(new Medicine("4", EMedicineType.Mixture,"4",0.0));
        Assert.assertEquals("4",service.getMedicine("4").getName());
    }

    @Test
    public void updateMedicine() throws Exception {
        service.updateMedicine("2",new Medicine("5", EMedicineType.Mixture,"5",0.0));
        Assert.assertEquals("5",service.getMedicine("5").getName());
    }

    @Test
    public void deleteMedicine() throws Exception {
        int size = service.getAll().size();
        service.deleteMedicine("3");
        Assert.assertEquals(true,size>service.getAll().size());
    }

}