public class General {
    public static void main(String[] args) {
        BusStop[] stops = {
                new BusStop("Мясникова", 3),
                new BusStop("Романавская Слобода", 2),
                new BusStop("Дворец спорта", 1),
                new BusStop("Гостиница Юбилейная", 2)};
        Thread bus1 = new Thread(new Bus(1, stops));
        bus1.setDaemon(true);
        Thread bus2 = new Thread(new Bus(2, stops));
        bus2.setDaemon(true);
        Thread bus3 = new Thread(new Bus(3, stops));
        bus3.setDaemon(true);
        bus1.start();
        bus2.start();
        bus3.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
