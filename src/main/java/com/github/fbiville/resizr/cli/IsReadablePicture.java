package com.github.fbiville.resizr.cli;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

import static java.lang.String.format;

public class IsReadablePicture implements IValueValidator<String> {
    @Override
    public void validate(String name, String value) throws ParameterException {
        File picture = new File(value);
        if(!(picture.canRead() && picture.isFile() && hasReadableFormat(value))) {
            throw new ParameterException(format("Picture %s is either not a file, is not readable or its format cannot be guessed.", value));
        }
    }

    private boolean hasReadableFormat(String path) {
        int separatorPosition = path.lastIndexOf('.');
        return (0 < separatorPosition && separatorPosition + 1 < path.length());
    }
}
