package oop.darkfree.dao.patient.implementations;

import oop.darkfree.dao.patient.interfaces.IDaoPatient;
import oop.darkfree.models.patient.implementation.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoPatient implements IDaoPatient {
    List<Patient> patients = new ArrayList<>();

    public DaoPatient() {
    }

    public DaoPatient(List<Patient> patients) {

        this.patients = patients;
    }

    public List<Patient> getPatients() {

        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public List<Patient> getAll() {
        return patients;
    }

    @Override
    public Patient getPatient(int id) {
        return patients.stream().filter(p->p.getPerson().getId()==id).findFirst().get();
    }

    @Override
    public void createPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void updatePatient(Integer key,Patient patient) {
        patients.stream().filter(p->p.getPerson().getId()==key).forEach(p->p = patient);
    }

    @Override
    public void deletePatient(int id) {
        patients.stream().filter(p->p.getPerson().getId()==id).forEach(p->patients.remove(p));
    }
}
