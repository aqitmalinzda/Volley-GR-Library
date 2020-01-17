package perangkaikode.com.volleygr.volley;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class VolleyGRequest<T> extends JsonRequest<T> {

    private final Gson gson = new Gson();
    private final Class<T> clazz;

    public VolleyGRequest(int method, Class<T> clazz, String url, @Nullable Object jsonRequest, Response.Listener<T> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener, errorListener);
        this.clazz = clazz;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            if (clazz == JSONObject.class) {
                return (Response<T>) Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));
            } else if (clazz == JSONArray.class) {
                return (Response<T>) Response.success(new JSONArray(jsonString), HttpHeaderParser.parseCacheHeaders(response));
            } else if (clazz == String.class) {
                return (Response<T>) Response.success(jsonString, HttpHeaderParser.parseCacheHeaders(response));
            } else {
                return Response.success(gson.fromJson(jsonString, clazz), HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
}
