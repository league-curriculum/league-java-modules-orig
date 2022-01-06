package _01_Spies_On_A_Train;

public class TrainCar {

    private String passenger;
    private String evidence;

    TrainCar(String passenger, String evidence) {

        this.passenger = passenger;
        this.evidence = evidence;

    }

    String questionPassenger() {

        String[] brokenUpEvidence = evidence.split(" ");
        String object = brokenUpEvidence[brokenUpEvidence.length - 1]
                .replace(".", "");

        return "Nice to meet you. My name is " + passenger + ". Hmm... a "
                + object + "? I saw " + evidence + ".";
    }

    @Override
    public String toString() {
        return passenger;
    }

}
