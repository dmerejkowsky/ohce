package info.dmerej.ohce;

public class FakeCurrentTimeIndicator implements CurrentTimeIndicator {
    private CurrentTime currentTime;

    public void setCurrentTime(CurrentTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public CurrentTime getCurrentTime() {
        return currentTime;
    }
}
