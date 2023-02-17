package pl.devices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceReposiotry extends JpaRepository<Device, Long> {

}
