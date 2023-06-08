package com.example.aiot.vo.reqVo.agent;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author zichen.dang@sophgo.com
 */
@Data
public class DeviceComputeInfo {
    /**
     * key=chipSn,value=slot
     */
    private Map<String, String> slotsMap;
    /**
     * 设备sn
     */
    private String deviceSn;
    /**
     * 收集时间 yyyy-MM-dd hh:mm:ss
     */
    private String collectDateTime;
    /**
     * 中央处理器
     */
    private CentralProcessingUnit centralProcessingUnit;

    /**
     * 核心计算单元
     */
    private CoreComputingUnit coreComputingUnit;


    @Data
    public static class CoreComputingUnit {
        /**
         * 板卡列表
         */
        private List<AgentComputeBoard> board;
    }


    /**
     * 板卡
     */
    @Data
    public static class AgentComputeBoard {
        /**
         * 板卡编号
         */
        private String boardSn;
        /**
         * 板卡类型
         */
        private String boardType;
        /**
         * 板卡最大 单位 W
         */
        private Integer maxBoardPower;
        /**
         * 当前功率 单位 W
         */
        private Integer currentBoardPower;
        /**
         * 风扇转速
         */
        private Integer fanspeedPercent;
        /**
         * 板卡温度
         */
        private Integer temperature;
        /**
         * 所属芯片列表
         */
        private List<AgentComputeChip> chip;

    }


    @Data
    public static class AgentComputeChip {
        /**
         * 卡槽信息 0000:05:00.0
         */
        private String slot;
        /**
         * 芯片类型
         */
        private Integer chipType;
        /**
         * 芯片的sn编号
         */
        private String chipSn;
        /**
         * 芯片状态，0 active, 1 nonactive，2high-temperature
         */
        private Integer health;
        /**
         * 算力 TFLOPS
         */
        private Double calculationCapacity;
        /**
         * 使用率
         */
        private Integer utililizationRate;
        /**
         * 芯片温度
         */
        private Integer temperature;
        /**
         * 芯片内存
         */
        private AgentMemory memory;
    }


    @Data
    public static class CentralProcessingUnit {
        private AgentCpu cpu;
        private AgentMemory memory;
        private List<AgentDisk> disk;
    }

    @Data
    public static class AgentCpu {
        /**
         * 主频 mhz
         */
        private Double frequency;
        /**
         * 核心数
         */
        private Integer cores;
        /**
         * 使用率
         */
        private Integer utililizationRate;
    }

    @Data
    public static class AgentMemory {
        /**
         * 单位 M
         */
        private Integer total;
        /**
         * 单位 M
         */
        private Integer free;
    }

    @Data
    public static class AgentDisk {
        /**
         * 单位 M
         */
        private Integer total;
        /**
         * 单位 M
         */
        private Integer free;
        /**
         * 磁盘id
         */
        private String diskSn;
        /**
         * io使用率
         */
        private Integer ioRate;
    }


}
