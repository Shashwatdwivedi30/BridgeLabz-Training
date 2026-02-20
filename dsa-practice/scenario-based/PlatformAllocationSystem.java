import java.util.*;

class Train implements Comparable<Train>{
    private int trainId;
    private int arrivalTime;
    private int departureTime;

    public Train(int trainId, int arrivalTime, int departureTime){
        this.trainId = trainId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getTrain() {
        return trainId;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getDepartureTime(){
        return departureTime;
    }

    @Override
    public int compareTo(Train other){
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }

    @Override
    public String toString(){
        return "Train" +trainId+ "( " +arrivalTime+ "-" +departureTime+ " )";
    }
}

class Platform{
    private int platformNumber;
    private int nextAvailableTime;
    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.nextAvailableTime = 0; // initially free
    }

    public int getPlatformNumber() {
        return platformNumber; 
    }
    public boolean isAvailable(int arrivalTime) {
        return arrivalTime >= nextAvailableTime;
    }
    public void ocuppy(int departureTime){
        this.nextAvailableTime = departureTime;
    }

    @Override
    public String toString() {
        return "Platform " + platformNumber + " (free after " + nextAvailableTime + ")";
    }
}

class PlatformUnavailableException extends Exception {
    public PlatformUnavailableException(String message) {
        super(message);
    }
}

class RailwayStation{
    private Map<Integer, Platform> platforms = new HashMap<>();
    private PriorityQueue<Train> trainQueue = new PriorityQueue<>();

    public RailwayStation(int numberOfPlatforms){
        for (int i = 1; i <= numberOfPlatforms; i++) {
            platforms.put(i, new Platform(i));
        }
    }

    public void addIncomingTrain(Train train) {
        trainQueue.offer(train);
    }

    public void allocatePlatforms() throws PlatformUnavailableException{
        while (!trainQueue.isEmpty()) {
            Train train = trainQueue.poll();
            Platform allocated = findAvailablePlatform(train);

            if(allocated == null){
                throw new PlatformUnavailableException("No platform available for " + train);
            }

            allocated.ocuppy(train.getDepartureTime());
            System.out.println(train + " allocated to Platform " + allocated.getPlatformNumber());
        }
    }

    private Platform findAvailablePlatform(Train train){
        return platforms.values().stream().filter(p -> p.isAvailable(train.getArrivalTime())).min(Comparator.comparingInt(Platform::getPlatformNumber)).orElse(null);
    }
}

public class PlatformAllocationSystem {
    public static void main(String[] args) {
        try{
            RailwayStation station = new RailwayStation(2);
            station.addIncomingTrain(new Train(101, 900, 930));
            station.addIncomingTrain(new Train(202, 905, 940));
            station.addIncomingTrain(new Train(303, 910, 950));
            station.allocatePlatforms();
        }

        catch(PlatformUnavailableException e){
            System.out.println(e.getMessage());
        }
    }
}