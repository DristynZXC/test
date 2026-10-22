package com.example.computer;

/**
 * Класс, описывающий дисковод.
 *
 * @author Student
 * @version 1.0
 */
public class DiskDrive implements Component {

    /** Тип дисковода (например, CD-ROM, DVD-RW). */
    private final String type;

    /** Стоимость дисковода. */
    private final double price;

    /** Производитель дисковода. */
    private final String manufacturer;

    /**
     * Конструктор дисковода.
     *
     * @param type         тип дисковода
     * @param price        стоимость
     * @param manufacturer производитель
     */
    public DiskDrive(String type, double price, String manufacturer) {
        this.type = type;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    @Override
    public String getInfo() {
        return String.format("Дисковод: %s, производитель: %s, цена: %.2f",
                type, manufacturer, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}