package oop.darkfree.servise.medicine.imlementations;

import oop.darkfree.dao.medicine.implementations.DaoMedicine;
import oop.darkfree.dao.medicine.interfaces.IDaoMedicine;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.servise.medicine.interfaces.ISMedicine;

import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public class SMedicine implements ISMedicine {
    IDaoMedicine medicines = new DaoMedicine();

    public SMedicine() {
    }

    public SMedicine(IDaoMedicine medicines) {

        this.medicines = medicines;
    }

    public IDaoMedicine getMedicines() {

        return medicines;
    }

    public void setMedicines(IDaoMedicine medicines) {
        this.medicines = medicines;
    }

    @Override
    public List<Medicine> getAll() {
        return medicines.getAll();
    }

    @Override
    public Medicine getMedicine(String name) {
        return medicines.getMedicine(name);
    }

    @Override
    public void createMedicine(Medicine medicine) {
        medicines.createMedicine(medicine);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        medicines.updateMedicine(medicine);
    }

    @Override
    public void deleteMedicine(String name) {
        medicines.deleteMedicine(name);
    }
}
