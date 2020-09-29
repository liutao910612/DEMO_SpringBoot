package com.liutao.cache.manager;

import java.util.function.Function;

/**
 * @author alvinl
 * @date 09/29/20 16:33
 **/
public interface CacheProviderService {

    /** 
     * <p> 
     * Get cache
     * </p>
     * @author Alvinl
     * @date 09/29/20 16:40
     * @param key
     * @return T
     */
    <T extends Object> T get(String key);

    /** 
     * <p> 
     * Get cache
     * </p>
     * @author Alvinl
     * @date 09/29/20 16:41
     * @param key
     * @param function If cache is null , the function can be used to return object
     * @return T
     */
    <T extends Object> T get(String key, Function<String, T> function);

    /**
     * <p>
     * Get cache
     * </p>
     * @author Alvinl
     * @date 09/29/20 16:41
     * @param key
     * @param function If cache is null , the function can be used to return object
     * @param funcParm  the param of function
     * @return T
     */
    <T extends Object, M extends Object> T get(String key, Function<M, T> function, M funcParm);

    /**
     * <p>
     * Get cache
     * </p>
     * @author Alvinl
     * @date 09/29/20 16:55
     * @param key
     * @param function If cache is null , the function can be used to return object
     * @param expireTime
     * @return T
     */
    <T extends Object> T get(String key, Function<String, T> function, Long expireTime);

    /**
     * <p>
     * Get cache
     * </p>
     * @author Alvinl
     * @date 09/29/20 16:55
     * @param key
     * @param function If cache is null , the function can be used to return object
     * @param funcParm  the param of function
     * @param expireTime
     * @return T
     */
    <T extends Object, M extends Object> T get(String key, Function<M, T> function, M funcParm, Long expireTime);

    /**
     * <p>
     * Save cache value
     * </p>
     *
     * @param key can't be null
     * @param obj can't be null
     * @return void
     * @author Alvinl
     * @date 09/29/20 16:37
     */
    <T extends Object> void set(String key, T obj);

    /**
     * <p>
     * Save cache value
     * </p>
     *
     * @param key        can't be null
     * @param obj        can't be null
     * @param expireTime In milliseconds, can be null
     * @return void
     * @author Alvinl
     * @date 09/29/20 16:37
     */
    <T extends Object> void set(String key, T obj, Long expireTime);

    /**
     * <p>
     * Remove cache
     * </p>
     *
     * @param
     * @return void
     * @author Alvinl
     * @date 09/29/20 16:39
     */
    void remove(String key);

    /**
     * <p>
     * If the cache exists
     * </p>
     *
     * @param key
     * @return boolean
     * @author Alvinl
     * @date 09/29/20 16:40
     */
    boolean contains(String key);
}
