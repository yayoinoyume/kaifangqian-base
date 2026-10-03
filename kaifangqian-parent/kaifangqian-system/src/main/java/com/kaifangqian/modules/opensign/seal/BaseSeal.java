/**
 * @description 印章生成抽象类
 */
package com.kaifangqian.modules.opensign.seal;

public abstract class BaseSeal implements Seal {

    public abstract String createSeal(SealDTO sealDTO) throws Exception;
}
