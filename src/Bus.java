public class Bus implements Runnable {
    private final int numberOfBus;
    private final BusStop[] busStop;

    public Bus(int numberOfBus, BusStop[] busStop) {
        this.numberOfBus = numberOfBus;
        this.busStop = busStop;
    }

    public int getNumberOfBus() {
        return numberOfBus;
    }

    @Override
    public void run() {
        for (BusStop stop : busStop) {
            stop.appear(this);
        }
    }
}
