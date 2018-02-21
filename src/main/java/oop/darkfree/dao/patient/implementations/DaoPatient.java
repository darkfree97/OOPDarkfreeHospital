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
    private static Patient temp;
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
        temp=null;
        patients.forEach(p->{
            if(p.getPerson().getId() == key){
                temp = p;
            }
        });
        patients.set(patients.indexOf(temp),patient);
    }

    @Override
    public void deletePatient(int id) {
        temp=null;
        patients.forEach(p->{
            if(p.getPerson().getId() == id){
                temp = p;
            }
        });
        patients.remove(temp);
    }
}
