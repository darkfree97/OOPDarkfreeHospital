package oop.darkfree.servise.medicalLaboratories.imlementations;

import oop.darkfree.dao.medicalLaboratories.implementations.DaoMedLab;
import oop.darkfree.dao.medicalLaboratories.interfaces.IDaoMedLab;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.servise.medicalLaboratories.interfaces.ISMedLab;

import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public class SMedLab implements ISMedLab {
    IDaoMedLab medLabs;

    public SMedLab() {
        medLabs = new DaoMedLab();
    }

    public SMedLab(IDaoMedLab medLabs) {

        this.medLabs = medLabs;
    }

    public IDaoMedLab getMedLabs() {

        return medLabs;
    }

    public void setMedLabs(IDaoMedLab medLabs) {
        this.medLabs = medLabs;
    }

    @Override
    public List<MedicalLab> getAll() {
        return medLabs.getAll();
    }

    @Override
    public MedicalLab getMedicalLab(String name) {
        return medLabs.getMedicalLab(name);
    }

    @Override
    public void createMedicalLab(MedicalLab medicalLab) {
        medLabs.createMedicalLab(medicalLab);
    }

    @Override
    public void updateMedicalLab(String key, MedicalLab medicalLab) {
        medLabs.updateMedicalLab(key, medicalLab);
    }

    @Override
    public void deleteMedicalLab(String name) {
        medLabs.deleteMedicalLab(name);
    }
}
