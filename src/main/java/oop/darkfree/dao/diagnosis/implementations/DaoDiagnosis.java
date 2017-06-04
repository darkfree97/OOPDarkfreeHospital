package oop.darkfree.dao.diagnosis.implementations;

import oop.darkfree.dao.diagnosis.interfaces.IDaoDiagnosis;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoDiagnosis implements IDaoDiagnosis {
    List<Diagnosis> diagnosises = new ArrayList<>();

    public DaoDiagnosis() {
    }

    public DaoDiagnosis(List<Diagnosis> diagnosises) {
        this.diagnosises = diagnosises;
    }

    public List<Diagnosis> getDiagnosises() {
        return diagnosises;
    }

    public void setDiagnosises(List<Diagnosis> diagnosises) {
        this.diagnosises = diagnosises;
    }

    @Override
    public List<Diagnosis> getAll() {
        return diagnosises;
    }

    @Override
    public Diagnosis getDiagnosis(String name) {
        return diagnosises.stream().filter(p->p.getDiagnosis().equals(name.toString())).findFirst().get();
    }

    @Override
    public void createDiagnosis(Diagnosis diagnosis) {
        diagnosises.add(diagnosis);
    }

    @Override
    public void updateDiagnosis(String key, Diagnosis diagnosis) {
        diagnosises.forEach(p->{
            if(p.getDiagnosis().equals(key))
                p = diagnosis;
        });
    }

    @Override
    public void deleteDiagnosis(String name) {
        diagnosises.stream().filter(p->p.getDiagnosis().equals(name)).forEach(p->diagnosises.remove(p));
    }
}
