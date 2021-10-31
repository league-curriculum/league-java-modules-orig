package _06_Hospital;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import junit.framework.TestCase;

/* 
 * 1. Create a Patient class capable of feeling cared for and having their pulse 
 * checked.
 * 
 * 2. Create a Doctor abstract class capable of doing medicine, holding a list 
 * of assigned Patients, assigning patients to the list and getting the list.
 * 
 * 3. Create a subclass of Doctor called GeneralPractitioner capable of making 
 * house calls.
 * 
 * 4. Create a subclass of Doctor called Surgeon capable of performing surgery. 
 * 
 * 5. Create a Hospital class capable of holding lists of Doctors and unassigned 
 * Patients, adding to both lists and assigning up to a maximum of 3 Patients to
 *  Doctors.
 * 
 * 6. Create a DoctorFullException. A Doctor should throw this exception 
 * whenever more than three patients are being assigned to them.
 * 
 * 7. Make all tests pass.
 */

public class HospitalTest extends TestCase {

    private Hospital testHospital = new Hospital();

    public void testAddDoctor() {
        testHospital.addDoctor(new GeneralPractitioner());
        testHospital.addDoctor(new GeneralPractitioner());
        testHospital.addDoctor(new Surgeon());
        assertEquals(3, testHospital.getDoctors().size());
    }

    public void testAddPatient() throws Exception {
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        assertEquals(3, testHospital.getPatients().size());
    }

    public void testDoctorsHaveSpecialties() throws Exception {
        Surgeon testSurgeon = new Surgeon();
        assertEquals(true, testSurgeon.getPerformsSurgery());
        assertEquals(false, testSurgeon.getMakesHouseCalls());

        GeneralPractitioner testGP = new GeneralPractitioner();
        assertEquals(true, testGP.getMakesHouseCalls());
        assertEquals(false, testGP.getPerformsSurgery());
    }

    public void testAssignDoctor() throws Exception {
        Doctor testDoctor = new GeneralPractitioner();
        testDoctor.assignPatient(new Patient());
        assertEquals(1, testDoctor.getPatients().size());
        testDoctor.assignPatient(new Patient());
        assertEquals(2, testDoctor.getPatients().size());
        testDoctor.assignPatient(new Patient());
        assertEquals(3, testDoctor.getPatients().size());
    }

    // When you check a patient's pulse, they feel cared for
    public void testCheckPulse() throws Exception {
        Patient testPatient = new Patient();
        //Note: Getters for booleans generally use "is" instead of "get"
        assertEquals(false, testPatient.isFeelsCaredFor());
        testPatient.checkPulse();
        assertEquals(true, testPatient.isFeelsCaredFor());
    }

    // Doctors work on their Patients by checking their pulses.
    public void testDoctorsWork() throws Exception {
        Doctor testDoctor = new GeneralPractitioner();
        Patient max = new Patient();
        Patient macky = new Patient();
        testDoctor.assignPatient(max);
        testDoctor.assignPatient(macky);
        assertEquals(false, max.isFeelsCaredFor());
        assertEquals(false, macky.isFeelsCaredFor());
        testDoctor.doMedicine();
        assertEquals(true, max.isFeelsCaredFor());
        assertEquals(true, macky.isFeelsCaredFor());
    }

    public void testDoctorsCanOnlyHandle3Patients() throws Exception {
        GeneralPractitioner testDoctor = new GeneralPractitioner();
        testDoctor.assignPatient(new Patient());
        testDoctor.assignPatient(new Patient());
        testDoctor.assignPatient(new Patient());
        try {
            testDoctor.assignPatient(new Patient());
            assertTrue(false);
        } catch (DoctorFullException dfe) {
            assertTrue(true);
        }
        assertTrue(testDoctor.getPatients().size() == 3);
    }

    // Add 3 Doctors and 8 Patients to the testHospital for this test
    public void test8Patients() throws Exception {
       
        testHospital.addDoctor(new Surgeon());
        testHospital.addDoctor(new GeneralPractitioner());
        testHospital.addDoctor(new GeneralPractitioner());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.addPatient(new Patient());
        testHospital.assignPatientsToDoctors();      

        List<Doctor> testDoctors = testHospital.getDoctors();
        assertEquals(3, testDoctors.get(0).getPatients().size());
        assertEquals(3, testDoctors.get(1).getPatients().size());
        assertEquals(2, testDoctors.get(2).getPatients().size());
    }

}
