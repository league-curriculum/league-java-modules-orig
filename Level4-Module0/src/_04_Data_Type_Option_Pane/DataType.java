package _04_Data_Type_Option_Pane;

public enum DataType {

    BYTE(8), SHORT(16), INT(32), LONG(64), FLOAT(32), DOUBLE(64), BOOLEAN(1),
    CHAR(16);

    private int bits;

    private DataType(int bits) {

        this.bits = bits;

    }

    public int getBits() {

        return this.bits;

    }

}
