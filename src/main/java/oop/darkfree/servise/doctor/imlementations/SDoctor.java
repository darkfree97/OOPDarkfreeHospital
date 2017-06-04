package oop.darkfree.servise.doctor.imlementations;

import oop.darkfree.dao.doctor.implementations.DaoDoctor;
import oop.darkfree.dao.doctor.interfaces.IDaoDoctor;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.servise.doctor.interfaces.ISDoctor;

import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public class SDoctor implements ISDoctor {
    IDaoDoctor doctors;

    public SDoctor() {
        doctors = new DaoDoctor();
    }

    public SDoctor(IDaoDoctor doctors) {

        this.doctors = doctors;
    }

    public IDaoDoctor getDoctors() {

        return doctors;
    }

    public void setDoctors(IDaoDoctor doctors) {
        this.doctors = doctors;
    }

    @Override
    public List<Doctor> getAll() {
        return doctors.getAll();
    }

    @Override
    public Doctor getDoctor(int id) {
        return doctors.getDoctor(id);
    }

    @Override
    public void createDoctor(Doctor doctor) {
        doctors.createDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctors.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        doctors.deleteDoctor(id);
    }
}
