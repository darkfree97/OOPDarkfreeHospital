package oop.darkfree.dao.doctor.implementations;

import oop.darkfree.dao.doctor.interfaces.IDaoDoctor;
import oop.darkfree.models.doctor.implementation.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoDoctor implements IDaoDoctor {
    List<Doctor> doctors = new ArrayList<>();

    public DaoDoctor() {
    }

    public DaoDoctor(List<Doctor> doctors) {

        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public List<Doctor> getAll() {
        return doctors;
    }

    @Override
    public Doctor getDoctor(int id) {
        return doctors.stream().filter(p->p.getPerson().getId()==id).findFirst().get();
    }

    @Override
    public void createDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {

    }

    @Override
    public void deleteDoctor(int id) {
        doctors.stream().filter(p->p.getPerson().getId()==id).forEach(p->doctors.remove(p));
    }
}
