package com.example.computer;

/**
 * Класс, описывающий оперативное запоминающее устройство (ОЗУ).
 *
 * @author Student
 * @version 1.0
 */
public class RAM implements Component {

    /** Объём ОЗУ в гигабайтах. */
    private final int capacity;

    /** Стоимость ОЗУ. */
    private final double price;

    /** Производитель ОЗУ. */
    private final String manufacturer;

    /**
     * Конструктор ОЗУ.
     *
     * @param capacity     объём в ГБ
     * @param price        стоимость
     * @param manufacturer производитель
     */
    public RAM(int capacity, double price, String manufacturer) {
        this.capacity = capacity;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    @Override
    public String getInfo() {
        return String.format("ОЗУ: %d GB, производитель: %s, цена: %.2f",
                capacity, manufacturer, price);
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