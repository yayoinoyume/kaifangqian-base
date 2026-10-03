/**
 * @description 印章接口类
 */
package com.kaifangqian.modules.opensign.seal;

public interface Seal {

    String createSeal(SealDTO sealDTO) throws Exception;
}
