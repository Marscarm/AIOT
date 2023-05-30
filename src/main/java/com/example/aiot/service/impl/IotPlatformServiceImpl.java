package com.example.aiot.service.impl;

import com.example.aiot.service.IotPlatformService;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author zichen.dang@sophgo.com
 */
public class IotPlatformServiceImpl implements IotPlatformService {

    @Override
    public Object pushDeviceInfoToPlatform() {
        return null;
    }

    @Scheduled(fixedDelay = 60000)
    private void DeviceInfoPushScheduler() {

    }

}
