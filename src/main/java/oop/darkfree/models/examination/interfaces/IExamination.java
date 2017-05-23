package oop.darkfree.models.examination.interfaces;

import oop.darkfree.models.diagnosis.interfaces.IDiagnosis;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;
import oop.darkfree.models.patient.interfaces.IPatient;

import java.util.Date;
import java.util.List;

/**
 * Created by Darkfree on 07.03.2017.
 */
public interface IExamination {
    Integer getId();
    void setId(Integer id);
    IPatient getPatient();
    void setPatient(IPatient patient);
    List<IDoctor> getDoctors();
    void setDoctors(List<IDoctor> doctors);
    void addDoctors(IDoctor doctor);
    List<IDiagnosis> getDiagnoses();
    void setDiagnoses(List<IDiagnosis> diagnoses);
    void addDiagnose(IDiagnosis diagnos);
    List<IMedicalLab> getMedLabs();
    void setMedLabs(List<IMedicalLab> medLabs);
    void addMedLab(IMedicalLab medLab);
    Date getDate();
    void setDate(Date date);
    Double getTotalCost();
}
