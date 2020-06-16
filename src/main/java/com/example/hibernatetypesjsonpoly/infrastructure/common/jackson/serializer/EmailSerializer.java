package com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer;

import com.example.hibernatetypesjsonpoly.domain.Email;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class EmailSerializer extends StdSerializer<Email> {

    public EmailSerializer() {
        this(null);
    }

    protected EmailSerializer(Class<Email> t) {
        super(t);
    }

    @Override
    public void serialize(Email email,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeString(email.getValue());
    }
}
