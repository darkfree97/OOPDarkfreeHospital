package oop.darkfree.models.examinationsJournal.interfaces;

import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;

import java.util.Date;
import java.util.List;

/**
 * Created by Darkfree on 19.03.2017.
 */
public interface IBusinessVersOfExmJournal {
    Double getAllProfit();
    Double getProfitByDate(Date date);
    List<IExamination> getFiveTheMostCost();
    List<IDoctor> getNominantToBonus(int n);
    List<IMedicalLab> getLossesLabs(int n);
}
