package oop.darkfree.models.medicine.implementation;

import oop.darkfree.models.medicine.interfaces.EMedicineType;
import oop.darkfree.models.medicine.interfaces.IMedicine;

/**
 * Created by Darkfree on 13.03.2017.
 */
public class Medicine implements IMedicine{
    String name;
    EMedicineType type;
    String appointment;
    Double price;

    public Medicine() {
    }

    public Medicine(String name, EMedicineType type, String appointment, Double price) {
        this.name = name;
        this.type = type;
        this.appointment = appointment;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public EMedicineType getType() {
        return type;
    }

    public void setType(EMedicineType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  name + " " + type + " " + appointment + " " +  price ;
    }
}
