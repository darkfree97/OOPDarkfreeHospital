package oop.darkfree.servise.diagnosis.imlementations;

import oop.darkfree.dao.diagnosis.implementations.DaoDiagnosis;
import oop.darkfree.dao.diagnosis.interfaces.IDaoDiagnosis;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.servise.diagnosis.interfaces.ISDiagnosis;

import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public class SDiagnosis implements ISDiagnosis {
    IDaoDiagnosis diagnosis;

    public SDiagnosis() {
        diagnosis = new DaoDiagnosis();
    }

    public SDiagnosis(IDaoDiagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public IDaoDiagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(IDaoDiagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public List<Diagnosis> getAll() {
        return this.diagnosis.getAll();
    }

    @Override
    public Diagnosis getDiagnosis(String name) {
        return this.diagnosis.getDiagnosis(name);
    }

    @Override
    public void createDiagnosis(Diagnosis diagnosis) {
        this.diagnosis.createDiagnosis(diagnosis);
    }

    @Override
    public void updateDiagnosis(String key, Diagnosis diagnosis) {
        this.diagnosis.updateDiagnosis(key, diagnosis);
    }

    @Override
    public void deleteDiagnosis(String name) {
        this.diagnosis.deleteDiagnosis(name);
    }
}
