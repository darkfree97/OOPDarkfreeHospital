package oop.darkfree.servise.examination.interfaces;

import oop.darkfree.dao.examination.interfaces.IDaoExamination;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;

import java.util.Date;
import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public interface ISExamination extends IDaoExamination {
    Double getAllProfit();
    Double getProfitByDate(Date date);
    List<IExamination> getFiveTheMostCost();
    List<IDoctor> getNominantToBonus(int n);
    List<IMedicalLab> getLossesLabs(int n);
}
