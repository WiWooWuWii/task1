import java.util.ArrayList;
import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        ArrayList<String> month = new ArrayList<>(){{
            add("Январь");
            add("Февраль");
            add("Март");
            add("Апрель");
            add("Май");
            add("Июнь");
            add("Июль");
            add("Август");
            add("Сентябрь");
            add("Октябрь");
            add("Ноябрь");
            add("Декабрь");
        }};

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
            monthToData[i].nameMonth = month.get(i);
        }
    }

    void addNewNumberStepsPerDay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        int commandMenuAddSteps = sc.nextInt();

        if (commandMenuAddSteps == 1) {
                System.out.println("\nВведите номер месяца от 1 до 12\n");
                System.out.print("> ");
                int monthNumber = sc.nextInt();

                if (monthNumber < 1 | monthNumber > 12) {
                    System.out.println("Неверный номер месяца!");
                    return;
                }

                System.out.println("\nВведите день от 1 до 30\n");
                System.out.print("> ");
                int dayNumber = sc.nextInt();

                if (dayNumber < 1 | dayNumber > 30) {
                    System.out.println("\nНеверный номер дня!\n");
                    return;
                }

                System.out.println("\nВведите количество шагов\n");
                System.out.print("> ");
                int steps = sc.nextInt();

                if (steps < 0) {
                    System.out.println("\nКоличество шагов не может быть отрицательным!\n");
                    return;
                }
                monthToData[monthNumber - 1].days[dayNumber - 1] = steps;
        }
        else if (commandMenuAddSteps == 2) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 30; j++) {
                    monthToData[i].days[j] = (int) (Math.random() * 20000);
                }
            }
        }
    }

    void printDaysAndStepsFromYear() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 30; j++) {
                if (i == 7) {
                    System.out.println((j + 1) + " " + monthToData[i].nameMonth
                            .substring(0, monthToData[i].nameMonth.length() - 1)
                            .toLowerCase() + "а: " + monthToData[i].days[j]);
                } else {
                    System.out.println((j + 1) + " " + monthToData[i].nameMonth
                            .substring(0, monthToData[i].nameMonth.length() - 1)
                            .toLowerCase() + "я: " + monthToData[i].days[j]);
                }
            }
        }
    }

    void changeStepGoal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nТекущая цель по шагам в день: " + goalByStepsPerDay);
        System.out.println("\nВведите новую цель\n");
        System.out.print("> ");
        while (true) {
            goalByStepsPerDay = sc.nextInt();
            if (!(goalByStepsPerDay <= 0)) {
                break;
            }
            System.out.println("\nЦель по количеству шагов не может быть отрицательным или равна нулю!");
            System.out.println("Введите цель по количеству шагов снова.\n");
        }
    }
}