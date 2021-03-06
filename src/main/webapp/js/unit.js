/**
 * Created by Ninico on 2015-12-17.
 */

var Ninico = {};

/**
 * 得到一个包含图片文件的FormData对象
 * @param id 图片所在input的id
 * @param imgValName  变量名
 * @returns {FromData}
 *
 */

Ninico.getImgShow = function(id,imgValName){
    var file = $(id).get(0).files[0];
    var fd = new FormData();
    fd.append(imgValName,file);

    $("#viewPhoto").attr("src",window.URL.createObjectURL(file));

    return fd;
};

/**
 * 得到已发送FormData请求的ajax配置项.
 * @param url 访问的url
 * @param fd 要发送的FormData对象
 * @returns {配置项}
 */
Ninico.getFormDataRequestConfig = function(url,fd){

    var ajaxConfig = {
        method : "POST",
        'url' : url,
        data:fd,
        headers:{
            "Content-Type": undefined
            //'application/x-www-form-urlencoded'
        },
        transformRequest:function(data) {
            return data;
        }
    };

    return ajaxConfig;
};

/**
 *  一个将obj转换为键值对字符串的方法
 * @param 一个对象
 * @returns {返回post方法所需的key-val字符串}
 *
 */
Ninico.JsonToKeyVal = function(obj){

    var str = "";

    for(p in obj){

        str = str + p + "=" + obj[p] + "&";
    }

    str = str.slice(0,-1);
    console.log(str);

    return str;
};