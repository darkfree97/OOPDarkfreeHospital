package oop.darkfree.models.medicine.interfaces;

/**
 * Created by Darkfree on 13.03.2017.
 */
public interface IMedicine {
    String getName();
    void setName(String name);
    String getAppointment();
    void setAppointment(String appointment);
    Double getPrice();
    void setPrice(Double price);
    EMedicineType getType();
    void setType(EMedicineType type);

}
