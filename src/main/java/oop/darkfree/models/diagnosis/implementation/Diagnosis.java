package oop.darkfree.models.diagnosis.implementation;

import oop.darkfree.models.diagnosis.interfaces.IDiagnosis;
import oop.darkfree.models.medicine.interfaces.IMedicine;



/**
 * Created by Darkfree on 12.03.2017.
 */

public class Diagnosis implements IDiagnosis {
    String diagnosis;
    IMedicine medicine;
    String takingMedicine;
    Integer therapyPeriodByDays;
    Double treatmentCost;

    public Diagnosis() {
    }

    public Diagnosis(String diagnosis, IMedicine medicine, String takingMedicine, Integer therapyPeriodByDays) {
        this.diagnosis = diagnosis;
        this.medicine = medicine;
        this.takingMedicine = takingMedicine;
        this.therapyPeriodByDays = therapyPeriodByDays;
    }

    public void setTreatmentCost() {
        this.treatmentCost = this.medicine.getPrice() * this.therapyPeriodByDays;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public IMedicine getMedicine() {
        return medicine;
    }

    public void setMedicine(IMedicine medicine) {
        this.medicine = medicine;
    }

    public String getTakingMedicine() {
        return takingMedicine;
    }

    public void setTakingMedicine(String takingMedicine) {
        this.takingMedicine = takingMedicine;
    }

    public Integer getTherapyPeriodByDays() {
        return therapyPeriodByDays;
    }

    public void setTherapyPeriodByDays(Integer therapyPeriodByDays) {
        this.therapyPeriodByDays = therapyPeriodByDays;
    }

    public Double getTreatmentCost() {
        return this.medicine.getPrice() * this.therapyPeriodByDays;
    }

    @Override
    public String toString() {
        return "\n  Diagnosis:" +
                "\n     diagnosis - " + diagnosis +
                "\n     medicine - " + medicine +
                "\n     takingMedicine - " + takingMedicine +
                "\n     therapyPeriodByDays - " + therapyPeriodByDays +
                "\n     treatmentCost - " + this.medicine.getPrice() * this.therapyPeriodByDays +
                '\n';
    }
}
