package com.aksm.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwaniK on 9/10/2016.
 */
public class Helpers {

    public final static int ROUND_MODE = BigDecimal.ROUND_HALF_EVEN;
    public final static RoundingMode ROUND_MODE_ENUM = RoundingMode.HALF_EVEN;
    public final static int ROUND_SCALE = 2;
    public final static int ROUND_PERCENTAGE_SCALE = 1;
    public final static int DIVIDE_SCALE = 4;

    private static ObjectMapper objectMapper = null;

    /**
     * Convert Object to json string.
     *
     * @param data Object to convert
     * @param <T>  Type
     * @return JSON String
     */
    public static <T> String toJson(T data) {
        if (data == null) {
            return "";
        }
        ObjectMapper mapper = getObjectMapper();
        //mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Converts object to json byte.
     *
     * @param object Object to convert
     * @return byte array
     * @throws IOException exception.
     */
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = getObjectMapper();
        return mapper.writeValueAsBytes(object);
    }

    /**
     * Creates string with length.
     *
     * @param length length of the string
     * @return string of desired length
     */
    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < length; index++) {
            builder.append("a");
        }

        return builder.toString();
    }

    /**
     * Converts string to list.
     *
     * @param data  json data
     * @param clazz Class of the type
     * @param <T>   Generic type
     * @return List of objects.
     */
    public static <T> List<T> fromJson(String data, Class<T> clazz) {
        if (StringUtils.isEmpty(data)) {
            return new ArrayList<>();
        }
        ObjectMapper mapper = getObjectMapper();
        //mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            return mapper.readValue(data, mapper
                    .getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();

    }

    private static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper = mapper;
        }
        return objectMapper;
    }

    /**
     * Create object from string.
     *
     * @param json  JSON String
     * @param clazz Class
     * @param <T>   Object type
     * @return Object
     */
    public static <T> T fromJsonToObject(String json, Class<T> clazz) {
        ObjectMapper mapper = getObjectMapper();
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;
    }


    /**
     * Create object from string.
     *
     * @param json          JSON String
     * @param typeReference typeReference
     * @param <T>           Object type
     * @return Object
     */
    public static <T> T fromJsonToObject(String json, TypeReference typeReference) {
        ObjectMapper mapper = getObjectMapper();
        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
        }
        return null;
    }


    /**
     * Get date time from epoch.
     *
     * @param epoch time
     * @return time
     */
    public static LocalDateTime getDateTimeFromEpoch(long epoch) {
        return LocalDateTime.ofEpochSecond(epoch, 0, ZoneOffset.UTC);
    }

    public static LocalDate getDateFromEpoch(long epoch) {
        return getDateTimeFromEpoch(epoch).toLocalDate();
    }

    public static Long toEpochSeconds(LocalDateTime localDateTime, ZoneId zoneId) {
        LocalDateTime now = LocalDateTime.now();
        return localDateTime.atZone(zoneId).toEpochSecond();
    }

    public static Long toEpochSeconds(LocalDateTime localDateTime) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        return localDateTime.atZone(zoneId).toEpochSecond();
    }

    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }


    /**
     * Get epoch.
     *
     * @param dateTime date
     * @return long
     */
    public static long getEpochFromDateTime(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }


}
