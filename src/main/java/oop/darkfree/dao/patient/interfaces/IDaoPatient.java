package oop.darkfree.dao.patient.interfaces;

import oop.darkfree.models.patient.implementation.Patient;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoPatient {
    List<Patient> getAll();
    Patient getPatient(int id);
    void createPatient(Patient patient);
    void updatePatient(Integer key,Patient patient);
    void deletePatient(int id);
}
