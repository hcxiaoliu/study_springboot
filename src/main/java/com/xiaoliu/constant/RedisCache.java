package com.xiaoliu.constant;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;



@Component("RedisCache")
public class RedisCache {
	
	private final Logger logger = LoggerFactory.getLogger(RedisCache.class);
	
	@Autowired
	JedisPool jedisPool;
	
	public String get(String key) {
		String value = null;
		try (Jedis jedis = jedisPool.getResource()){
			value = jedis.get(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return value;
	}

	public String set(String key, String value) {
		String ret = null;
		try ( Jedis jedis = jedisPool.getResource()){
			ret = jedis.set(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ret;
	}

	public String setex(String key, String value, int seconds) {
		String ret = null;
		try ( Jedis jedis = jedisPool.getResource()){
			ret = jedis.setex(key, seconds, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public <T> String setObj(String key, final T obj){
		String ret = null;
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] bs = ProtostuffIOUtil.toByteArray(obj, RuntimeSchema.createFrom((Class<T>)obj.getClass()),
					 LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE)); // 序列化
			ret = jedis.set(key.getBytes(), bs);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * 如果不存在则设置
	 * @param key
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Long setnxObj(String key, final T obj){
		Long ret = null;
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] bs = ProtostuffIOUtil.toByteArray(obj, RuntimeSchema.createFrom((Class<T>)obj.getClass()),
					 LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE)); // 序列化
			ret = jedis.setnx(key.getBytes(), bs);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public <T> String setexObj(String key, final T obj, int seconds){
		String ret = null;
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] bs = ProtostuffIOUtil.toByteArray(obj, RuntimeSchema.createFrom((Class<T>)obj.getClass()),
					 LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE)); // 序列化
			ret = jedis.setex(key.getBytes(), seconds, bs);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ret;
	}
	
	public <T> T getObj(final String key, Class<T> typeClass) {
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] data = jedis.get(key.getBytes());
			if(data == null || data.length == 0){
				return null;
			}
			Schema<T> schema = RuntimeSchema.createFrom(typeClass);
			T result = schema.newMessage();
			ProtostuffIOUtil.mergeFrom(data, result, schema);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Long expire(String key, int seconds){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.expire(key, seconds);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public Long del(String key) {
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.del(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public Long hset(final String key, final String field, final String value){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.hset(key, field, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public String hget(final String key, final String field){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.hget(key, field);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Map<String, String> hgetAll(final String key){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.hgetAll(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 设置对象到hash
	 * @param key
	 * @param field
	 * @param obj 对象
s	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Long hsetObj(final String key, final String field, final T obj){
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] bs = ProtostuffIOUtil.toByteArray(obj, RuntimeSchema.createFrom((Class<T>)obj.getClass()),
					 LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE)); // 序列化
			return jedis.hset(key.getBytes(), field.getBytes(), bs);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 设置对象到hash,并设置更新时间
	 * @param key
	 * @param field
	 * @param obj 对象
	 * @param seconds 过期时间
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Long hsetObj(final String key, final String field, final T obj, int seconds){
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] bs = ProtostuffIOUtil.toByteArray(obj, RuntimeSchema.createFrom((Class<T>)obj.getClass()),
					 LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE)); // 序列化
			Long ret = jedis.hset(key.getBytes(), field.getBytes(), bs);
			jedis.expire(key, seconds);
			return ret;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 从hash获取对象
	 * @param key
	 * @param field
	 * @param obj 对象
s	 * @return
	 */
	public <T> T hgetObj(final String key, final String field, Class<T> typeClass) {
		try ( Jedis jedis = jedisPool.getResource()){
			byte[] data = jedis.hget(key.getBytes(), field.getBytes());
			if(data == null || data.length == 0){
				return null;
			}
			Schema<T> schema = RuntimeSchema.createFrom(typeClass);
			T result = schema.newMessage();
			ProtostuffIOUtil.mergeFrom(data, result, schema);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 设置Map<String, String> hash
	 * @param key
	 * @param hash
	 * @return
	 */
	public String hmset(final String key, final Map<String, String> hash) {
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.hmset(key, hash);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 设置Map<String, String> hash,并设置过期时间
	 * @param key
	 * @param hash
	 * @param seconds
	 * @return
	 */
	public String hmsetex(final String key, final Map<String, String> hash, int seconds) {
		try ( Jedis jedis = jedisPool.getResource()){
			String result = jedis.hmset(key, hash);
			jedis.expire(key, seconds);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * hash key数量
	 * @param key
	 * @return
	 */
	public Long hlen(final String key){
		Long len = null;
		try ( Jedis jedis = jedisPool.getResource()){
			len = jedis.hlen(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return len;
	}
	
	/**
	 * hash 移除key
	 * @param key
	 * @param fields
	 * @return
	 */
	public Long hdel(final String key, final String fields){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.hlen(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 多个keys删除
	 * @param keys
	 * @return
	 */
	public Long removes(final String... keys){
		try ( Jedis jedis = jedisPool.getResource()){
			if(null == keys || "".equals(keys)){
				return null;
			}
			return jedis.del(keys);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 判断是否存在
	 * @param key
	 * @return
	 */
	public Boolean exists(final String key){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.exists(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}
	
	/**
	 * list.add
	 * @param key
	 * @param value
	 * @return
	 */
	public Long lpush(final String key, final String... value){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.lpush(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Long lrem(final String key, final long count, final String value){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.lrem(key, count, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public List<String> lrange(final String key, final int start, final int stop){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.lrange(key, start, stop);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public String ltrim(final String key, final int start, final int stop){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.ltrim(key, start, stop);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * set集合中是否存在member
	 * @param key
	 * @param member
	 * @return
	 */
	public Boolean existsInSet(final String key, final String member){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.sismember(key, member);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}
	
	public Long sadd(final String key, final String... members){ 
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.sadd(key, members);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Long srem(final String key, final String... members){ 
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.srem(key, members);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * set元素数量
	 * @param key
	 * @return
	 */
	public Long slen(final String key){ 
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.scard(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Set<String> smembers(final String key){ 
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.smembers(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 切换database
	 * @param index
	 * @return
	 */
	public String select(final int index){
		try ( Jedis jedis = jedisPool.getResource()){
			return jedis.select(index);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
