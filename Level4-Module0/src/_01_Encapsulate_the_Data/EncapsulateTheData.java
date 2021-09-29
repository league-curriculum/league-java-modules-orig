package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot negative. All negative parameters should set
     * itemsReceived to 0.
     */

    private int itemsReceived;
    
    public int getItemsReceived() {
        return itemsReceived;
    }
    
    public void setItemsReceived(int itemsReceieved) {
        if(itemsReceieved < 0) {
            this.itemsReceived = 0;
        }
        else {
            this.itemsReceived =  itemsReceieved;
        }
    }

    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

    private double degreesTurned;
    
    public double getDegreesTurned() {
        return degreesTurned;
    }
    
    public void setDegreesTurned(double degreesTurned) {
        if(degreesTurned > 360) {
            this.degreesTurned = 360;
        }
        else if(degreesTurned < 0) {
            this.degreesTurned = 0;
        }
        else {
            this.degreesTurned = degreesTurned;
        }
    }

    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    private String nomenclature;
    
    public String getNomenclature() {
        return nomenclature;
    }
    
    public void setNomenclature(String nomenclature) {
        if(nomenclature.equals("")) {
            this.nomenclature = " ";
        }
        else {
            this.nomenclature = nomenclature;
        }
    }

    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    private Object memberObj;
    
    public Object getMemberObj() {
        return memberObj;
    }
    
    public void setMemberObj(Object memberObj) {
        if(memberObj instanceof String) {
            this.memberObj = new Object();
        }
        else {
            this.memberObj = memberObj;
        }
    }
}