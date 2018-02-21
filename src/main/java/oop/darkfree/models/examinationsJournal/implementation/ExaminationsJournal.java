package oop.darkfree.models.examinationsJournal.implementation;

import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.diagnosis.interfaces.IDiagnosis;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.implementation.Examination;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.examinationsJournal.interfaces.IBusinessVersOfExmJournal;
import oop.darkfree.models.examinationsJournal.interfaces.IExaminationsJournal;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.medicalLaboratories.interfaces.ExtremePoint;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import oop.darkfree.models.medicine.interfaces.IMedicine;
import oop.darkfree.models.patient.implementation.Patient;
import oop.darkfree.models.patient.interfaces.IPatient;
import oop.darkfree.models.person.implementation.Person;
import oop.darkfree.models.person.interfaces.IPerson;

import java.util.*;

/**
 * Created by Darkfree on 07.03.2017.
 */
public class ExaminationsJournal implements IExaminationsJournal,IBusinessVersOfExmJournal {
    private List<IExamination> examinations;
    static private int doctorsIDs = 0;
    static private int patientIDs;
    static private int examinationsIDs;
    private List<IPatient> patients = new ArrayList<>();
    private List<IDoctor> doctors = new ArrayList<>();
    private List<IDiagnosis> diagnoses = new ArrayList<>();
    private List<IMedicine> medicines = new ArrayList<>();
    private List<IMedicalLab> medicalLabList = new ArrayList<>();

    public int getExaminationsIDs() {
        return examinationsIDs;
    }

    public ExaminationsJournal() {
        examinations = new LinkedList<>();
    }

    public ExaminationsJournal(boolean debug) {
        if(debug){
            patientIDs = 0;
            examinationsIDs = 0;
            examinations = new LinkedList<>();
            doctors.clear();
            patients.clear();
            Random rand = new Random();

            createDoctor("МЕЛЬНИК","Валентин","Тихонович","Лор",5,15.0);
            createDoctor("ШЕВЧЕНКО","Денис","Олегович","Терапевт",10,59.0);
            createDoctor("БОЙКО","Наталія","Борисівна","Хірург",17,23.0);
            createDoctor("БОНДАР","Софія","Адамівна","Венеролог",3,23.0);
            createDoctor("КУЗЬМЕНКО","Захар","Петрович","Стоматолог",43,35.0);
            createDoctor("МАЗУР","Орися","Василівна","Костоправ",21,73.0);
            createDoctor("ПАВЛЮК","Станіслав","Вадимович","Проктолог",9,12.0);


            createPatient("Буркун","Єлисей","Вікторович",1983);
            createPatient("Верига","Назар","Русланович",1975);
            createPatient("Литвин","Гордій","Мойсейович",1994);
            createPatient("Гайдай","Аліна","Мирославівна",1969);
            createPatient("Бебешко","Роман","Генадійович",1973);
            createPatient("Руданська","Галина","Карпівна",1934);
            createPatient("Данилко","Лілія","Михайлівна",1976);
            createPatient("Сіщук","Соломія","Данилівна",1964);
            createPatient("Собків","Іван","Казимирович",1978);
            createPatient("Дахно","Ксенія","Микитівна",2005);

            createMedLab("ЕКГ","good", ExtremePoint.Middle,30.0);
            createMedLab("УЗД","good", ExtremePoint.Low,25.5);
            createMedLab("МРТ","good", ExtremePoint.High,100.0);

            crateMedecine("Аскорбінка", EMedicineType.Pill,"Для укріплення імунітету",32.0);
            crateMedecine("Валер'янка", EMedicineType.Mixture,"Заспокійливе",50.0);
            crateMedecine("Вікодин", EMedicineType.Injection,"Обезболювальне",500.0);


            createDiagnosis("Захворювання 0",medicines.get(rand.nextInt(medicines.size())),"Приймати тричі в день після їжі",7);
            createDiagnosis("Захворювання 1",medicines.get(rand.nextInt(medicines.size())),"Приймати раз в день після їжі",14);
            createDiagnosis("Захворювання 2",medicines.get(rand.nextInt(medicines.size())),"Приймати при сильному болі",30);
            createDiagnosis("Захворювання 3",medicines.get(rand.nextInt(medicines.size())),"Приймати раз в три дні",3);
            createDiagnosis("Захворювання 4",medicines.get(rand.nextInt(medicines.size())),"Приймати перед сном",90);

            for (IPatient patient : patients){
                createExamination(patient,doctors.get(rand.nextInt(doctors.size())),medicalLabList.get(rand.nextInt(medicalLabList.size())),diagnoses.get(rand.nextInt(diagnoses.size())));
            }
        }
    }

    public List<IExamination> getExaminations() {
        return examinations;
    }

    public IDoctor createDoctor(String surname, String name, String fathername, String profession, Integer experience, Double price){
        IPerson person = new Person(doctorsIDs,surname,name,fathername);
        IDoctor doctor = new Doctor(person,profession,experience,price);
        doctors.add(doctor);
        doctorsIDs++;
        return doctor;
    }

    public IPatient createPatient(String surname, String name, String fathername, Integer year){
        IPerson person = new Person(patientIDs,surname,name,fathername);
        IPatient patient = new Patient(person,year);
        patients.add(patient);
        patientIDs++;
        return patient;
    }

    public IMedicalLab createMedLab(String labName, String res, ExtremePoint extrPoint, Double price){
        IMedicalLab medicalLab = new MedicalLab(labName,res,extrPoint,price);
        medicalLabList.add(medicalLab);
        return medicalLab;
    }

    public IExamination createExamination(IPatient patient, IDoctor doctor, IMedicalLab medicalLab, IDiagnosis diagnos){
        IExamination examination = new Examination(examinationsIDs,patient,doctor,diagnos,medicalLab, new Date());
        addExamination(examination);
        examinationsIDs++;
        return examination;
    }

    public IDiagnosis createDiagnosis(String diasnos, IMedicine medicine, String takingMedicine, Integer therapyPeriodByDays){
        IDiagnosis diagnos = new Diagnosis(diasnos,medicine,takingMedicine,therapyPeriodByDays);
        diagnoses.add(diagnos);
        return diagnos;
    }

    public IMedicine crateMedecine(String name, EMedicineType type, String appointment, Double price){
        IMedicine medicine = new Medicine(name,type,appointment,price);
        medicines.add(medicine);
        return medicine;
    }

    public void setExaminations(List<IExamination> examinations) {
        this.examinations = examinations;
    }

    public void addExamination(IExamination examination) {
        examinations.add(examination);
    }

    public void sysOutAll() {
        for (IExamination item : examinations) {
            System.out.println(item.toString());
        }
    }

    public IExamination getElementById(int id){
        for (IExamination item: examinations){
            if(item.getId().intValue()==id){
                return item;
            }
        }
        return null;
    }

    public IExamination getElementByPatient(String surname, String name, String fathername){
        IPerson patient;
        for (IExamination item: examinations){
            patient = item.getPatient().getPerson();
            if(patient.getSurname().intern().equals(surname.intern())&&patient.getName().intern().equals(name.intern())&&patient.getFathername().intern().equals(fathername.intern())){
                return item;
            }
        }
        return null;
    }

    public void updateExaminationById(int id, IPatient patient, IDoctor doctor, IMedicalLab medicalLab, IDiagnosis diagnos){
        try {
            if(patient==(null)&&doctor==(null)&&medicalLab==(null)&&diagnos==(null)){
                removeElementById(id);
            }
            else {
                if(patient!=null){
                    examinations.get(id).setPatient(patient);
                }
                if(doctor!=null){
                    examinations.get(id).getDoctors().clear();
                    examinations.get(id).addDoctors(doctor);
                }
                if(medicalLab!=null){
                    examinations.get(id).getMedLabs().clear();
                    examinations.get(id).addMedLab(medicalLab);
                }
                if(diagnos!=null){
                    examinations.get(id).getDiagnoses().clear();
                    examinations.get(id).addDiagnose(diagnos);
                }
            }
        }
        catch (NullPointerException exp){
            System.err.println("Something wrong");
        }

    }

    public void removeElementById(int id){
        examinations.remove(id);
    }

    @Override
    public ExaminationsJournal getObject() {
        return this;
    }

    @Override
    public Double getAllProfit() {
        Double profit = 0.0;
        for(IExamination examination : examinations){
            profit += examination.getTotalCost();
        }
        return profit;
    }

    @Override
    public Double getProfitByDate(Date date) {
        Double profit = 0.0;
        for(IExamination examination : examinations){
            if(examination.getDate().getDate() == date.getDate()){
                profit += examination.getTotalCost();
            }
        }
        return profit;
    }

    @Override
    public List<IExamination> getFiveTheMostCost() {
        List<IExamination> topFife = new ArrayList<>();
        List<IExamination> copy_examinations = new ArrayList<>();
        copy_examinations.addAll(examinations);
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
        List<IDoctor> doctors_copy = new ArrayList<>();
        List<IDoctor> doctorsToBonus = new ArrayList<>();
        HashMap<IDoctor,Integer> doctorsProductivity = new HashMap<IDoctor, Integer>();
        for (IDoctor doctor : doctors){
            doctorsProductivity.put(doctor,0);
        }
        for (IExamination item : examinations){
            for (IDoctor doctor : item.getDoctors()){
                doctorsProductivity.put(doctor,doctorsProductivity.get(doctor)+1);
            }
        }
        doctors_copy.addAll(doctors);
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
        for (IDoctor doctor : doctorsToBonus){
            System.out.println(doctor+" - "+doctorsProductivity.get(doctor));
        }
        return doctorsToBonus;
    }

    @Override
    public List<IMedicalLab> getLossesLabs(int n) {
        IMedicalLab temp;
        List<IMedicalLab> medLabs_copy = new ArrayList<>();
        List<IMedicalLab> lossesMedLabs = new ArrayList<>();
        HashMap<IMedicalLab,Integer> lossesList = new HashMap<IMedicalLab, Integer>();
        for (IMedicalLab medLab : medicalLabList){
            lossesList.put(medLab,0);
        }
        for (IExamination item : examinations){
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
        for (IMedicalLab medicalLab : lossesMedLabs){
            System.out.println(medicalLab+" - "+lossesList.get(medicalLab));
        }
        return lossesMedLabs;
    }

}
