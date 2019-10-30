package com.github.rso26.ride_catalogue.models.entities;

import com.github.rso26.ride_catalogue.models.enums.State;
import com.github.rso26.ride_catalogue.models.enums.VehicleType;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ride_offers")
@NamedQueries(value =
        {
                @NamedQuery(name = "RideOfferEntity.getAll",
                        query = "SELECT ro FROM RideOfferEntity ro")
        })
public class RideOfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "vehicleType", nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "passengersLimit", nullable = false)
    private Integer passengersLimit;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "routePlanUuid")
    private UUID routePlanUuid;

    @Column(name = "estDepartureTime", nullable = false)
    private Instant estDepartureTime;

    @Column(name = "estArrivalTime", nullable = false)
    private Instant estArrivalTime;

    @Column(name = "driverUuid", nullable = false)
    private UUID driverUuid;

    @ElementCollection
    @Column(name = "passengerUuids")
    private Set<UUID> passengerUuids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
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

    public Instant getEstDepartureTime() {
        return estDepartureTime;
    }

    public void setEstDepartureTime(Instant estDepartureTime) {
        this.estDepartureTime = estDepartureTime;
    }

    public Instant getEstArrivalTime() {
        return estArrivalTime;
    }

    public void setEstArrivalTime(Instant estArrivalTime) {
        this.estArrivalTime = estArrivalTime;
    }

    public UUID getDriverUuid() {
        return driverUuid;
    }

    public void setDriverUuid(UUID driverUuid) {
        this.driverUuid = driverUuid;
    }

    public Set<UUID> getPassengerUuids() {
        return passengerUuids;
    }

    public void setPassengerUuids(Set<UUID> passengerUuids) {
        this.passengerUuids = passengerUuids;
    }
}
