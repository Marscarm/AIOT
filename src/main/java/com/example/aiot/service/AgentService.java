package com.example.aiot.service;

import com.example.aiot.dao.DeviceInfo;
import org.springframework.lang.Nullable;

/**
 * @author zichen.dang
 */
public interface AgentService {

    /**
     * 调用Agent获取算力设备基本信息
     *
     * @return 算力设备信息
     */
    @Nullable
    DeviceInfo getDeviceInfo();


}
