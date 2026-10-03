/**
 * @description 印章生成策略类
 */
package com.kaifangqian.modules.opensign.seal;

/**
 * @author : zhenghuihan
 * create at:  2024/1/9  15:12
 * @description:
 */
public class StrategySeal {
    private BaseSeal baseSeal;

    public StrategySeal(BaseSeal baseSeal) {
        this.baseSeal = baseSeal;
    }

    public String run(SealDTO sealDTO) throws Exception {
        return baseSeal.createSeal(sealDTO);
    }
}