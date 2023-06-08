package com.example.aiot.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.aiot.exception.BusinessException;
import com.example.aiot.service.DeviceInfoService;
import com.example.aiot.service.IotPlatformService;
import com.sophgo.ai.lib.common.util.ReqUtil;

/**
 * @author zichen.dang@sophgo.com
 */
@Service
public class IotPlatformServiceImpl implements IotPlatformService {

    private static final String DEVICE_SN = "KDsbZCBssAVJfDVQg0Lx";

    @Resource
    private DeviceInfoService deviceInfoService;

    @Resource
    private IotPlatformInvoker iotPlatformInvoker;

    @Override
    public Object pushDeviceInfoToPlatform() {
        return null;
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    private void DeviceInfoPushScheduler() {
        iotPlatformInvoker.telemetryPublisher(DEVICE_SN, deviceInfoService.deviceDataTransporter());
    }

    @Component
    public static class IotPlatformInvoker {

        @Resource(name = "remoteRestTemplate")
        private RestTemplate restTemplate;

        public void telemetryPublisher(String deviceSn, Map<String, Object> telemetryMap) {
            String url = String.format("https://thingsboard.cloud/api/v1/%s/telemetry", deviceSn);
            ResponseEntity<Object> responseEntity = ReqUtil.restExchangeForEntity(restTemplate, url, HttpMethod.POST, new HttpEntity<>(telemetryMap), new ParameterizedTypeReference<Object>() {
            });
            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                throw new BusinessException("上传数据出错");
            }
        }

    }

}
