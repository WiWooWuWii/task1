public class Converter {

    int convertToKm(int steps) {
        return (int) (steps * 0.75 / 1000);
    }

    int convertToKk(int steps) {
        return (int) (steps * 0.005);
    }

    int averageOfStepsPerDay(int steps) {
        return (steps / 30);
    }
}