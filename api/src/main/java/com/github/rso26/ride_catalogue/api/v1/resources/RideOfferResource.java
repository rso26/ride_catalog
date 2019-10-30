package com.github.rso26.ride_catalogue.api.v1.resources;

import com.github.rso26.ride_catalog.lib.dtos.RideOffer;
import com.github.rso26.ride_catalogue.models.enums.State;
import com.github.rso26.ride_catalogue.services.beans.RideOfferBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@ApplicationScoped
@Path("/ride_offers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RideOfferResource {

    @Inject
    private RideOfferBean rideOfferBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getRideOffers() {
        return Response.status(Response.Status.OK).entity(rideOfferBean.getRideOffers()).build();
    }

    @POST
    public Response createRideOffer(RideOffer rideOffer) {
        if (rideOffer.getDriverUuid() == null || rideOffer.getEstDepartureTime() == null
                || rideOffer.getEstArrivalTime() == null || rideOffer.getVehicleType() == null
                || rideOffer.getPrice() == null || rideOffer.getPassengersLimit() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            rideOffer.setState(State.INITIATING.name());
            rideOffer = rideOfferBean.createRideOffer(rideOffer);
        }
        return Response.status(Response.Status.CONFLICT).entity(rideOffer).build();
    }
}
