package com.space.controller;

import com.space.model.Ship;
import com.space.model.ShipType;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping()
@RequestMapping("rest/ships")
public class Controller {

    @Autowired
    private ShipService service;

    @GetMapping()
    //при попытке передать 2995 из вэба передается сентябрь 2995
    public List<Ship> getAllShips(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "planet", required = false) String planet,
                                  @RequestParam(value = "shipType", required = false) ShipType shipType,
                                  @RequestParam(value = "after", required = false) Long after,
                                  @RequestParam(value = "before", required = false) Long before,
                                  @RequestParam(value = "isUsed", required = false) Boolean isUsed,
                                  @RequestParam(value = "minSpeed", required = false) Double minSpeed,
                                  @RequestParam(value = "maxSpeed", required = false) Double maxSpeed,
                                  @RequestParam(value = "minCrewSize", required = false) Integer minCrewSize,
                                  @RequestParam(value = "maxCrewSize", required = false) Integer maxCrewSize,
                                  @RequestParam(value = "minRating", required = false) Double minRating,
                                  @RequestParam(value = "maxRating", required = false) Double maxRating,
                                  @RequestParam(value = "order", required = false) ShipOrder order,
                                  @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        List<Ship> listOfAllShipsUnsorted = service.getShips(name, planet, shipType, after, before, isUsed, minSpeed, maxSpeed,
                minCrewSize, maxCrewSize, minRating, maxRating);
        return service.pagingShips(listOfAllShipsUnsorted, pageNumber, pageSize, order);
    }

    @GetMapping("/count")
    public Integer getCountOfShips(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "planet", required = false) String planet,
                                   @RequestParam(value = "shipType", required = false) ShipType shipType,
                                   @RequestParam(value = "after", required = false) Long after,
                                   @RequestParam(value = "before", required = false) Long before,
                                   @RequestParam(value = "isUsed", required = false) Boolean isUsed,
                                   @RequestParam(value = "minSpeed", required = false) Double minSpeed,
                                   @RequestParam(value = "maxSpeed", required = false) Double maxSpeed,
                                   @RequestParam(value = "minCrewSize", required = false) Integer minCrewSize,
                                   @RequestParam(value = "maxCrewSize", required = false) Integer maxCrewSize,
                                   @RequestParam(value = "minRating", required = false) Double minRating,
                                   @RequestParam(value = "maxRating", required = false) Double maxRating) {

        return service.getShips(name, planet, shipType, after, before, isUsed, minSpeed, maxSpeed,
                minCrewSize, maxCrewSize, minRating, maxRating).size();
    }

    @GetMapping("/{id}")
    public Ship getShipById(@PathVariable String id) {

        return service.getShipById(id);
    }

    @PostMapping()
    public Ship createShip(@RequestBody Ship ship) {
        return service.createShip(ship);
    }

    @PostMapping("/{id}")
    public Ship updateShip(@PathVariable String id, @RequestBody Ship ship) {
        return service.updateShip(id, ship);
    }

    @DeleteMapping("/{id}")
    public void deleteShip(@PathVariable String id) {
        service.deleteShip(id);
    }

}