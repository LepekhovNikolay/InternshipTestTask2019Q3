package com.space.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;//id корабля

    private String name;//название корбаля до 50 символов

    private String planet;//планета пребывания до 50 символов

    private String shipType;//тип корабля

    private Date prodDate;//дата выпуска 2800-3019 года

    private Boolean isUsed;//использованный или новый

    private Double speed;//максимальная скорость 0,01 - 99 вкл.

    private Integer crewSize;//количество членов 1-9999

    private Double rating;//рейтинг корабля, округление до сотых

    public Ship(String name, String planet, String shipType, Date prodDate,
                Boolean isUsed, Double speed, Integer crewSize, Double rating) {
        this.name = name;
        this.planet = planet;
        this.shipType = shipType;
        this.prodDate = prodDate;
        this.isUsed = isUsed;
        this.speed = speed;
        this.crewSize = crewSize;
        this.rating = rating;
    }

    public Ship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    /*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 30)
            this.name = name.substring(0, 30);
        else
            this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        if (planet.length()> 30)
            this.planet = planet.substring(0, 30);
        else
            this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Long getProdDate() {
        return prodDate;
    }

    public void setProdDate(Long prodDate) {
        if (new Date(prodDate).getTime() < new Date(01,00,2800).getTime())
            this.prodDate = new Date(01, 00, 2800).getTime();
        else if (new Date(prodDate).getTime() > new Date(01, 00, 3019).getTime())
            this.prodDate = new Date(01, 00, 3019).getTime();
        else
            this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = new BigDecimal(speed).setScale(2, RoundingMode.UP).doubleValue();
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        if (crewSize < 1)
            this.crewSize = 1;
        else if (crewSize > 9999)
            this.crewSize = 9999;
        else
            this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }


    public void setRating() {
        double koef = isUsed ? 0.5 : 1;
        double result = 80*speed*koef/(new Date(1,0,3019).getTime() - prodDate + 1);
        rating = new BigDecimal(koef).setScale(3, RoundingMode.UP).doubleValue();
    }

    @Override
    public String toString() {
        String format = "{\"id\":%d,%n" +
                "\"name\":%s,%n" +
                "\"planet\":%s,%n" +
                "\"shipType\":%s,%n" +
                "\"proddate\":%s,%n" +
                "\"isUsed\":%s,%n" +
                "\"speed\":%s,%n" +
                "\"crewSize\":%s,%n" +
                "\"rating\":%s}";
        return String.format(format,id, name, planet, shipType, prodDate, isUsed, speed, crewSize, rating);
    }*/
}
