package oop.darkfree.dao.doctor.interfaces;

import oop.darkfree.models.doctor.implementation.Doctor;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoDoctor {
    List<Doctor> getAll();
    Doctor getDoctor(int id);
    void createDoctor(Doctor doctor);
    void updateDoctor(Integer key, Doctor doctor);
    void deleteDoctor(int id);
}
