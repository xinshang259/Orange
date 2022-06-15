package com.chsh.orange.app.util

import android.os.Bundle
import org.json.JSONObject
import org.json.JSONException
import java.lang.StringBuilder


object RequestUtils {

    const val KEY_CURRENT_MEDIA_TYPE = "currentType"

    const val VALUE_BUNDLE_FROM_MIX = "MIX_SERVICE"

    private fun getJsonValueStr(raw: String?, key: String): String? {
        try {
            val `object` = JSONObject(raw)
            return `object`.optString(key)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }

    private fun getJsonValueInt(raw: String, key: String, fallback: Int): Int {
        try {
            val `object` = JSONObject(raw)
            return `object`.optInt(key, fallback)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return fallback
    }

    private fun getJsonValueInt(raw: String, key: String): Int {
        return getJsonValueInt(raw, key, 0)
    }

    private fun getJsonValueDouble(raw: String, key: String, fallback: Double): Double {
        try {
            val `object` = JSONObject(raw)
            return `object`.optDouble(key, fallback)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return fallback
    }

    private fun getJsonValueDouble(raw: String, key: String): Double {
        return getJsonValueDouble(raw, key, 0.0)
    }

    fun getAction(raw: String?): String? {
        return getJsonValueStr(raw, "action")
    }

    /**
     * Retrieve the display ID from the request json string, or 0 if not included
     */
    fun getDisplayId(raw: String): Int {
        return getJsonValueInt(raw, "displayId")
    }

    /**
     * mediaType is 0 means all types, so return -1 if mediaType is not included
     */
    fun getMediaType(raw: String): Int {
        return getJsonValueInt(raw, "mediaType", -1)
    }

    fun getCurrentMediaType(raw: String): Int {
        return getJsonValueInt(raw, KEY_CURRENT_MEDIA_TYPE, -1)
    }

    fun getText(raw: String) : String?{
        return getJsonValueStr(raw, "text")
    }
}

fun Bundle?.toStringExt(): String? {
    if (this != null) {
        val sb = StringBuilder()
        sb.append("Bundle[{")
        for (key in keySet()) {
            sb.append(key)
            sb.append("=")
            sb.append(this[key])
            sb.append(", ")
        }
        sb.deleteCharAt(sb.length - 1)
        sb.deleteCharAt(sb.length - 1)
        sb.append("}]")
        return sb.toString()
    }
    return ""
}