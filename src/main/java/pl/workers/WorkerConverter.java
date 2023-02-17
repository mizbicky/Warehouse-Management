package pl.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.devices.Device;
import pl.devices.DeviceReposiotry;

public class WorkerConverter implements Converter<String, Worker> {


    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker convert(String s) {
        return workerRepository.findById(Long.parseLong(s)).get();
    }
}
