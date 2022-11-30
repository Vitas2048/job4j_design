package ru.job4j.ood.isp;

import java.util.Date;

public interface SmartDevices {
    void showMessages();

    boolean connectBluetoothDevice();

    Date showTime();

    void controlBulbBright();

    void boilWater();
}
