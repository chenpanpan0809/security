<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui.form小例子</title>
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all">
</head>
<body>
<div class="layui-container">
<form class="layui-form"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <input  name="id"  hidden value="${order.id!}">
    <input  name="companyId"  hidden value="${order.companyId!}">
    <div class="layui-form-item" style="margin-top: 10px;">
        <div class="layui-inline">
            <label class="layui-form-label">公司名称</label>
            <div class="layui-input-inline">
                <input type="text" name="company" placeholder="公司名称"  class="layui-input" value="${order.company!}">
            </div>
            <label class="layui-form-label">下单时间</label>
            <div class="layui-input-inline">
                <input type="text" id="orderTime" name="" placeholder="下单时间" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">品名</label>
            <div class="layui-input-inline">
                <input type="text" name="itemName" placeholder="品名"  class="layui-input" value="${order.itemName!}">
            </div>
            <label class="layui-form-label">型号</label>
            <div class="layui-input-inline">
                <input type="text" name="itemType" placeholder="型号"  class="layui-input" value="${order.itemType!}">
            </div>
            <label class="layui-form-label">编码</label>
            <div class="layui-input-inline">
                <input type="text" name="bh" placeholder="编码"  class="layui-input" value="${order.bh!}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">单价</label>
            <div class="layui-input-inline">
                <input type="text" name="price" placeholder="单价"  class="layui-input" value="${order.price!}">
            </div>
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <input type="text" name="num" placeholder="数量"  class="layui-input" value="${order.num!}">
            </div>
            <label class="layui-form-label">单位</label>
            <div class="layui-input-inline">
                <input type="text" name="danwei" placeholder="单位"  class="layui-input" ${order.danwei!}>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">到货日期</label>
        <div class="layui-input-inline">
            <input type="text" id="dhrq" name="dhrq" placeholder="到货日期" autocomplete="off" class="layui-input" />
        </div>
        <label class="layui-form-label">入库日期</label>
        <div class="layui-input-inline">
            <input type="text" id="rkrq" name="rkrq" placeholder="入库日期" autocomplete="off" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="备注" name="bz" class="layui-textarea">${order.bz!}</textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="fromOrder">立即提交</button>
        </div>
    </div>
    <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
</div>
<script src="../static/layui/layui.js"></script>
<script>
    layui.use(['form','laydate','element'], function(){
        var $ =layui.jquery, form = layui.form,laydate = layui.laydate,element = layui.element;

        laydate.render({
            elem: '#orderTime' //指定元素
            ,trigger: 'click' //采用click弹出
            <#if order.orderTime??>,value:formatDate('${order.orderTime!}')</#if>
        });
        laydate.render({
            elem: '#dhrq' //指定元素
            ,trigger: 'click' //采用click弹出
            <#if order.dhrq??>,value:  formatDate('${order.dhrq!}')</#if>
        });
        laydate.render({
            elem: '#rkrq' //指定元素
            ,trigger: 'click' //采用click弹出
            <#if order.rkrq??>,value: formatDate('${order.rkrq!}')</#if>
        });

        function formatDate(date) {
            var d = new Date(date),
                month = '' + (d.getMonth() + 1),
                day = '' + d.getDate(),
                year = d.getFullYear();

            if (month.length < 2) month = '0' + month;
            if (day.length < 2) day = '0' + day;

            return [year, month, day].join('-');
        }
        form.on('submit(fromOrder)', function(data){
            $.ajax({
                url:"${base!}/order/save",
                data:{"param":JSON.stringify(data.field)},
                type:"POST",
                dataType:"JSON",
                success:function (res){
                    if(res.status === 0){
                        layer.msg(res.message,{'icon':6});
                    }else{
                        layer.msg(res.message,{'icon':5});
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>