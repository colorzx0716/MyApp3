package com.zxx.myapp3.api;

/**
 * Created by 张肖肖 on 2017/12/19.
 */

import android.util.Log;

import com.zxx.myapp3.MyApp;
import com.zxx.myapp3.util.ShareprefrensUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截器，添加公共参数
 */

public class MyInterceptor implements Interceptor {
    public String TAG = "LogInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //String  token = MyApp.context.getSharedPreferences("TOKEN",Context.MODE_PRIVATE).getString("token","A0C48974F2BBBA4EC3053CDE21328D70");
        String token = (String) ShareprefrensUtils.get(MyApp.context, "token", "");
        String method=request.method();

        if("POST".equals(method)){
            Log.d(TAG,"----------Start----------------");
            FormBody.Builder sb = new FormBody.Builder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.add(body.encodedName(i) , body.encodedValue(i));
                }
                body=sb.add("source","android").add("appVersion","101")
                        .add("token",token)
                        .build();
                request=request.newBuilder().post(body).build();
                Log.d(TAG, "| "+request.toString());
            }else {
                MultipartBody body=(MultipartBody)request.body();
                MultipartBody.Builder build = new MultipartBody.Builder().setType(MultipartBody.FORM);
                build  .addFormDataPart("source","android");
                build  .addFormDataPart("appVersion","101");
                build  .addFormDataPart("token",token);
                List<MultipartBody.Part> parts = body.parts();
                for (MultipartBody.Part part : parts) {
                    build.addPart(part);
                }
                request =request.newBuilder().post(build.build()).build();

            }
        }else  if (request.method().equals("GET")) {
            //添加公共参数
            HttpUrl httpUrl = request.url()
                    .newBuilder()
                    .addQueryParameter("source","android")
                    .addQueryParameter("appVersion", "101")
                    .addQueryParameter("token", token)
                    .build();
            request = request.newBuilder().url(httpUrl).build();

        }

        return chain.proceed(request);
    }
}
