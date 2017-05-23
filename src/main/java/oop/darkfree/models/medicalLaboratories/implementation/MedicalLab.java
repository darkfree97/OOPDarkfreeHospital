package oop.darkfree.models.medicalLaboratories.implementation;

import oop.darkfree.models.medicalLaboratories.interfaces.ExtremePoint;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;

/**
 * Created by Darkfree on 07.03.2017.
 */


public class MedicalLab implements IMedicalLab {
    private String labName;
    private String res;
    private ExtremePoint extrPoint;
    private Double price;

    public MedicalLab() {
    }

    public MedicalLab(String labName, String res, ExtremePoint extrPoint, Double price) {
        this.labName = labName;
        this.res = res;
        this.extrPoint = extrPoint;
        this.price = price;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public ExtremePoint getExtrPoint() {
        return extrPoint;
    }

    public void setExtrPoint(ExtremePoint extrPoint) {
        this.extrPoint = extrPoint;
    }

    public Double getPrice() {
        Double resPrice = 0.0;
        if (extrPoint.equals(ExtremePoint.Low)) {
            resPrice = price *1;
        }
        else if (extrPoint.equals(ExtremePoint.Middle)) {
            resPrice = price * 2;
        }
        else if (extrPoint.equals(ExtremePoint.High)) {
            resPrice = price * 3;
        }

        return resPrice;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\n  Medical Laboratory:" +
                "\n     Name - " + labName +
                "\n     Result of diagnostic - " + res +
                "\n     Extreme Point - " + extrPoint +
                "\n     Cost - " + price + "\n";
    }
}
