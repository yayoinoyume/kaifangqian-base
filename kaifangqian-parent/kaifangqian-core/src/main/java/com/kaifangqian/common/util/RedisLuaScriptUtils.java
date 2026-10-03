/**
 * @description redis工具类
 */
package com.kaifangqian.common.util;

import com.kaifangqian.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhh
 * create at:  2022/9/5
 */

@Slf4j
@Component
public class RedisLuaScriptUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @param key:redis的key值
     * @param limitCount:限制次数
     * @param limitPeriod:限制时间（秒）
     * @return true：可以继续操作 false：超限，不可以继续操作
     * @create by zhenghuihan
     * @createTime 2022/9/5 15:09
     * @description
     */
    public boolean checkRepeatLimit(String key, int limitCount, int limitPeriod) {
        if (checkRepeatVolid(key, limitCount, limitPeriod)) {
            String luaScript = buildLuaScript();
            RedisScript<Long> redisScript = new DefaultRedisScript<>(luaScript, Long.class);
            List<String> limitKeys = new ArrayList<>();
            limitKeys.add(key);

            Long count = redisTemplate.execute(redisScript, limitKeys, limitCount, limitPeriod);
            if (null != count && count.intValue() <= limitCount) {
                return true;
            } else {
                //直接删除key值，通过数据库锁定
                redisTemplate.delete(key);
                return false;
            }
        }
        return false;
    }

    boolean checkRepeatVolid(String key, int limitCount, int limitPeriod) {
        if (MyStringUtils.isBlank(key) || limitCount == 0 || limitPeriod == 0) {
            return false;
        }
        return true;
    }

    /**
     * 脚本
     */
    private String buildLuaScript() {
        return "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
    }
}