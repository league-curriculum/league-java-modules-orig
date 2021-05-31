package _03_Text_Funkifier;

public class MixedCapsString implements TextFunkifier {

    private String unfunkifiedText;

    public MixedCapsString(String unfunkifiedText) {

        this.unfunkifiedText = unfunkifiedText;

    }

    @Override
    public String funkifyText() {

        String mixedCaps = "";

        for (int i = 0; i < unfunkifiedText.length(); i++) {

            if (i % 2 == 0) {

                mixedCaps += unfunkifiedText.substring(i, i + 1).toLowerCase();
            } else {
                
                mixedCaps += unfunkifiedText.substring(i, i + 1).toUpperCase();
            }

        }

        return mixedCaps;
    }

}
