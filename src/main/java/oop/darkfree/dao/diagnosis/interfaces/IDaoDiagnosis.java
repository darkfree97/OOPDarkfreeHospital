package oop.darkfree.dao.diagnosis.interfaces;

import oop.darkfree.models.diagnosis.implementation.Diagnosis;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoDiagnosis {
    List<Diagnosis> getAll();
    Diagnosis getDiagnosis(String name);
    void createDiagnosis(Diagnosis diagnosis);
    void updateDiagnosis(String key,Diagnosis diagnosis);
    void deleteDiagnosis(String name);
}
