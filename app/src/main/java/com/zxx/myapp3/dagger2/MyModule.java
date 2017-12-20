package com.zxx.myapp3.dagger2;

import com.zxx.myapp3.view.AdView;
import com.zxx.myapp3.view.FollowUsersView;
import com.zxx.myapp3.view.JokerView;
import com.zxx.myapp3.view.LoginView;
import com.zxx.myapp3.view.SearchView;
import com.zxx.myapp3.view.UserInfoView;
import com.zxx.myapp3.view.VideosView;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger2
 */

@Module
public class MyModule {

    private LoginView loginView;
    private UserInfoView userInfoView;
    private FollowUsersView followUsersView;
    private SearchView searchView;
    private AdView adView;
    private VideosView videosView;
    private JokerView jokerView;

    public MyModule(JokerView jokerView) {
        this.jokerView = jokerView;
    }

    public MyModule(AdView adView, VideosView videosView) {
        this.adView = adView;
        this.videosView = videosView;
    }

    public MyModule(SearchView searchView) {
        this.searchView = searchView;
    }

    public MyModule(FollowUsersView followUsersView) {
        this.followUsersView = followUsersView;
    }

    public MyModule(UserInfoView userInfoView) {
        this.userInfoView = userInfoView;
    }

    public MyModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides //登录
    LoginView providesLogin(){
        return loginView;
    }

    @Provides //用户信息
    UserInfoView providesUserInfo(){
        return userInfoView;
    }


    @Provides //获取关注列表
    FollowUsersView providesFollowUsers(){
        return followUsersView;
    }

    @Provides//搜搜好友
    SearchView providesSearch(){
        return searchView;
    }

    @Provides//广告
    AdView provides(){
        return adView;
    }

    //视频
    @Provides
    VideosView providesVideos(){
        return videosView;
    }

    //段子列表
    @Provides
    JokerView providesJoker(){
        return jokerView;
    }






}
