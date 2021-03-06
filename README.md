**Permission**
```
<uses-permission android:name="android.permission.INTERNET"/>
```


**Installing**

Add repository in root build.gradle

```
repositories {
    maven { url "https://jitpack.io" }
}
```

And add dependency to module build.gradle:

```
dependencies {
    implementation 'com.github.aqitmalinzda:Volley-GR-Library:1.2.0'
}
```

**Sample Code**

```
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

    private fun moreRequest() {
        val request =
            VolleyGRequest(methodGET(), String/JSONObject/JSONArray::class.java, "URL", null, Response.Listener {
                toast(this, "Halo")
            }, Response.ErrorListener {
                log("Error: ", it.message.toString())
            })

        RequestQueue(this).addToRequestQueue(request)
    }
}
```
