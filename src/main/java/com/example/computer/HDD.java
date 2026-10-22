package com.example.computer;

/**
 * Класс, описывающий винчестер (жёсткий диск).
 *
 * @author Student
 * @version 1.0
 */
public class HDD implements Component {

    /** Объём винчестера в гигабайтах. */
    private final int capacity;

    /** Стоимость винчестера. */
    private final double price;

    /** Производитель винчестера. */
    private final String manufacturer;

    /**
     * Конструктор винчестера.
     *
     * @param capacity     объём в ГБ
     * @param price        стоимость
     * @param manufacturer производитель
     */
    public HDD(int capacity, double price, String manufacturer) {
        this.capacity = capacity;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    /**
     * Возвращает объём винчестера.
     *
     * @return объём в ГБ
     */
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getInfo() {
        return String.format("HDD: %d GB, производитель: %s, цена: %.2f",
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