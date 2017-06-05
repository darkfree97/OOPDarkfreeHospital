package oop.darkfree.servise.patient.imlementations;

import oop.darkfree.dao.patient.implementations.DaoPatient;
import oop.darkfree.dao.patient.interfaces.IDaoPatient;
import oop.darkfree.models.patient.implementation.Patient;
import oop.darkfree.servise.patient.interfaces.ISPatient;

import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public class SPatient implements ISPatient {
    IDaoPatient patients;

    public SPatient() {
        patients = new DaoPatient();
    }

    public SPatient(IDaoPatient patients) {

        this.patients = patients;
    }

    public IDaoPatient getPatients() {

        return patients;
    }

    public void setPatients(IDaoPatient patients) {
        this.patients = patients;
    }

    @Override
    public List<Patient> getAll() {
        return patients.getAll();
    }

    @Override
    public Patient getPatient(int id) {
        return patients.getPatient(id);
    }

    @Override
    public void createPatient(Patient patient) {
        patients.createPatient(patient);
    }

    @Override
    public void updatePatient(Integer key,Patient patient) {
        patients.updatePatient(key, patient);
    }

    @Override
    public void deletePatient(int id) {
        patients.deletePatient(id);
    }
}
