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
    private static MedicalLab temp;

    public DaoMedLab() {

    }

    public DaoMedLab(List<MedicalLab> medicalLabs) {
        this.medicalLabs = medicalLabs;
    }

    @Override
    public List<MedicalLab> getAll() {
        return medicalLabs;
    }

    @Override
    public void createMedicalLab(MedicalLab medicalLab) {
        medicalLabs.add(medicalLab);
    }

    @Override
    public void updateMedicalLab(String key, MedicalLab medicalLab) {
        temp=null;
        medicalLabs.forEach(p->{
            if(p.getLabName().equals(key))
                temp=p;
        });
        medicalLabs.set(medicalLabs.indexOf(temp),medicalLab);
    }

    @Override
    public MedicalLab getMedicalLab(String name) {
        return medicalLabs.stream().filter(p->p.getLabName().equals(name)).findFirst().get();
    }

    @Override
    public void deleteMedicalLab(String name) {
        temp=null;
        medicalLabs.forEach(p->{
            if(p.getLabName().equals(name))
                temp=p;
        });
        medicalLabs.remove(temp);
    }

    public List<MedicalLab> getMedicalLabs() {
        return medicalLabs;
    }

    public void setMedicalLabs(List<MedicalLab> medicalLabs) {
        this.medicalLabs = medicalLabs;
    }
}
