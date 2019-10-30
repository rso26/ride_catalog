package com.github.rso26.ride_catalogue.models.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class UuidAttributeConverter implements AttributeConverter<UUID, String> {
    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return (uuid == null ? null : uuid.toString());
    }

    @Override
    public UUID convertToEntityAttribute(String uuidAsString) {
        return (uuidAsString == null ? null : UUID.fromString(uuidAsString));
    }
}
