package com.goldeasy.common.redis;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 
* @ClassName: RedisServiceImpl 
* @Description: redis string操作实现类
* @author jcwang
* @date 2017年7月31日 下午3:55:10 
*
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Resource
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	public <T> T get(String key, Class<T> cls) {
		Object obj = redisTemplate.opsForValue().get(key);
		if(null==obj) return null;
		String jsonstr = String.valueOf(obj);
		return JSON.parseObject(jsonstr, cls);
	}
	
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}

	public boolean expire(String key, long timeout, TimeUnit timeUnit) {
		return redisTemplate.expire(key, timeout, timeUnit);
	}
	
	public boolean expire(String key, long timeout) {
		return expire(key, timeout, TimeUnit.MINUTES);
	}
	
	public void put(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void put(String key, String value, int timeout) {
		put(key, value, timeout, TimeUnit.MINUTES);
	}

	public void put(String key, String value, int timeout, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value, timeout, unit);
	}

	public String get(String key) {
		Object obj = redisTemplate.opsForValue().get(key);
		if(null==obj) return null;
		return String.valueOf(obj);
	}
	
	/**=====================list =======*/
	/**
	 * 压栈
	 */
	public Long push(String key, String value) {
		return redisTemplate.opsForList().leftPush(key, value);
	}

	/**
	 * 出栈
	 */
	public String pop(String key) {
		ListOperations obj = redisTemplate.opsForList();
		if(null==obj) return null;
		return String.valueOf(obj.leftPop(key));
	}

	/**
	 * 入队
	 */
	public Long in(String key, String value) {
		return redisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * 出队
	 */
	public String out(String key) {
		ListOperations obj = redisTemplate.opsForList();
		if(null==obj) return null;
		return String.valueOf(obj.rightPop(key));
	}

	/**
	 * 栈/队列长
	 */
	public Long length(String key) {
		return redisTemplate.opsForList().size(key);
	}

	/**
	 * 范围检索
	 */
	public List<String> range(String key, int start, int end) {
		return redisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * 移除
	 */
	public void remove(String key, long i, String value) {
		redisTemplate.opsForList().remove(key, i, value);
	}

	/**
	 * 检索
	 */
	public String index(String key, long index) {
		ListOperations obj = redisTemplate.opsForList();
		if(null==obj) return null;
		return String.valueOf(obj.index(key, index));
	}

	/**
	 * 置值
	 */
	public void set(String key, long index, String value) {
		redisTemplate.opsForList().set(key, index, value);
	}

	/**
	 * 裁剪
	 */
	public void trim(String key, long start, int end) {
		redisTemplate.opsForList().trim(key, start, end);
	}
	
	/** ============== set ================*/
	/** 
     * 添加单个元素
     * @param key 键名
     * @param value 值
     * @return 
     */  
    public void add(String key, String value){
    	 redisTemplate.opsForSet().add(key, value);
    }
    
	 /** 
     * 添加数组元素
     * @param key 键名
     * @param value 数组值
     * @return 
     */  
    public void add(String key, String... value){
    	 redisTemplate.opsForSet().add(key, value);
    }
  
    /** 
     * 移除单个元素
     * @param key 键名
     * @param value 值
     * @return 
     */  
    public void remove(String key, String value){
    	 redisTemplate.opsForSet().remove(key, value);
    }
    
	 /** 
     * 移除数组元素
     * @param key 键名
     * @param value 数组值
     * @return 
     */  
    public void remove(String key, Object... value){
    	 redisTemplate.opsForSet().remove(key, value);
    }
    
    /** ============== map ================*/
    /** 
     * 获取所有map
     * @param key 键名
     * @return 
     */  
    public Map getMapByKey(String key){
    	 return redisTemplate.opsForHash().entries(key);
    }
    
    /** 
     * 向map中添加元素
     * @param key 键名
     * @param value 数组值
     * @return 
     */  
    public void mapAdd(String key, Map<String,Object> value){
    	 redisTemplate.opsForHash().putAll(key, value);
    }
    
    /** 
     * 向key对应的map中添加缓存对象 
     * @param key   cache对象key 
     * @param field map对应的key 
     * @param obj   对象 
     */  
    public void mapUpdate(String key, String field, Object obj){  
    	redisTemplate.opsForHash().put(key, field, obj);
    }
    
    /** 
     * 删除map中的某个对象 
     * @param key   map对应的key 
     * @param field map中该对象的key 
     */  
    public void mapDelField(String key, String... field){  
        redisTemplate.boundHashOps(key).delete(field);
    }  
    
    /** 
     * 获取map缓存中的某个对象 
     * @param key   cache对象key 
     * @param field map对应的key 
     * @param clazz
     * @return 
     */  
    public <T> T getMapField(String key, String field, Class<T> clazz){  
        return (T) redisTemplate.boundHashOps(key).get(field);  
    }

	public Set<String> keys(String key) {
		return redisTemplate.keys(key);
	}
}
