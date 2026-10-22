package com.example.computer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Демонстрационное консольное приложение для работы с компьютерами.
 *
 * @author Student
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<>();

        // Создание 10 компьютеров
        computers.add(new Computer("OfficePC-1",
                new HDD(500, 3000, "Seagate"),
                new DiskDrive("DVD-RW", 1500, "LG"),
                new RAM(8, 2500, "Kingston"), false));

        computers.add(new Computer("GamingPC-1",
                new HDD(2000, 8000, "WD"),
                new DiskDrive("Blu-ray", 4000, "Sony"),
                new RAM(32, 12000, "Corsair"), false));

        computers.add(new Computer("HomePC-1",
                new HDD(1000, 4500, "Toshiba"),
                new DiskDrive("CD-ROM", 800, "Asus"),
                new RAM(16, 5000, "Samsung"), true));

        computers.add(new Computer("WorkPC-1",
                new HDD(500, 2800, "Seagate"),
                new DiskDrive("DVD-ROM", 1200, "LG"),
                new RAM(8, 2400, "Kingston"), false));

        computers.add(new Computer("CustomPC-1",
                new HDD(4000, 15000, "Samsung"),
                new DiskDrive("Blu-ray", 4500, "Pioneer"),
                new RAM(64, 25000, "G.Skill"), true));

        computers.add(new Computer("BudgetPC-1",
                new HDD(250, 1800, "WD"),
                new DiskDrive("CD-ROM", 600, "Asus"),
                new RAM(4, 1200, "Kingston"), false));

        computers.add(new Computer("CustomPC-2",
                new HDD(1000, 5000, "Seagate"),
                new DiskDrive("DVD-RW", 1600, "LG"),
                new RAM(16, 5500, "Corsair"), true));

        computers.add(new Computer("ServerPC-1",
                new HDD(8000, 30000, "WD"),
                new DiskDrive("DVD-RW", 1500, "LG"),
                new RAM(128, 50000, "Samsung"), false));

        computers.add(new Computer("StudyPC-1",
                new HDD(500, 3000, "Toshiba"),
                new DiskDrive("DVD-ROM", 1100, "Asus"),
                new RAM(8, 2600, "Kingston"), true));

        computers.add(new Computer("MediaPC-1",
                new HDD(2000, 7500, "WD"),
                new DiskDrive("Blu-ray", 4200, "Sony"),
                new RAM(32, 11000, "Corsair"), false));

        // Демонстрация методов
        System.out.println("===== Демонстрация работы =====");
        Computer demo = computers.get(0);
        demo.turnOn();
        demo.checkViruses();
        demo.printHDDSize();
        demo.turnOff();
        System.out.println();

        // Докупаем компоненты
        System.out.println("===== Докупка компонентов =====");
        computers.get(1).addComponent(new RAM(16, 6000, "Corsair"));
        computers.get(4).addComponent(new HDD(2000, 7000, "Seagate"));
        System.out.println();

        // Вся информация о компьютерах
        System.out.println("===== Информация о компьютерах =====");
        for (Computer c : computers) {
            c.printInfo();
        }

        // Компьютеры, собранные вручную
        System.out.println("===== Компьютеры, собранные вручную =====");
        for (Computer c : computers) {
            if (c.isAssembledManually()) {
                System.out.println(c.getModel() + " — " + c.getTotalPrice());
            }
        }
        System.out.println();

        // Самый выгодный компьютер (минимальная цена)
        Computer cheapest = computers.stream()
                .min(Comparator.comparingDouble(Computer::getTotalPrice))
                .orElse(null);
        if (cheapest != null) {
            System.out.println("===== Самый выгодный компьютер =====");
            System.out.println(cheapest.getModel() + " — " + cheapest.getTotalPrice());
        }
    }
}