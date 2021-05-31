package _06_Hospital;

public class Patient {
    
    private boolean feelsCaredFor;
    
    public Patient() {
        setFeelsCaredFor(false);
    }
    
    public void checkPulse() {
        setFeelsCaredFor(true);
    }

    public boolean getFeelsCaredFor() {
        return feelsCaredFor;
    }

    public void setFeelsCaredFor(boolean feelsCaredFor) {
        this.feelsCaredFor = feelsCaredFor;
    }
    
    

}
