package oop.darkfree.models.diagnosis.interfaces;

import oop.darkfree.models.medicine.interfaces.IMedicine;

/**
 * Created by Darkfree on 12.03.2017.
 */
public interface IDiagnosis {
    String getDiagnosis();
    void setDiagnosis(String diagnosis);
    IMedicine getMedicine();
    void setMedicine(IMedicine medicine);
    String getTakingMedicine();
    Integer getTherapyPeriodByDays();
    void setTherapyPeriodByDays(Integer therapyPeriodByDays);
    Double getTreatmentCost();
}
