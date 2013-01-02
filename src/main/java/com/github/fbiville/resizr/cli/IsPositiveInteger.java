package com.github.fbiville.resizr.cli;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import static java.lang.String.format;

public class IsPositiveInteger implements IValueValidator<Integer> {
    @Override
    public void validate(String name, Integer value) throws ParameterException {
        if (value <= 0) {
            throw new ParameterException(format("Specified width (%s px) is invalid.", value));
        }
    }
}
