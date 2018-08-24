package xin.rtime.repea.key;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 *  Chapter24 分布式防重  唯一Key
 * 
 */
public interface CacheKeyGenerator {

    /**
     * 获取AOP参数,生成指定缓存Key
     *
     * @param pjp PJP
     * @return 缓存KEY
     */
    String getLockKey(ProceedingJoinPoint pjp);
}