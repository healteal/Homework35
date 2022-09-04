public class BusStop {
    private final String name;
    private final int maxCountOfBuses;
    private int countOfBuses = 0;

    public BusStop(String name, int countOfBuses) {
        this.name = name;
        this.maxCountOfBuses = countOfBuses;
    }

    public String getName() {
        return name;
    }

    public int getMaxCountOfBuses() {
        return maxCountOfBuses;
    }

    public int getCountOfBuses() {
        return countOfBuses;
    }

    public void setCountOfBuses(int countOfBuses) {
        this.countOfBuses = countOfBuses;
    }

    public synchronized void appear(Bus bus) {
        if (getCountOfBuses() >= getMaxCountOfBuses()) {
            try {
                wait();
                notify();
                return;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        setCountOfBuses(getCountOfBuses() + 1);
        System.out.println("Автобус под номером "
                + bus.getNumberOfBus()
                + " прибыл на остановку "
                + this.getName()
                + " свободных мест: "
                + (getMaxCountOfBuses() - getCountOfBuses()));
        try {
            wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.setCountOfBuses(getCountOfBuses() - 1);
        System.out.println("Автобус под номером "
                + bus.getNumberOfBus()
                + " убыл с остановки "
                + this.getName()
                + " свободных мест: "
                + (getMaxCountOfBuses() - getCountOfBuses()));
        notify();
    }
}
