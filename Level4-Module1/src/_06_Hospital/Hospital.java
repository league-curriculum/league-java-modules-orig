package _06_Hospital;

import java.util.ArrayList;

public class Hospital {

    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> unassignedPatients;

    public Hospital() {
        this.doctors = new ArrayList<Doctor>();
        this.unassignedPatients = new ArrayList<Patient>();
    }

    public void assignPatientsToDoctors() throws DoctorFullException {

        for (int i = 0; i < doctors.size(); i++) {

            Doctor currentDoctor = doctors.get(i);

            while (currentDoctor.getPatients().size() < 3
                    && unassignedPatients.size() > 0) {

                currentDoctor.assignPatient(unassignedPatients.remove(0));

            }
        }

    }

    public void addPatient(Patient newPatient) {
        unassignedPatients.add(newPatient);
    }

    public void addDoctor(Doctor newDoctor) {
        doctors.add(newDoctor);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return unassignedPatients;
    }

}
