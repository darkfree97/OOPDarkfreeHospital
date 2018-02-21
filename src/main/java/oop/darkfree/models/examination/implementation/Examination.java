package oop.darkfree.models.examination.implementation;

import oop.darkfree.models.diagnosis.interfaces.IDiagnosis;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;
import oop.darkfree.models.patient.interfaces.IPatient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Darkfree on 07.03.2017.
 */
public class Examination implements IExamination {
    private Integer id;
    private IPatient patient;
    private List<IDoctor> doctors;
    private List<IDiagnosis> diagnoses;
    private List<IMedicalLab> medLabs;
    private Double totalCost;
    private Date date;

    public Examination() {
    }

    public Examination(Integer id, IPatient patient, IDoctor doctor, IDiagnosis diagnos, IMedicalLab medLab, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctors = new ArrayList<>();
        this.diagnoses = new ArrayList<>();
        this.medLabs = new ArrayList<>();
        this.doctors.add(doctor);
        this.medLabs.add(medLab);
        this.diagnoses.add(diagnos);
        this.date = date;
        calculateTotalCost();
    }

    private Double calculateTotalCost(){
        totalCost = 0.0;
        try {
            for (IDoctor doctor1 : doctors){
                if (!doctor1.equals(null))
                    totalCost += doctor1.getCostOfExam();
            }

            for (IDiagnosis diagnos1 : diagnoses){
                if(!diagnos1.equals(null))
                    totalCost += diagnos1.getTreatmentCost();
            }

            for (IMedicalLab medicalLab : medLabs){
                totalCost += medicalLab.getPrice();
            }
        }
        catch (NullPointerException exp){

        }
        return totalCost;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IPatient getPatient() {
        return patient;
    }

    public void setPatient(IPatient patient) {
        this.patient = patient;
    }

    public List<IDoctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<IDoctor> doctors) {
        this.doctors = doctors;
    }

    public List<IDiagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<IDiagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<IMedicalLab> getMedLabs() {
        return medLabs;
    }

    public void setMedLabs(List<IMedicalLab> medLabs) {
        this.medLabs = medLabs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void addDoctors(IDoctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public void addDiagnose(IDiagnosis diagnos) {
        diagnoses.add(diagnos);
    }

    @Override
    public void addMedLab(IMedicalLab medLab) {
        medLabs.add(medLab);
    }

    @Override
    public String toString() {
        return "\n\n<<<<<<<<<<<<<<<<<< Examination Information >>>>>>>>>>>>>>>>>\n"+
                "id=" + id +
                "\nPatient: " + patient.toString() +
                "\nDoctors: " + doctors.toString() +
                "\nDiagnoses: " + diagnoses.toString() +
                "\nMedLabs: " + medLabs.toString() +
                "\nTotal Cost: "+ calculateTotalCost() +
                "\nDate=" + date;
    }

    public Double getTotalCost() {
        return calculateTotalCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Examination that = (Examination) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (patient != null ? !patient.equals(that.patient) : that.patient != null) return false;
        if (doctors != null ? !doctors.equals(that.doctors) : that.doctors != null) return false;
        if (diagnoses != null ? !diagnoses.equals(that.diagnoses) : that.diagnoses != null) return false;
        if (medLabs != null ? !medLabs.equals(that.medLabs) : that.medLabs != null) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (doctors != null ? doctors.hashCode() : 0);
        result = 31 * result + (diagnoses != null ? diagnoses.hashCode() : 0);
        result = 31 * result + (medLabs != null ? medLabs.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
