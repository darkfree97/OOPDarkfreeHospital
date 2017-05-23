package oop.darkfree.dao.medicalLaboratories.implementations;

import oop.darkfree.dao.medicalLaboratories.interfaces.IDaoMedLab;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoMedLab implements IDaoMedLab {
    List<MedicalLab> medicalLabs  = new ArrayList<>();

    @Override
    public List<MedicalLab> getAll() {
        return medicalLabs;
    }

    @Override
    public void createMedicalLab(MedicalLab medicalLab) {
        medicalLabs.add(medicalLab);
    }

    @Override
    public void updateMedicalLab(MedicalLab medicalLab) {
        medicalLabs.stream().filter(p->medicalLab.getLabName().equals(p.getLabName())).forEach(p->p = medicalLab);
    }

    @Override
    public MedicalLab getMedicalLab(String name) {
        return medicalLabs.stream().filter(p->p.getLabName().equals(name)).findFirst().get();
    }

    @Override
    public void deleteMedicalLab(String name) {
        medicalLabs.stream().filter(p->p.getLabName().equals(name)).forEach(p->medicalLabs.remove(p));
    }

    public List<MedicalLab> getMedicalLabs() {
        return medicalLabs;
    }

    public void setMedicalLabs(List<MedicalLab> medicalLabs) {
        this.medicalLabs = medicalLabs;
    }

    public DaoMedLab() {

    }

    public DaoMedLab(List<MedicalLab> medicalLabs) {

        this.medicalLabs = medicalLabs;
    }
}
