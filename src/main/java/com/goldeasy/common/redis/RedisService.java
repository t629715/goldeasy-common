package com.goldeasy.common.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
* 
* @ClassName: RedisService 
* @Description: redis缓存接口。 
*  缓存时间单位默认分钟，
*  默认timeout值为5，
*  没有timeout和timeunit的方法默认不设置有效时间，永久有效。
* @author jcwang
* @date 2017年7月31日 下午3:54:17 
*
*/
public interface RedisService {

	int EXPIRE_TIME_1 = 1;

	int EXPIRE_TIME_2 = 2;

	int EXPIRE_TIME_5 = 5;

	int EXPIRE_TIME_7 = 7;

	int EXPIRE_TIME_15 = 15;
	
	int EXPIRE_TIME_30 = 30;

	<T> T get(String key, Class<T> cls);

	/** 
     * 验证是否存在 
     * @param key 键名
     * @return 
     */  
	boolean exists(String key);
	
	/** 
     * 删除
     * @param key 键名
     * @return 
     */  
	void delete(String key);
	
	/** 
     * 过期设置
     * @param key 键名
     * @param timeout 有效时间
     * @return 
     */  
	boolean expire(String key, long timeout, TimeUnit timeUnit);
	
	/** 
     * 过期设置
     * @param key 键名
     * @param timeout 有效时间
     * @return 
     */  
	boolean expire(String key, long timeout);
	
	/** 
     * 存入
     * @param key 键名
     * @param value 值
     * @return 
     */  
	void put(String key, String value);
	
	/** 
     * 存入并指定有效期 
     * @param key 键名
     * @param value 值
     * @param timeout 有效时间
     * @return 
     */  
	void put(String key, String value, int timeout);
	
	/** 
     * 存入并指定有效期 
     * @param key 键名
     * @param value 值
     * @param timeout 有效时间
     * @return 
     */  
	void put(String key, String value, int timeout, TimeUnit unit);
	
	/** 
     * 根据键获得值 
     * @param key 键名
     * @return 
     */  
	String get(String key);
	
	
	/** ============== list ==================== */
	
	 /** 
     * 压栈 
     * @param key 键名
     * @param value 值
     * @return 
     */
     Long push(String key, String value);
    
    /** 
     * 出栈 
     * @param key 键名
     * @return 
     */  
     String pop(String key);
  
    /** 
     * 入队 
     * @param key 键名
     * @param value 值
     * @return 
     */  
     Long in(String key, String value);
  
    /** 
     * 出队 
     * @param key 键名
     * @return 
     */  
     String out(String key);
  
    /** 
     * 栈/队列长 
     * @param key 键名
     * @return 
     */  
     Long length(String key);
  
    /** 
     * 范围检索 
     * @param key 键名
     * @param start 起始点
     * @param end   结束点
     * @return 
     */  
     List<String> range(String key, int start, int end);
    
    /** 
     * 移除 
     * @param key 键名
     * @param i   
     * @param value 值
     */  
    void remove(String key, long i, String value);
  
    /** 
     * 检索 
     *@param key 键名
     * @param index 
     * @return 
     */  
    String index(String key, long index);
  
    /** 
     * 置值 
     * @param key 键名
     * @param value 值
     * @param index 
     */  
    void set(String key, long index, String value);
  
    /** 
     * 裁剪 
     * @param key 键名
     * @param start 起始点
     * @param end   结束点
     */  
    void trim(String key, long start, int end);
    
    /** ============== set ==================== */
    /** 
     * 添加单个元素
     * @param key 键名
     * @param value 值
     * @return 
     */  
     void add(String key, String value);
    
	 /** 
     * 添加数组元素
     * @param key 键名
     * @param value 数组值
     * @return 
     */
     void add(String key, String... value);
  
    /** 
     * 移除单个元素
     * @param key 键名
     * @param value 值
     * @return 
     */  
     void remove(String key, String value);
    
	 /** 
     * 移除数组元素
     * @param key 键名
     * @param value 数组值
     * @return 
     */
     void remove(String key, Object... value);
    
    /** ============== map ================*/
    /** 
     * 获取所有map
     * @param key 键名
     * @return 
     */  
     Map getMapByKey(String key);
    /** 
     * 向map中添加元素
     * @param key 键名
     * @param value 数组值
     * @return 
     */  
     void mapAdd(String key, Map<String, Object> value);
    
    /** 
     * 向key对应的map中添加缓存对象 
     * @param key   cache对象key 
     * @param field map对应的key 
     * @param obj   对象 
     */  
     void mapUpdate(String key, String field, Object obj);
    
    /** 
     * 删除map中的某个对象 
     * @param key   map对应的key 
     * @param field map中该对象的key 
     */  
     void mapDelField(String key, String... field);
    
    /** 
     * 获取map缓存中的某个对象 
     * @param key   cache对象key 
     * @param field map对应的key 
     * @param clazz
     * @return 
     */  
     <T> T getMapField(String key, String field, Class<T> clazz);

    Set<String> keys(String key);
    
}
