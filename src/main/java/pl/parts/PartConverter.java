package pl.parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.devices.Device;
import pl.devices.DeviceReposiotry;

public class PartConverter implements Converter<String, Part> {


    @Autowired
    private PartRepository partRepository;

    @Override
    public Part convert(String s) {
        return partRepository.findById(Long.parseLong(s)).get();
    }
}
