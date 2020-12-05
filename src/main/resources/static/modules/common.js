/** layuiAdmin.std-v1.4.0 LPPL License By https://www.layui.com/admin/ */
layui.define(function(e) {
   var $ = layui.$;
    var i = (layui.$, layui.layer, layui.laytpl, layui.setter, layui.view, layui.admin);

    i.events.logout = function() {
        $.ajax({
            url: getRoot()+'/logout',
            type: "get",
            success: function (res) {
            window.location.href = getRoot()+"/login"
            }
        })
    },
        window.getRoot = function () {
            var curPath = window.document.location.href;
            var pathname = window.document.location.pathname;
            var pos = curPath.indexOf(pathname);
            return curPath.substring( 0, pos )+pathname.substring(0,pathname.substring(1).indexOf("/")+1);
        }
        e("common", {})
});