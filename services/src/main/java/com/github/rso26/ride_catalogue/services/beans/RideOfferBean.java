package com.github.rso26.ride_catalogue.services.beans;

import com.github.rso26.ride_catalog.lib.dtos.RideOffer;
import com.github.rso26.ride_catalogue.models.converters.RideOfferConverter;
import com.github.rso26.ride_catalogue.models.entities.RideOfferEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class RideOfferBean {

    private Logger log = Logger.getLogger(RideOfferBean.class.getName());

    @Inject
    private EntityManager em;

    @PostConstruct
    private void init() {
        log.info("init called!");
    }

    public List<RideOffer> getRideOffers() {
        TypedQuery<RideOfferEntity> query = em.createNamedQuery("RideOfferEntity.getAll",
                RideOfferEntity.class);

        return query.getResultList().stream().map(RideOfferConverter::toDto).collect(Collectors.toList());
    }

    public RideOffer createRideOffer(RideOffer rideOffer) {
        RideOfferEntity rideOfferEntity = RideOfferConverter.toEntity(rideOffer);
        try {
            beginTx();
            em.persist(rideOfferEntity);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        if (rideOfferEntity.getId() == null) {
            throw new RuntimeException("Entity was not persisted");
        }

        // TODO: 29/10/2019 check for potential subscribers who want to be notified about this offer (i.e. that are near the route path)

        return RideOfferConverter.toDto(rideOfferEntity);
    }



    private void beginTx() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    private void commitTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().commit();
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();
    }


}
