# Ride catalogue
Prevoznikom omogoča dodajanje novega prevoza in spreminjanje aktivnega (obstoječega) prevoza, potnikom pa iskanje po katalogu aktualnih prevozov in morebitno pridužitev/zapustitev.

## Pred zahteve
Za shranjevanje podatkov se uporablja podatkovna baza Postgres (s ustreznimi parametri, glej [config.yaml](api/src/main/resources/config.yaml)).

```bash
docker run -d --name pg-ride-offers -e POSTGRES_USER=rso26user -e POSTGRES_PASSWORD=postgres.rso26 -e POSTGRES_DB=ride-offers -p 5432:5432 postgres:12
```
## Primeri uporabe

Dodajanje novega prevoza:

POST http://localhost:8083/v1/ride_offers

Telo zahtevka:
```json
{
  "driverUuid": "123e4567-e89b-12d3-a456-44F155440000",
  "estDepartureTime": 1572374078042,
  "estArrivalTime": 1572374736116,
  "vehicleType": "CAR",
  "price": 8,
  "passengersLimit": 3,
  "description": "Ljubljana-Koper"
}
```

GET http://localhost:8083/v1/ride_offers

Odgovor:

```json
[
    {
        "description": "Ljubljana-Kranj",
        "driverUuid": "123e4567-e89b-12d3-a456-44f155440000",
        "estArrivalTime": 1572374736116,
        "estDepartureTime": 1572374078042,
        "id": 1,
        "passengerUuids": [],
        "passengersLimit": 3,
        "price": 8,
        "state": "INITIATING",
        "vehicleType": "CAR"
    },
    {...},
    {...},
    {...},
    {...}
]
```