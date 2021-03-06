package com.manning.javapersistence.ch06.converter;

import com.manning.javapersistence.ch06.model.GermanZipcode;
import com.manning.javapersistence.ch06.model.SwissZipcode;
import com.manning.javapersistence.ch06.model.Zipcode;

import javax.naming.OperationNotSupportedException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ZipcodeConverter implements AttributeConverter<Zipcode, String> {
    @Override
    public String convertToDatabaseColumn(Zipcode zipcode) {
        return zipcode.getValue();
    }

    @Override
    public Zipcode convertToEntityAttribute(String s) {
        if (s.length() == 4) {
            return new GermanZipcode(s);
        } else if (s.length() == 5) {
            return new SwissZipcode(s);
        } else throw new IllegalArgumentException("Unsupported zipcode in database: " + s) ;
    }
}
