package com.example.computer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий компьютер. Содержит винчестер, дисковод и ОЗУ.
 * Поддерживает включение, выключение, проверку на вирусы,
 * добавление компонентов и подсчёт стоимости.
 *
 * @author Student
 * @version 1.0
 */
public class Computer {

    /** Модель компьютера. */
    private final String model;

    /** Винчестер. */
    private HDD hdd;

    /** Дисковод. */
    private DiskDrive diskDrive;

    /** ОЗУ. */
    private RAM ram;

    /** Список дополнительных компонентов. */
    private final List<Component> extraComponents = new ArrayList<>();

    /** Признак того, что компьютер собран вручную. */
    private final boolean assembledManually;

    /** Состояние питания компьютера. */
    private boolean isOn = false;

    /**
     * Конструктор компьютера.
     *
     * @param model            модель
     * @param hdd              винчестер
     * @param diskDrive        дисковод
     * @param ram              ОЗУ
     * @param assembledManually собран ли вручную
     */
    public Computer(String model, HDD hdd, DiskDrive diskDrive, RAM ram,
                    boolean assembledManually) {
        this.model = model;
        this.hdd = hdd;
        this.diskDrive = diskDrive;
        this.ram = ram;
        this.assembledManually = assembledManually;
    }

    /**
     * Включает компьютер.
     */
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Компьютер " + model + " включён.");
        } else {
            System.out.println("Компьютер " + model + " уже включён.");
        }
    }

    /**
     * Выключает компьютер.
     */
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Компьютер " + model + " выключен.");
        } else {
            System.out.println("Компьютер " + model + " уже выключен.");
        }
    }

    /**
     * Проверяет компьютер на вирусы.
     */
    public void checkViruses() {
        if (isOn) {
            System.out.println("Проверка " + model + " на вирусы... Вирусов не найдено.");
        } else {
            System.out.println("Нельзя проверить " + model + ": компьютер выключен.");
        }
    }

    /**
     * Выводит на консоль размер винчестера.
     */
    public void printHDDSize() {
        System.out.println("Размер винчестера " + model + ": " + hdd.getCapacity() + " GB");
    }

    /**
     * Добавляет дополнительный компонент.
     *
     * @param component компонент
     */
    public void addComponent(Component component) {
        extraComponents.add(component);
        System.out.println("К " + model + " добавлен компонент: " + component.getInfo());
    }

    /**
     * Возвращает общую стоимость компьютера.
     *
     * @return суммарная цена
     */
    public double getTotalPrice() {
        double total = hdd.getPrice() + diskDrive.getPrice() + ram.getPrice();
        for (Component c : extraComponents) {
            total += c.getPrice();
        }
        return total;
    }

    /**
     * Проверяет, собран ли компьютер вручную.
     *
     * @return true, если собран вручную
     */
    public boolean isAssembledManually() {
        return assembledManually;
    }

    /**
     * Возвращает модель компьютера.
     *
     * @return модель
     */
    public String getModel() {
        return model;
    }

    /**
     * Выводит всю информацию о компьютере.
     */
    public void printInfo() {
        System.out.println("=== Компьютер: " + model + " ===");
        System.out.println(hdd.getInfo());
        System.out.println(diskDrive.getInfo());
        System.out.println(ram.getInfo());
        if (!extraComponents.isEmpty()) {
            System.out.println("Дополнительные компоненты:");
            for (Component c : extraComponents) {
                System.out.println("  " + c.getInfo());
            }
        }
        System.out.printf("Общая стоимость: %.2f%n", getTotalPrice());
        System.out.println("Собран вручную: " + (assembledManually ? "да" : "нет"));
        System.out.println("Состояние: " + (isOn ? "включён" : "выключен"));
        System.out.println();
    }

    @Override
    public String toString() {
        return "Computer{" + model + ", price=" + getTotalPrice() + "}";
    }
}