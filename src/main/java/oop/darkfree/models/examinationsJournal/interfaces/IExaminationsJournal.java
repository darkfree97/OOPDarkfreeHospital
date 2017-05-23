package oop.darkfree.models.examinationsJournal.interfaces;

import oop.darkfree.models.diagnosis.interfaces.IDiagnosis;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.examinationsJournal.implementation.ExaminationsJournal;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;
import oop.darkfree.models.patient.interfaces.IPatient;

import java.util.List;

/**
 * Created by Darkfree on 07.03.2017.
 */
public interface IExaminationsJournal {
    List<IExamination> getExaminations();
    void setExaminations(List<IExamination> examinations);
    void addExamination(IExamination examination);
    IExamination getElementById(int id);
    IExamination getElementByPatient(String surname, String name, String fathername);
    void updateExaminationById(int id, IPatient patient, IDoctor doctor, IMedicalLab medicalLab, IDiagnosis diagnos);
    public void removeElementById(int id);
    void sysOutAll();
    ExaminationsJournal getObject();
}
