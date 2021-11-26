package info.dmerej.ohce;

public class Ohce {
    private String user;
    private CurrentTimeIndicator currentTimeIndicator;
    private Interactor interactor;
    private boolean shouldContinue;
    
    public Ohce(String user, Interactor interactor, CurrentTimeIndicator currentTimeIndicator) {
        this.shouldContinue = true;
        this.user = user;
        this.interactor = interactor;
        this.currentTimeIndicator = currentTimeIndicator;
    }

    public void greet() {
        String greeting;
        CurrentTime currentTime = currentTimeIndicator.getCurrentTime();
        switch (currentTime) {
            case MORNING:
                greeting = "Buenos dias";
                break;
            case AFTERNOON:
                greeting = "Buenas tardes";
                break;
            case NIGHT:
                greeting = "Buenas noches";
                break;
            default:
                throw new RuntimeException("Unhandled current time: " + currentTime.toString());
        }
        interactor.printMessage("¡" + greeting + " " + user + "!");
    }

    public void processInput() {
        String input = interactor.readInput();
        if (input.equals("Stop!")) {
            interactor.printMessage("Adios " + user);
            this.shouldContinue = false;
            return;
        }

        String answer = Reverse.reverse(input);
        interactor.printMessage(answer);
        if (answer.equals(input)) {
            interactor.printMessage("¡Bonita palabra!");
        }
    }

    public boolean shouldContinue() {
        return this.shouldContinue;
    }
}
