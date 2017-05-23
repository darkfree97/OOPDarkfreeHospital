package oop.darkfree.dao.medicalLaboratories.interfaces;

import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoMedLab {
    List<MedicalLab> getAll();
    MedicalLab getMedicalLab(String name);
    void createMedicalLab(MedicalLab medicalLab);
    void updateMedicalLab(MedicalLab medicalLab);
    void deleteMedicalLab(String name);
}
