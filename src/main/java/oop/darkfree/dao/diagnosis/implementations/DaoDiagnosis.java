package oop.darkfree.dao.diagnosis.implementations;

import oop.darkfree.dao.diagnosis.interfaces.IDaoDiagnosis;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoDiagnosis implements IDaoDiagnosis {
    List<Diagnosis> diagnosises;

    public DaoDiagnosis() {
        diagnosises = new ArrayList<>();
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
                temp = p;
        });
        diagnosises.set(diagnosises.indexOf(temp),diagnosis);
    }
    private static Diagnosis temp;
    @Override
    public void deleteDiagnosis(String name) {
        diagnosises.forEach(p->{
            if(p.getDiagnosis().intern().equals(name.intern()))
               temp = p;
        });
        diagnosises.remove(temp);
    }
}
