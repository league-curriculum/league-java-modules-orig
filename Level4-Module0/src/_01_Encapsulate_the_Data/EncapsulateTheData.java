package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot negative. All negative parameters should set
     * itemsReceived to 0.
     */

    private int itemsReceived;

    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

    private double degreesTurned;

    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    private String nomenclature;

    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    private Object memberObj;

    public void setItemsReceived(int itemsReceived) {

        if (itemsReceived < 0) {
            this.itemsReceived = 0;
        } else {
            this.itemsReceived = itemsReceived;
        }
    }

    public void setDegreesTurned(double degreesTurned) {

        if (degreesTurned < 0) {
            this.degreesTurned = 0;
        } else if (degreesTurned > 360) {
            this.degreesTurned = 360;
        } else {
            this.degreesTurned = degreesTurned;
        }
    }

    public void setNomenclature(String nomenclature) {

        if (nomenclature.equals("")) {
            this.nomenclature = " ";
        } else {
            this.nomenclature = nomenclature;
        }

    }

    public void setMemberObj(Object memberObj) {

        if (memberObj instanceof String) {
            this.memberObj = new Object();
        } else {
            this.memberObj = memberObj;
        }

    }

    public int getItemsReceived() {
        return this.itemsReceived;
    }

    public double getDegreesTurned() {
        return this.degreesTurned;
    }

    public String getNomenclature() {
        return this.nomenclature;
    }

    public Object getMemberObj() {
        return this.memberObj;
    }

}
