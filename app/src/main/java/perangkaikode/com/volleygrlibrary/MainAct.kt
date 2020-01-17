package perangkaikode.com.volleygrlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Response
import org.json.JSONObject
import perangkaikode.com.volleygenericrequest.util.log
import perangkaikode.com.volleygenericrequest.util.methodPOST
import perangkaikode.com.volleygenericrequest.util.toast
import perangkaikode.com.volleygr.volley.RequestQueue
import perangkaikode.com.volleygr.volley.VolleyGRequest
import perangkaikode.com.volleygrlibrary.model.Login

class MainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun request() {
        val params = JSONObject()
        params.put("username", "")
        params.put("password", "")

        val request =
            VolleyGRequest(methodPOST(), Login::class.java, "URL", params, Response.Listener {
                toast(this, "Halo")
            }, Response.ErrorListener {
                log("Error: ", it.message.toString())
            })

        RequestQueue(this).addToRequestQueue(request)
    }
}
