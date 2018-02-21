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
    private static Medicine temp;

    public DaoMedicine() {

    }

    public DaoMedicine(List<Medicine> medicines) {

        this.medicines = medicines;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public List<Medicine> getAll() {
        return medicines;
    }

    @Override
    public Medicine getMedicine(String name) {

        return medicines.stream().filter(p->p.getName().intern().equals(name.intern())).findFirst().get();
    }

    @Override
    public void createMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    @Override
    public void updateMedicine(String key, Medicine medicine) {
        temp = null;
        medicines.forEach(p->{
            if(p.getName().equals(key))
                temp = p;
        });
        medicines.set(medicines.indexOf(temp),medicine);
    }

    @Override
    public void deleteMedicine(String name) {
        temp = null;
        medicines.forEach(p->{
            if(p.getName().equals(name))
                temp = p;
        });
        medicines.remove(temp);
    }
}
