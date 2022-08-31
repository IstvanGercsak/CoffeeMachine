import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Machine machine = new Machine(
                400,
                540,
                120,
                9,
                550);

        Scanner scanner = new Scanner(System.in);
        direction(machine, scanner);

    }

    static class Machine {
        int coffeeMachineHasWater = 0;
        int coffeeMachineHasMilk = 0;
        int coffeeMachineHasCoffeeBeans = 0;
        int coffeeMachineHasDisposableCups = 0;
        int coffeeMachineHasMoney = 0;

        Machine(int coffeeMachineHasWater, int coffeeMachineHasMilk, int coffeeMachineHasCoffeeBeans, int coffeeMachineHasDisposableCups, int coffeeMachineHasMoney) {

            this.coffeeMachineHasWater = coffeeMachineHasWater;
            this.coffeeMachineHasMilk = coffeeMachineHasMilk;
            this.coffeeMachineHasCoffeeBeans = coffeeMachineHasCoffeeBeans;
            this.coffeeMachineHasDisposableCups = coffeeMachineHasDisposableCups;
            this.coffeeMachineHasMoney = coffeeMachineHasMoney;

        }
    }

    public static void direction(Machine machine, Scanner scanner) {

        System.out.println("Write action (buy, fill, take, remaining, exit): ");

        switch (scanner.nextLine()) {
            case "buy":

                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

                switch (scanner.nextLine()) {
                    case "1":
                        makeEspresso(machine, scanner);
                        break;
                    case "2":
                        makeLatte(machine, scanner);
                        break;
                    case "3":
                        makeCappuccino(machine, scanner);
                        break;
                    case "back":
                        direction(machine, scanner);
                        break;
                    default:
                        System.out.println("Wrong number!");
                        direction(machine, scanner);
                }

                break;
            case "fill":
                fill(machine, scanner);
                break;
            case "take":
                take(machine, scanner);
                break;
            case "remaining":
                showBalance(machine);
                direction(machine, scanner);
                break;
            case "exit":
                break;
            default:
                System.out.println("Wrong value");
                direction(machine, scanner);
        }
    }

    public static void makeEspresso(Machine machine, Scanner scanner) {

        int waterNeeded = 250;
        int coffeeBeansNeeded = 16;
        int price = 4;

        if (waterNeeded > machine.coffeeMachineHasWater) {
            System.out.println("Sorry, not enough water!");
            direction(machine, scanner);
//        } else if (coffeeBeansNeeded > machine.coffeeMachineHasCoffeeBeans) {
//            System.out.println("Sorry, not enough coffee beans!");
//            direction(machine, scanner);
        } else {
            machine.coffeeMachineHasWater -= waterNeeded;
            machine.coffeeMachineHasCoffeeBeans -= coffeeBeansNeeded;
            machine.coffeeMachineHasMoney += price;
            machine.coffeeMachineHasDisposableCups--;

            System.out.println("I have enough resources, making you a coffee!");

            direction(machine, scanner);
        }

    }

    public static void makeLatte(Machine machine, Scanner scanner) {

        int waterNeeded = 350;
        int milkNeeded = 75;
        int coffeeBeansNeeded = 20;
        int price = 7;

        if (waterNeeded > machine.coffeeMachineHasWater) {
            System.out.println("Sorry, not enough coffee water!");
            direction(machine, scanner);
//        } else if (milkNeeded > machine.coffeeMachineHasMilk) {
//            System.out.println("Sorry, not enough coffee milk!");
//            direction(machine, scanner);
//        } else if (coffeeBeansNeeded > machine.coffeeMachineHasCoffeeBeans) {
//            System.out.println("Sorry, not enough coffee coffee beans!");
//            direction(machine, scanner);
        } else {

            machine.coffeeMachineHasWater -= waterNeeded;
            machine.coffeeMachineHasMilk -= milkNeeded;
            machine.coffeeMachineHasCoffeeBeans -= coffeeBeansNeeded;
            machine.coffeeMachineHasMoney += price;
            machine.coffeeMachineHasDisposableCups--;

            System.out.println("I have enough resources, making you a coffee!");

            direction(machine, scanner);
        }
    }

    public static void makeCappuccino(Machine machine, Scanner scanner) {

        int waterNeeded = 200;
        int milkNeeded = 100;
        int coffeeBeansNeeded = 12;
        int price = 6;

        if (waterNeeded > machine.coffeeMachineHasWater) {
            System.out.println("Sorry, not enough coffee water!");
            direction(machine, scanner);
//        } else if (milkNeeded > machine.coffeeMachineHasMilk) {
//            System.out.println("Sorry, not enough coffee milk!");
//            direction(machine, scanner);
//        } else if (coffeeBeansNeeded > machine.coffeeMachineHasCoffeeBeans) {
//            System.out.println("Sorry, not enough coffee coffee beans!");
//            direction(machine, scanner);
        } else {

            machine.coffeeMachineHasWater -= waterNeeded;
            machine.coffeeMachineHasMilk -= milkNeeded;
            machine.coffeeMachineHasCoffeeBeans -= coffeeBeansNeeded;
            machine.coffeeMachineHasMoney += price;
            machine.coffeeMachineHasDisposableCups--;

            System.out.println("I have enough resources, making you a coffee!");

            direction(machine, scanner);
        }
    }

    public static void fill(Machine machine, Scanner scanner) {

        System.out.println("Write how many ml of water you want to add: ");
        machine.coffeeMachineHasWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        machine.coffeeMachineHasMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        machine.coffeeMachineHasCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        machine.coffeeMachineHasDisposableCups += scanner.nextInt();

        direction(machine, scanner);

    }

    // Take all of the money from the machine
    public static void take(Machine machine, Scanner scanner) {

        System.out.println("I gave you $" + machine.coffeeMachineHasMoney);
        machine.coffeeMachineHasMoney -= machine.coffeeMachineHasMoney;
        direction(machine, scanner);
    }

    public static void showBalance(Machine machine) {

        System.out.println("The coffee machine has:");
        System.out.println(machine.coffeeMachineHasWater + " ml of water");
        System.out.println(machine.coffeeMachineHasMilk + " ml of milk");
        System.out.println(machine.coffeeMachineHasCoffeeBeans + " g of coffee beans");
        System.out.println(machine.coffeeMachineHasDisposableCups + " disposable cups");
        System.out.println("$" + machine.coffeeMachineHasMoney + " of money");

    }
}
