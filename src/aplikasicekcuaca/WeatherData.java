/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasicekcuaca;

/**
 *
 * @author ACER A314
 */
public class WeatherData {
    private final double temperature;
    private final String description;
    private final int humidity;
    private final double windSpeed;
    private final String iconImage;

    public WeatherData(double temperature, String description, int humidity, double windSpeed, String iconImage) {
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.iconImage = iconImage;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getIconImage() {
        return iconImage;
    }    
}
