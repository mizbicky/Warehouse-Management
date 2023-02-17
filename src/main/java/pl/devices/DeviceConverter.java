package pl.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class DeviceConverter implements Converter<String, Device> {


    @Autowired
    private DeviceReposiotry deviceReposiotry;

    @Override
    public Device convert(String s) {
        return deviceReposiotry.findById(Long.parseLong(s)).get();
    }
}

