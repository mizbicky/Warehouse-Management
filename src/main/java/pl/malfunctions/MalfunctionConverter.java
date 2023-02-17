package pl.malfunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.devices.Device;
import pl.devices.DeviceReposiotry;

public class MalfunctionConverter implements Converter<String, Malfunction> {


    private MalfuncionRepository malfuncionRepository;

    @Override
    public Malfunction convert(String s) {
        return malfuncionRepository.findById(Long.parseLong(s)).get();
    }
}
