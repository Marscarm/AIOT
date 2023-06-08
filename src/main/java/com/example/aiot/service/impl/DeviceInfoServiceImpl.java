package com.example.aiot.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.aiot.service.DeviceInfoService;
import com.example.aiot.vo.Result;
import com.example.aiot.vo.reqVo.agent.DeviceComputeInfo;
import com.sophgo.ai.lib.common.util.ReqUtil;

/**
 * @author zichen.dang@sophgo.com
 */
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    private AgentInvoker agentInvoker;

    @Override
    public Map<String, Object> deviceDataTransporter() {
        return AgentAdapter.deviceDataAdapt(agentInvoker.deviceInfoInvoke());
    }

    public static class AgentAdapter {

        public static Map<String, Object> deviceDataAdapt(DeviceComputeInfo deviceComputeInfo) {
            DeviceComputeInfo.CoreComputingUnit coreComputingUnit = deviceComputeInfo.getCoreComputingUnit();
            DeviceComputeInfo.AgentComputeChip chip = coreComputingUnit.getBoard().stream().map(DeviceComputeInfo.AgentComputeBoard::getChip).flatMap(Collection::stream).findAny().orElse(null);
            Map<String, Object> map = new HashMap<>();
            map.put("chipTemperature", chip.getTemperature());
            map.put("chipUseRate", chip.getUtililizationRate());
            return map;
        }


    }

    @Component
    public static class AgentInvoker {

        @Resource(name = "remoteRestTemplate")
        private RestTemplate restTemplate;

        public DeviceComputeInfo deviceInfoInvoke() {
            String url = "http://localhost:10080/device/resource/list?all=0";
            Result<List<DeviceComputeInfo>> deviceComputeInfoResult = ReqUtil.restExchange(restTemplate, url, HttpMethod.GET, null, new ParameterizedTypeReference<Result<List<DeviceComputeInfo>>>() {
            });
            return deviceComputeInfoResult.getResult().get(0);
        }

    }


}
