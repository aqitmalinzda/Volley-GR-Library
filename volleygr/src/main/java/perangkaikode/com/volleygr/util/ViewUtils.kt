package perangkaikode.com.volleygenericrequest.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import org.json.JSONArray
import org.json.JSONObject

fun methodGET(): Int {
    return Request.Method.GET
}

fun methodPOST(): Int {
    return Request.Method.POST
}

fun methodDELETE(): Int {
    return Request.Method.DELETE
}

fun methodPUT(): Int {
    return Request.Method.PUT
}

fun JObject(): Class<JSONObject> {
    return JSONObject::class.java
}

fun JArray(): Class<JSONArray> {
    return JSONArray::class.java
}

fun JString(): Class<String> {
    return String::class.java
}

fun log(tag: String, message: String) {
    Log.d(tag, message)
}

fun toast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}