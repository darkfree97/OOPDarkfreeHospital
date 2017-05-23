package oop.darkfree.dao.medicine.interfaces;

import oop.darkfree.models.medicine.implementation.Medicine;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoMedicine {
    List<Medicine> getAll();
    Medicine getMedicine(String name);
    void createMedicine(Medicine medicine);
    void updateMedicine(Medicine medicine);
    void deleteMedicine(String name);
}
