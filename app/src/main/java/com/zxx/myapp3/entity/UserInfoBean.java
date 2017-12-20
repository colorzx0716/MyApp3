package com.zxx.myapp3.entity;

/**
 * 获取用户信息成功
 */

public class UserInfoBean {
    /**
     * msg : 获取用户信息成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-15T09:56:47","email":null,"fans":1,"follow":0,"gender":0,"icon":"https://www.zhaoapi.cn/images/146.jpg","latitude":null,"longitude":null,"mobile":"13717830672","money":0,"nickname":"昵称是一个萝卜","password":"123456","praiseNum":null,"token":"929A310F425923598C7F3495BCAAA278","uid":146,"userId":null,"username":"13717830672"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-15T09:56:47
         * email : null
         * fans : 1
         * follow : 0
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/146.jpg
         * latitude : null
         * longitude : null
         * mobile : 13717830672
         * money : 0
         * nickname : 昵称是一个萝卜
         * password : 123456
         * praiseNum : null
         * token : 929A310F425923598C7F3495BCAAA278
         * uid : 146
         * userId : null
         * username : 13717830672
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public int fans;
        public int follow;
        public int gender;
        public String icon;
        public Object latitude;
        public Object longitude;
        public String mobile;
        public int money;
        public String nickname;
        public String password;
        public Object praiseNum;
        public String token;
        public int uid;
        public Object userId;
        public String username;
    }
}
