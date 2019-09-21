package com.space.service;

import com.space.controller.ShipOrder;
import com.space.model.Ship;
import com.space.model.ShipType;

import java.util.List;

public interface ShipService {
    List<Ship> getShips(String name, String planet, ShipType shipType,
                        Long after, Long before, Boolean isUsed,
                        Double minSpeed, Double maxSpeed, Integer minCrewSize,
                        Integer maxCrewSize, Double minRating, Double maxRating);

    List<Ship> pagingShips(List<Ship> ships, Integer pageNumber, Integer pageSize, ShipOrder shipOrder);

    Ship createShip(Ship ship);

    Ship getShipById(String id);

    Ship updateShip(String id, Ship ship);

    void deleteShip(String id);
}
