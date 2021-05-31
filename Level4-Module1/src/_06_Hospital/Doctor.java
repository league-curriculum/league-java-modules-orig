package _06_Hospital;

import java.util.ArrayList;

public abstract class Doctor {
    
    private ArrayList<Patient> patients;
    private boolean makesHouseCalls;
    private boolean performsSurgery;
    
    public Doctor() {
        patients = new ArrayList<Patient>();
        setMakesHouseCalls(false);
        setPerformsSurgery(false);
    }
    
    public void doMedicine() {
        for (int i = 0; i < patients.size(); i++) {
            patients.get(i).checkPulse();
        }
    }
    
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
    public void assignPatient(Patient newPatient) throws DoctorFullException {
        if(patients.size() >= 3) {
            throw new DoctorFullException();
        } else {
            patients.add(newPatient);
        }
        
    }

    public boolean getMakesHouseCalls() {
        return makesHouseCalls;
    }

    public void setMakesHouseCalls(boolean makesHouseCalls) {
        this.makesHouseCalls = makesHouseCalls;
    }

    public boolean getPerformsSurgery() {
        return performsSurgery;
    }

    public void setPerformsSurgery(boolean performsSurgery) {
        this.performsSurgery = performsSurgery;
    }

}
