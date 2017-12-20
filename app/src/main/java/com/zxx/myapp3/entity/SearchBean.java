package com.zxx.myapp3.entity;

import java.util.List;

/**
 * 搜索好友Bean
 */

public class SearchBean {
    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-18T19:40:22","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/149.jpg","latitude":null,"longitude":null,"mobile":"13671003717","money":0,"nickname":"Yw","password":"123456","praiseNum":null,"token":"F3ECCDC85EBE30EF3C054DCB6B7584BD","uid":149,"userId":null,"username":"13671003717"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T12:01:08","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"13555481003","money":0,"nickname":"myNewNickName","password":"123456","praiseNum":null,"token":null,"uid":528,"userId":null,"username":"13555481003"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-19T00:00:00","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"18510588447","money":0,"nickname":"wutong","password":"123456","praiseNum":null,"token":null,"uid":951,"userId":null,"username":"18510588447"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-24T20:44:29","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"18510588888","money":0,"nickname":"wutong","password":"123456","praiseNum":null,"token":"86C5C23F5430ED3091E8B9FCADCB4395","uid":1052,"userId":null,"username":"18510588888"}]
     * page : 1
     */

    public String msg;
    public String code;
    public int page;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-18T19:40:22
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/149.jpg
         * latitude : null
         * longitude : null
         * mobile : 13671003717
         * money : 0
         * nickname : Yw
         * password : 123456
         * praiseNum : null
         * token : F3ECCDC85EBE30EF3C054DCB6B7584BD
         * uid : 149
         * userId : null
         * username : 13671003717
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
