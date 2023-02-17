package pl.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.devices.Device;
import pl.devices.DeviceReposiotry;

public class ShelfConverter implements Converter<String, Shelf> {


    @Autowired
    private ShelfReposiotry shelfReposiotry;

    @Override
    public Shelf convert(String s) {
        return shelfReposiotry.findById(Long.parseLong(s)).get();
    }
}
