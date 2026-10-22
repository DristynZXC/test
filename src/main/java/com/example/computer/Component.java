package com.example.computer;

/**
 * Интерфейс, описывающий компонент компьютера.
 * Все компоненты имеют информацию о себе и стоимость.
 *
 * @author Student
 * @version 1.0
 */
public interface Component {

    /**
     * Возвращает текстовую информацию о компоненте.
     *
     * @return строка с описанием компонента
     */
    String getInfo();

    /**
     * Возвращает стоимость компонента.
     *
     * @return цена в условных единицах
     */
    double getPrice();
}