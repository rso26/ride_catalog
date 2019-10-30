package com.github.rso26.ride_catalog.lib.dtos;

import java.util.List;
import java.util.UUID;

public class RideOffer {
    private Long id;
    private String state;
    private String vehicleType;
    private Integer passengersLimit;
    private Double price;
    private String description;
    private UUID routePlanUuid;
    private Long estDepartureTime;
    private Long estArrivalTime;
    private UUID driverUuid;
    private List<UUID> passengerUuids;

    public RideOffer() {
    }

    public RideOffer(Long id, String state, String vehicleType, Integer passengersLimit, Double price, String description, UUID routePlanUuid, Long estDepartureTime, Long estArrivalTime, UUID driverUuid, List<UUID> passengerUuids) {
        this.id = id;
        this.state = state;
        this.vehicleType = vehicleType;
        this.passengersLimit = passengersLimit;
        this.price = price;
        this.description = description;
        this.routePlanUuid = routePlanUuid;
        this.estDepartureTime = estDepartureTime;
        this.estArrivalTime = estArrivalTime;
        this.driverUuid = driverUuid;
        this.passengerUuids = passengerUuids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getPassengersLimit() {
        return passengersLimit;
    }

    public void setPassengersLimit(Integer passengersLimit) {
        this.passengersLimit = passengersLimit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getRoutePlanUuid() {
        return routePlanUuid;
    }

    public void setRoutePlanUuid(UUID routePlanUuid) {
        this.routePlanUuid = routePlanUuid;
    }

    public Long getEstDepartureTime() {
        return estDepartureTime;
    }

    public void setEstDepartureTime(Long estDepartureTime) {
        this.estDepartureTime = estDepartureTime;
    }

    public Long getEstArrivalTime() {
        return estArrivalTime;
    }

    public void setEstArrivalTime(Long estArrivalTime) {
        this.estArrivalTime = estArrivalTime;
    }

    public UUID getDriverUuid() {
        return driverUuid;
    }

    public void setDriverUuid(UUID driverUuid) {
        this.driverUuid = driverUuid;
    }

    public List<UUID> getPassengerUuids() {
        return passengerUuids;
    }

    public void setPassengerUuids(List<UUID> passengerUuids) {
        this.passengerUuids = passengerUuids;
    }
}
