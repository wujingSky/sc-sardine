package com.hd123.sardine.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;

public class SerializationUtils{
        private static final ObjectMapper MAPPER = new ObjectMapper();
        private SerializationUtils() {
        }

        public static <T> String parse(T obj) {
            try {
                if (obj == null) {
                    return null;
                }
                return MAPPER.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public static <T> String parseInPrettyMode(T obj) {
            try {
                return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public static ObjectMapper getMapper() {
            return MAPPER;
        }
}
