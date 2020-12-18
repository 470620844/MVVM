package com.byl.mvvm.utils

import com.byl.mvvm.global.AppVariable
import com.tencent.mmkv.MMKV

/**
 * Created by 郑云波 on 2017/8/2.
 * 修改时间：
 * 版本号：1.0.0
 * 修改人：
 */
object MMKVUtil {
    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key key
     * @return value
     */
    fun put(key: String?, `object`: Any?) {
        if (`object` == null) {
            return
        }
        val kv = MMKV.defaultMMKV()
        if (`object` is String) {
            kv.encode(key, `object` as String?)
        } else if (`object` is Int) {
            kv.encode(key, (`object` as Int?)!!)
        } else if (`object` is Boolean) {
            kv.encode(key, (`object` as Boolean?)!!)
        } else if (`object` is Float) {
            kv.encode(key, (`object` as Float?)!!)
        } else if (`object` is Long) {
            kv.encode(key, (`object` as Long?)!!)
        } else {
            kv.encode(key, `object`.toString())
        }
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key key
     * @return value
     */
    fun putWithUser(key: String, value: Any?) {
        put(AppVariable.userId + key, value)
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key key
     * @param defaultValue defaultValue
     * @return value
     */
    fun getWithUser(key: String, defaultValue: Any?): Any? {
        return get(AppVariable.userId + key, defaultValue)
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key key
     * @param defaultObject defaultObject
     * @return value
     */
    operator fun get(key: String?, defaultValue: Any?): Any? {
        val kv = MMKV.defaultMMKV()
        if (defaultValue is String) {
            return kv.getString(key, defaultValue as String?)
        } else if (defaultValue is Int) {
            return kv.getInt(key, (defaultValue as Int?)!!)
        } else if (defaultValue is Boolean) {
            return kv.getBoolean(key, (defaultValue as Boolean?)!!)
        } else if (defaultValue is Float) {
            return kv.getFloat(key, (defaultValue as Float?)!!)
        } else if (defaultValue is Long) {
            return kv.getLong(key, (defaultValue as Long?)!!)
        }
        return null
    }
}