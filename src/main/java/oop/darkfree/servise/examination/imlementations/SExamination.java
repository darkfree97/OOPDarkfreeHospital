package oop.darkfree.servise.examination.imlementations;

import oop.darkfree.dao.examination.implementations.DaoExamination;
import oop.darkfree.dao.examination.interfaces.IDaoExamination;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.implementation.Examination;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;
import oop.darkfree.servise.examination.interfaces.ISExamination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */

@Service
public class SExamination implements ISExamination {
    private IDaoExamination examination;

    public SExamination() {
        examination = new DaoExamination();
    }

    public SExamination(IDaoExamination examination) {

        this.examination = examination;
    }

    public IDaoExamination getExamination() {
        return this.examination;
    }

    public void setExamination(IDaoExamination examination) {
        this.examination = examination;
    }

    @Override
    public List<Examination> getAll() {
        return this.examination.getAll();
    }

    @Override
    public Examination getExamination(int id) {
        return this.examination.getExamination(id);
    }

    @Override
    public void createExamination(Examination examination) {
        this.examination.createExamination(examination);
    }

    @Override
    public void updateExamination(Integer key,Examination examination) {
        this.examination.updateExamination(key, examination);
    }

    @Override
    public void deleteExamination(int id) {
        this.examination.deleteExamination(id);
    }

    @Override
    public void showAll() {
        this.examination.showAll();
    }

    @Override
    public Double getAllProfit() {
        Double profit = 0.0;
        List<Examination> examinationList = examination.getAll();
        try {
            for(IExamination examination : examinationList){
                profit += examination.getTotalCost();
            }
        }
        catch (NullPointerException exp){

        }
        return profit;
    }

    @Override
    public Double getProfitByDate(Date date) {
        Double profit = 0.0;
        List<Examination> examinationList = examination.getAll();
        try{
            for(IExamination item : examinationList){
                if(item.getDate().getDate() == date.getDate()){
                    profit += item.getTotalCost();
                }
            }
        }
        catch (NullPointerException exp){

        }
        return profit;
    }

    @Override
    public List<IExamination> getFiveTheMostCost() {
        List<IExamination> topFife = new ArrayList<>();
        List<IExamination> copy_examinations = new ArrayList<>();
        copy_examinations.addAll(this.examination.getAll());
        IExamination temp;
        boolean f;
        for (int i = 0; i < 5; i++) {
            try {
                temp = copy_examinations.get(0);
            }
            catch (IndexOutOfBoundsException exp){
                //System.err.println("Examination Journal is empty");
                break;
            }
            for (IExamination item : copy_examinations){
                if(item.getTotalCost()>temp.getTotalCost()){
                    temp = item;
                }
            }
            topFife.add(temp);
            copy_examinations.remove(temp);
        }
        copy_examinations.clear();
        return topFife;
    }

    @Override
    public List<IDoctor> getNominantToBonus(int n) {
        IDoctor temp;
        List<IDoctor> doctors = new ArrayList<>();
        List<Examination> examinationList = examination.getAll();
        examinationList.forEach(item->item.getDoctors().stream().filter(p->!doctors.contains(p)).forEach(doctors::add));
        List<IDoctor> doctors_copy = new ArrayList<>();
        List<IDoctor> doctorsToBonus = new ArrayList<>();
        HashMap<IDoctor,Integer> doctorsProductivity = new HashMap<>();
        doctors_copy.addAll(doctors);
        for (IDoctor doctor : doctors_copy){
            doctorsProductivity.put(doctor,0);
        }
        for (IExamination item : examinationList){
            for (IDoctor doctor : item.getDoctors()){
                doctorsProductivity.put(doctor,(doctorsProductivity.get(doctor))+1);
            }
        }
        if (n > doctors.size()){
            n = doctors.size();
        }
        for (int i = 0; i < n; i++) {
            temp = doctors_copy.get(0);
            for (IDoctor doctor : doctors_copy){
                if(doctorsProductivity.get(temp)<doctorsProductivity.get(doctor)){
                    temp = doctor;
                }
            }
            doctorsToBonus.add(temp);
            doctors_copy.remove(temp);
        }
        return doctorsToBonus;
    }

    @Override
    public List<IMedicalLab> getLossesLabs(int n) {
        IMedicalLab temp;
        List<IMedicalLab> medicalLabList = new ArrayList<>();
        List<Examination> examinationList = examination.getAll();
        examinationList.forEach(item->item.getMedLabs().stream().filter(p->!medicalLabList.contains(p)).forEach(medicalLabList::add));
        List<IMedicalLab> medLabs_copy = new ArrayList<>();
        List<IMedicalLab> lossesMedLabs = new ArrayList<>();
        HashMap<IMedicalLab,Integer> lossesList = new HashMap<>();
        for (IMedicalLab medLab : medicalLabList){
            lossesList.put(medLab,0);
        }
        for (IExamination item : examinationList){
            for (IMedicalLab medLab : item.getMedLabs()){
                lossesList.put(medLab,lossesList.get(medLab)+1);
            }
        }
        medLabs_copy.addAll(medicalLabList);
        if (n > medicalLabList.size()){
            n = medicalLabList.size();
        }
        for (int i = 0; i < n; i++) {
            temp = medLabs_copy.get(0);
            for (IMedicalLab medLab : medLabs_copy){
                if(lossesList.get(temp)>=lossesList.get(medLab)){
                    temp = medLab;
                }
            }
            lossesMedLabs.add(temp);
            medLabs_copy.remove(temp);
        }
        return lossesMedLabs;
    }
}
