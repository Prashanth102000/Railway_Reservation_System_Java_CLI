public class Train {
    String trainName;
    String time;
    int passengerStrength;
    int trainNumber;

    public Train(String trainName, String time, int passengerStrength, int trainNumber) {
        this.trainName = trainName;
        this.time = time;
        this.passengerStrength = passengerStrength;
        this.trainNumber = trainNumber;
    }

    public String toString() {
        System.out.println("Train Name    Time    \t  Passenger Strength     \t  Train Number  \t ");
        return " " + trainName + "       " + time + "        " + passengerStrength + "      " + trainNumber;
    }
}
