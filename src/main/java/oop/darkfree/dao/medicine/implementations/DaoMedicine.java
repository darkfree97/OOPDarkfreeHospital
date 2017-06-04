package oop.darkfree.dao.medicine.implementations;

import oop.darkfree.dao.medicine.interfaces.IDaoMedicine;
import oop.darkfree.models.medicine.implementation.Medicine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoMedicine implements IDaoMedicine {
    List<Medicine> medicines = new ArrayList<>();

    @Override
    public List<Medicine> getAll() {
        return medicines;
    }

    @Override
    public Medicine getMedicine(String name) {
        return medicines.stream().filter(p->p.getName().equals(name)).findFirst().get();
    }

    @Override
    public void createMedicine(Medicine medicine) {

    }

    @Override
    public void updateMedicine(String key, Medicine medicine) {

    }

    @Override
    public void deleteMedicine(String name) {
        medicines.stream().filter(p->p.getName().equals(name)).forEach(p->medicines.remove(p));
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public DaoMedicine() {

    }

    public DaoMedicine(List<Medicine> medicines) {

        this.medicines = medicines;
    }
}
