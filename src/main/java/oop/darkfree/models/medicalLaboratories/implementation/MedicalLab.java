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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicalLab that = (MedicalLab) o;

        if (labName != null ? !labName.equals(that.labName) : that.labName != null) return false;
        if (res != null ? !res.equals(that.res) : that.res != null) return false;
        if (extrPoint != that.extrPoint) return false;
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode() {
        int result = labName != null ? labName.hashCode() : 0;
        result = 31 * result + (res != null ? res.hashCode() : 0);
        result = 31 * result + (extrPoint != null ? extrPoint.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
