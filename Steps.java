import java.util.InputMismatchException;
import java.util.Scanner;

public class Steps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println(stepTracker.monthToData[11].nameMonth);

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                printMenu();
                // выбор действия
                System.out.print("> ");
                int commandMenu = sc.nextInt();

                if (commandMenu == 0) {
                    // завершить программу
                    System.exit(0);
                } else if (commandMenu == 1) {
                    // ввести количество шагов за определённый день
                    printMenuAddSteps();
                    stepTracker.addNewNumberStepsPerDay();
                } else if (commandMenu == 2) {
                    // изменить цель по количеству шагов в день
                    stepTracker.changeStepGoal();
                } else if (commandMenu == 3) {
                    // напечатать статистику за определённый месяц
                    System.out.println("\nВведите номер месяц:\n");
                    System.out.print("> ");
                    int monthNumber = sc.nextInt();

                    while (true) {
                        printMenuStat();
                        // выбор действия
                        System.out.print("> ");
                        int commandMenuStat = sc.nextInt();

                        if (commandMenuStat == 0) {
                            // вернуться в главное меню
                            break;
                        } else if (commandMenuStat == 1) {
                            // количество пройденных шагов по дням за месяц
                            stepTracker.monthToData[monthNumber - 1].printDaysAndStepsFromMonth();
                        } else if (commandMenuStat == 2) {
                            // общее количество шагов за месяц
                            System.out.print("\nКоличество шагов за месяц: ");
                            System.out.println(stepTracker.monthToData[monthNumber - 1].sumStepsFromMonth());
                        } else if (commandMenuStat == 3) {
                            // максимальное количество шагов за месяц
                            System.out.print("\nМаксимальное количество шагов в этом месяце: ");
                            System.out.println(stepTracker.monthToData[monthNumber - 1].maxSteps());
                        } else if (commandMenuStat == 4) {
                            // среднее количество шагов
                            System.out.print("\nСреднее количество шагов в день за этот месяц: ");
                            System.out.println(stepTracker.converter.
                                    averageOfStepsPerDay(stepTracker.monthToData[monthNumber - 1].sumStepsFromMonth()));
                        } else if (commandMenuStat == 5) {
                            // пройденная дистанция (в километрах)
                            System.out.println("\nВы прошли: " + stepTracker.converter.
                                    convertToKm(stepTracker.monthToData[monthNumber - 1].sumStepsFromMonth()) + " км");
                        } else if (commandMenuStat == 6) {
                            // количество сожжённых килокалорий
                            System.out.println("\nВы сожгли: " + stepTracker.converter.
                                    convertToKk(stepTracker.monthToData[monthNumber - 1].sumStepsFromMonth()) + " ккал");
                        } else if (commandMenuStat == 7) {
                            // лучшая серия
                            System.out.println("\nЛучшая серия: " + stepTracker.monthToData[monthNumber - 1]
                                    .bestSeries(stepTracker.goalByStepsPerDay) + " дней");
                        } else {
                            System.out.println("\nНеверный формат ввода!");
                        }
                    }
                } else if (commandMenu == 4) {
                    // напечатать статистику за год
                    stepTracker.printDaysAndStepsFromYear();
                } else {
                    System.out.println("\nНеверный формат ввода!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nВведите число!");
            }
        }
    }

    static void printMenu() {
        System.out.println("\nЧто вы хотите сделать?\n");
        System.out.println("0 - завершить программу");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - напечатать статистику за год\n");
    }

    static void printMenuStat() {
        System.out.println("\n0 - вернуться в главное меню");
        System.out.println("1 - количество пройденных шагов по дням за месяц");
        System.out.println("2 - общее количество шагов за месяц");
        System.out.println("3 - максимальное количество шагов за месяц");
        System.out.println("4 - среднее количество шагов");
        System.out.println("5 - пройденная дистанция (в километрах)");
        System.out.println("6 - количество сожжённых килокалорий");
        System.out.println("7 - лучшая серия\n");
    }

    static void printMenuAddSteps() {
        System.out.println("\n0 - вернуться в главное меню");
        System.out.println("1 - ввести кол-во шагов самостоятельно");
        System.out.println("2 - автоматическая генерация шагов за год\n");
    }
}