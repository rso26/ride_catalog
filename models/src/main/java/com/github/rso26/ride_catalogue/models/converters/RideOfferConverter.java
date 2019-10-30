package com.github.rso26.ride_catalogue.models.converters;

import com.github.rso26.ride_catalog.lib.dtos.RideOffer;
import com.github.rso26.ride_catalogue.models.entities.RideOfferEntity;
import com.github.rso26.ride_catalogue.models.enums.State;
import com.github.rso26.ride_catalogue.models.enums.VehicleType;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;

public class RideOfferConverter {
    public static RideOffer toDto(RideOfferEntity entity) {
        if(entity == null)
            return null;

        return new RideOffer(entity.getId(),
                entity.getState().name(),
                entity.getVehicleType().name(),
                entity.getPassengersLimit(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getRoutePlanUuid(),
                entity.getEstDepartureTime().toEpochMilli(),
                entity.getEstArrivalTime().toEpochMilli(),
                entity.getDriverUuid(),
                new ArrayList<>(entity.getPassengerUuids()));
    }

    public static RideOfferEntity toEntity(RideOffer dto) {
        RideOfferEntity entity = new RideOfferEntity();
        entity.setVehicleType(VehicleType.valueOf(dto.getVehicleType()));
        entity.setState(State.valueOf(dto.getState()));
        entity.setPassengersLimit(dto.getPassengersLimit());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setRoutePlanUuid(dto.getRoutePlanUuid());
        entity.setEstDepartureTime(Instant.ofEpochMilli(dto.getEstDepartureTime()));
        entity.setEstArrivalTime(Instant.ofEpochMilli(dto.getEstArrivalTime()));
        entity.setDriverUuid(dto.getDriverUuid());
        if(dto.getPassengerUuids() != null) {
            entity.setPassengerUuids(new HashSet<>(dto.getPassengerUuids()));
        }
        return entity;
    }
}
