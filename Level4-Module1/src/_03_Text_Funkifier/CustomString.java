package _03_Text_Funkifier;

public class CustomString implements TextFunkifier {

    private String unfunkifiedText;

    public CustomString(String unfunkifiedText) {

        this.unfunkifiedText = unfunkifiedText;

    }

    @Override
    public String funkifyText() {

        String funkifiedText = "";
        String[] splitString = unfunkifiedText.split(" ");

        for (int i = splitString.length - 1; i >= 0; i--) {

            if (i == splitString.length - 1) {
                splitString[i] = splitString[i].substring(0, 1).toUpperCase()
                        + splitString[i].substring(1);
            } else if (i == 0) {
                splitString[i] = splitString[i].toLowerCase();
            }
            
            funkifiedText += splitString[i] + " ";

        }
        
        return funkifiedText.trim();

    }

}
