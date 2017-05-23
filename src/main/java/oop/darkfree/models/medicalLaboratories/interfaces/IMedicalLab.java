package oop.darkfree.models.medicalLaboratories.interfaces;

/**
 * Created by Darkfree on 07.03.2017.
 */
public interface IMedicalLab {
    String getLabName();
    void setLabName(String labName);
    String getRes();
    void setRes(String res);
    ExtremePoint getExtrPoint();
    void setExtrPoint(ExtremePoint extrPoint);
    Double getPrice();
    void setPrice(Double price);

}
