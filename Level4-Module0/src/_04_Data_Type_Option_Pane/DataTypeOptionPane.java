package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType[] dataTypes = DataType.values();

        int type = JOptionPane.showOptionDialog(null, "Choose a data type",
                "Data Type Option Pane", 0, -1, null, dataTypes, 0);

        DataType dataType = dataTypes[type];

        switch (dataType) {
        case BYTE:

            JOptionPane.showMessageDialog(null, "byte can hold up to "
                    + dataType.getBits() + "-bit integer values.");

            break;

        case SHORT:

            JOptionPane.showMessageDialog(null, "short can hold up to "
                    + dataType.getBits() + "-bit integer values.");

            break;

        case INT:

            JOptionPane.showMessageDialog(null, "int can hold up to "
                    + dataType.getBits() + "-bit integer values.");

            break;

        case LONG:

            JOptionPane.showMessageDialog(null, "long can hold up to "
                    + dataType.getBits() + "-bit integer values.");

            break;

        case FLOAT:

            JOptionPane.showMessageDialog(null, "float can hold up to "
                    + dataType.getBits() + "-bit decimal values.");

            break;

        case DOUBLE:

            JOptionPane.showMessageDialog(null, "double can hold up to "
                    + dataType.getBits() + "-bit decimal values.");

            break;

        case BOOLEAN:

            JOptionPane.showMessageDialog(null, "boolean represents "
                    + dataType.getBits() + "-bit values of true or false.");

            break;

        case CHAR:

            JOptionPane.showMessageDialog(null, "char can hold up to "
                    + dataType.getBits() + "-bit character values.");

            break;

        default:
            break;
        }

    }
}

