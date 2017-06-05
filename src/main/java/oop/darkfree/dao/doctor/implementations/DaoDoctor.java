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
    private static Doctor temp;

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
    public void updateDoctor(Integer key, Doctor doctor) {
        temp=null;
        doctors.forEach(p->{
            if(key.equals(p.getPerson().getId())){
                temp = p;
            }
        });
        doctors.set(doctors.indexOf(temp),doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        temp=null;
        doctors.forEach(p->{
            if(p.getPerson().getId()==id){
                temp = p;
            }
        });
        doctors.remove(temp);
    }
}
