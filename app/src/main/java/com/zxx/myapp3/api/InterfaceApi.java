package com.zxx.myapp3.api;

import com.zxx.myapp3.entity.AdBean;
import com.zxx.myapp3.entity.FollowUsersBean;
import com.zxx.myapp3.entity.JokerBean;
import com.zxx.myapp3.entity.LoginBean;
import com.zxx.myapp3.entity.SearchBean;
import com.zxx.myapp3.entity.UserInfoBean;
import com.zxx.myapp3.entity.VideosBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 总接口
 */

public interface InterfaceApi {

    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("mobile") String mobile, @Field("password") String password);

    //用户信息
    @POST("user/getUserInfo")
    @FormUrlEncoded
    Observable<UserInfoBean> getUserInfo(@Field("uid") String uid);

    //获取关注列表
    @POST("quarter/getFollowUsers")
    @FormUrlEncoded
    Observable<FollowUsersBean> getFollowUsers(@Field("uid") String uid);

    //搜索好友
    @POST("quarter/searchFriends")
    @FormUrlEncoded
    Observable<SearchBean> getsearch(@Field("keywords") String keywords, @Field("page") String page);


    //广告
    @GET("quarter/getAd")
    Observable<AdBean> getAd();

    //获取视频列表--推荐的
    @POST("quarter/getVideos")
    @FormUrlEncoded
    Observable<VideosBean> getVideos(@Field("uid") String uid, @Field("type") String type, @Field("page") String page);

    //获取段子列表
    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<JokerBean> getUserJokes(@Field("page") String page);







}
