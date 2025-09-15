package com.sevencows.business.util;

import com.sevencows.business.exception.DataNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OptionalContentExtractor {

    public <T> T getOrThrows(Optional<T> optional, String customErrorMessage) {
        return optional.orElseThrow(() -> new DataNotFoundException(customErrorMessage));
    }

}
