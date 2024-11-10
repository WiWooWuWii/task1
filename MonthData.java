class MonthData {
    int[] days = new int[30];
    String nameMonth;

    void printDaysAndStepsFromMonth() {
        System.out.print("\n");
        for (int i = 0; i < days.length; i++) {
            if (i == 7) {
                System.out.println((i + 1) + " " + nameMonth.substring(0, nameMonth.length() - 1)
                        .toLowerCase() + "а: " + days[i]);
            }
            System.out.println((i + 1) + " " + nameMonth.substring(0, nameMonth.length() - 1)
                    .toLowerCase() + "я: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;

        for (int day : days) {
            if (day > maxSteps) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}