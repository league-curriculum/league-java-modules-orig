package _04_Morse_Code;

public class MorseCode implements Comparable<MorseCode> {

    private String decoded;
    private String coded;

    public MorseCode(String decoded, String coded) {

        this.decoded = decoded;
        this.coded = coded;

    }

    public MorseCode(String coded) {

        this.coded = coded;

    }

    public String getDecoded() {
        return decoded;
    }

    public String getCoded() {
        return coded;
    }

    @Override
    public int compareTo(MorseCode otherCode) {

        String otherCoded = otherCode.getCoded();
        
        if(coded.equals(otherCoded)) {
        	return 0;
        }
        else if (coded.charAt(otherCoded.length())=='-') {
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return decoded;
    }

}
