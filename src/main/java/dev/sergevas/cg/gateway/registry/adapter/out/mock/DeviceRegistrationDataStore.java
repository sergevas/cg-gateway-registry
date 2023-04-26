package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DeviceRegistrationDataStore {

    private Map<String, DeviceRegistration> deviceRegistrationStore;

    @PostConstruct
    void init() {
        deviceRegistrationStore = new ConcurrentHashMap<>();

        deviceRegistrationStore.put("0001", new DeviceRegistration(
                "0001",
                "switch",
                "http://192.168.1.84/cg/actuator/switch/0001",
                10000,
                OffsetDateTime.now(ZoneOffset.UTC),
                null,
                List.of("ESP8266", "SRD-05VDC-SL-C")));
        deviceRegistrationStore.put("growlab-IR-CUT_Cam", new DeviceRegistration(
                "growlab-IR-CUT_Cam",
                "camera",
                "http://192.168.1.72:8088/growlab/api/v1/actuators/camera",
                10000,
                OffsetDateTime.now(ZoneOffset.UTC).minusMonths(2L),
                OffsetDateTime.now(ZoneOffset.UTC).minusMonths(1L),
                List.of("#growlab", "Raspberry Pi Zero W", "camera", "IR-CUT Cam")));
        deviceRegistrationStore.put("growlab-BH1750", new DeviceRegistration(
                "growlab-BH1750",
                "sensor-light",
                "http://192.168.1.72:8088/growlab/api/v1/sensors/light",
                10000,
                OffsetDateTime.now(ZoneOffset.UTC).minusYears(1L),
                null,
                List.of("#growlab", "Raspberry Pi Zero W", "light", "BH1750")));
        deviceRegistrationStore.put("growlab-BME280", new DeviceRegistration(
                "growlab-BME280",
                "sensor-thp",
                "http://192.168.1.72:8088/growlab/api/v1/sensors/thp",
                10000,
                OffsetDateTime.now(ZoneOffset.UTC).minusDays(20L),
                OffsetDateTime.now(ZoneOffset.UTC).minusDays(8L),
                List.of("#growlab", "Raspberry Pi Zero W", "thp", "BME280")));
    }

    public Map<String, DeviceRegistration> getDeviceRegistrationStore() {
        return deviceRegistrationStore;
    }
}
