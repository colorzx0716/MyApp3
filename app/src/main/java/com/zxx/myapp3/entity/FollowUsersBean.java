package com.zxx.myapp3.entity;

import java.util.List;

/**
 *获取关注列表bean
 */

public class FollowUsersBean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-16T10:11:13","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1512470827115mo.jpg","latitude":null,"longitude":null,"mobile":"18410261121","money":0,"nickname":"nnnnnn","password":"111111","praiseNum":null,"token":"C5F1896E305FA85630AA9BB54A621BC3","uid":195,"userId":null,"username":"18410261121"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-16T09:05:12","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/154.jpg","latitude":null,"longitude":null,"mobile":"13773359134","money":0,"nickname":"笑出腹肌的男人","password":"654321","praiseNum":null,"token":"B77920CD2D38574F335E2C137F821D61","uid":154,"userId":null,"username":"13773359134"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-14T20:06:23","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1512203571490dsf.jpg","latitude":null,"longitude":null,"mobile":"18339901531","money":0,"nickname":"若水","password":"123456","praiseNum":null,"token":"A315BB69D6F474CB1057185A8432A2B7","uid":77,"userId":null,"username":"18339901531"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-15T18:50:34","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/188.jpg","latitude":null,"longitude":null,"mobile":"18201205512","money":0,"nickname":"muzi","password":"123456","praiseNum":null,"token":"1CF78CD99420BCC297A5673C248769BD","uid":188,"userId":null,"username":"18201205512"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-14T19:48:28","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"13141287217","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":"BB6108B0FDDB7043800EBBF3492AFF47","uid":823,"userId":null,"username":"13141287217"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-16T10:06:05","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15131486893501.jpg","latitude":null,"longitude":null,"mobile":"15297526557","money":0,"nickname":"beautiful","password":"123456","praiseNum":null,"token":"D9C75CAADF0EE4C106A4C4D9B4DE1B19","uid":170,"userId":null,"username":"15297526557"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-15T21:54:22","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","latitude":null,"longitude":null,"mobile":"15810672623","money":0,"nickname":"小狼","password":"123456","praiseNum":null,"token":"28C3793F9AB8E555D523C46D8D867998","uid":150,"userId":null,"username":"15810672623"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-16T10:23:39","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1512179089975avator_thump.jpg","latitude":null,"longitude":null,"mobile":"15201392236","money":0,"nickname":"李灿灿","password":"111111","praiseNum":null,"token":"3E030858FEEED1026B1A1FB5CD5EF9ED","uid":148,"userId":null,"username":"15201392236"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-15T19:28:53","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1513166551600e.png","latitude":null,"longitude":null,"mobile":"15910489658","money":0,"nickname":"蒋顺聪","password":"111111","praiseNum":null,"token":"2062A865CF010E126AFC0F1442BC7D49","uid":73,"userId":null,"username":"15910489658"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-16T10:11:13
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/1512470827115mo.jpg
         * latitude : null
         * longitude : null
         * mobile : 18410261121
         * money : 0
         * nickname : nnnnnn
         * password : 111111
         * praiseNum : null
         * token : C5F1896E305FA85630AA9BB54A621BC3
         * uid : 195
         * userId : null
         * username : 18410261121
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public Object fans;
        public Object follow;
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
