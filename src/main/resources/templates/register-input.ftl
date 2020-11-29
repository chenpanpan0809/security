<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>盼盼</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="./static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./static/css/admin.css" media="all">
    <link rel="stylesheet" href="./static/css/login.css" media="all">
    <link id="layuicss-layer" rel="stylesheet" href="./static/css/layer.css" media="all"></head>
<body layadmin-themealias="default">
<form class="layui-form" method="post">
    <div id="LAY_app" class="layadmin-tabspage-none"><script type="text/html" template="">
            <link rel="stylesheet" href="./static/css/login.css" media="all">
        </script>
        <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
            <input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="hidden" id="csrfHeader" name="_csrf_header" value="${_csrf.headerName}"/>
            <div class="layadmin-user-login-main">
                <div class="layadmin-user-login-box layadmin-user-login-header">
                    <h2>盼盼园地</h2>
                </div>
                <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-cellphone" for="LAY-user-login-cellphone"></label>
                        <input type="text" name="phone" id="LAY-user-login-cellphone" lay-verify="phone" placeholder="手机" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-row">
                            <div class="layui-col-xs7">
                                <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                                <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="验证码" class="layui-input">
                            </div>
                            <div class="layui-col-xs5">
                                <div style="margin-left: 10px;">
                                    <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="LAY-user-reg-getsmscode">获取验证码</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                        <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="密码" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
                        <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-nickname"></label>
                        <input type="text" name="username" id="LAY-user-login-nickname" lay-verify="nickname" placeholder="昵称" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <input type="checkbox" name="agreement" lay-skin="primary" title="同意用户协议" checked=""><div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><span>同意用户协议</span><i class="layui-icon layui-icon-ok"></i></div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="register">注 册</button>
                    </div>
                    <div class="layui-trans layui-form-item layadmin-user-login-other">
                        <label>社交账号注册</label>
                        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
                        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
                        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>

                        <a lay-href="/user/login" class="layadmin-user-jump-change layadmin-link layui-hide-xs">用已有帐号登入</a>
                        <a lay-href="/user/login" class="layadmin-user-jump-change layadmin-link layui-hide-sm layui-show-xs-inline-block">登入</a>
                    </div>
                </div>
            </div>

            <div class="layui-trans layadmin-user-login-footer">

                <p>© 2018 <a href="" target="_blank">panpan.com</a></p>
            </div>

        </div>
    </div>
</form>



    <script src="./static/layui/layui.js"></script>
    <script>
        layui.use([ 'form'], function(){
            var $ = layui.$
                ,form = layui.form;

            //提交
            form.on('submit(register)', function(obj){
                var field = obj.field;

                //确认密码
                if(field.password !== field.repass){
                    return layer.msg('两次密码输入不一致');
                }

                //是否同意用户协议
                if(!field.agreement){
                    return layer.msg('你必须同意用户协议才能注册');
                }

                //请求接口
                $.ajax({
                     url: '${base!}/register/save' //实际使用请改成服务端真实接口
                    ,data: field
                    ,type: "POST"
                    , beforeSend : function(xhr) {
                            xhr.setRequestHeader($("#csrfHeader").val(), $("#token").val());
                        }
                    ,success: function(res){
                         if (res.result){
                             layer.msg('注册成功', {
                                 offset: '15px'
                                 ,icon: 1
                                 ,time: 1000
                             }, function(){
                                 window.location.href = '${base!}/login'; //跳转到登入页
                             });
                         }else {
                             layer.msg(res.msg,{icon: 5});
                         }
                    }
                });

                return false;
            });
        });
    </script></div>


<style id="LAY_layadmin_theme">.layui-side-menu,.layadmin-pagetabs .layui-tab-title li:after,.layadmin-pagetabs .layui-tab-title li.layui-this:after,.layui-layer-admin .layui-layer-title,.layadmin-side-shrink .layui-side-menu .layui-nav>.layui-nav-item>.layui-nav-child{background-color:#20222A !important;}.layui-nav-tree .layui-this,.layui-nav-tree .layui-this>a,.layui-nav-tree .layui-nav-child dd.layui-this,.layui-nav-tree .layui-nav-child dd.layui-this a{background-color:#009688 !important;}.layui-layout-admin .layui-logo{background-color:#20222A !important;}</style><div class="layui-layer-move"></div></body></html>