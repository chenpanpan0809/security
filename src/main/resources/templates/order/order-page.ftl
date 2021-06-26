<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>项目管理一体化平台</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">新增下单记录</button>
        <button class="layui-btn layui-btn-sm layui-bg-red" lay-event="getCheckData">删除</button>
    </div>
</script>



<script src="${base}/static/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="${base}/static/js/common.js"></script>
<script>
    layui.use(['table'], function(){
        var table = layui.table;
        var root = getRoot();
        table.render({
            elem: '#test'
            ,url:root+'/order/orderPageData'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,title: '下单统计'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'', title:'公司名称',fixed: 'left', width:120,
                    templet : '<div><a href="javascripte:;"onclick="openOrder( {{ d.id }} )" class="layui-table-link">{{d.company}}</a></div>'
                }
                ,{field:'order_time', title:'下单时间',fixed: 'left', width:107, sort: true,
                    templet : "<div>{{layui.util.toDateString(d.order_time, 'yyyy-MM-dd')}}</div>"
                }
                ,{field:'bh', title:'编码', width:165}
                ,{field:'item_name', title:'品名'}
                ,{field:'item_type', title:'型号'}
                ,{field:'price', title:'单价', width:80}
                ,{field:'num', title:'数量', width:60}
                ,{field:'danwei', title:'单位', width:60}
                ,{field:'dhrq', title:'到货日期', width:108}
                ,{field:'rkrq', title:'入库日期', width:108}
            ]]
            ,page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var url = getRoot()+"/order/input"
                    layer.open({
                        type:2,
                        content: url,
                        area: ['1005px', '500px'],
                        title:"新增下单记录"
                        });
                    break;
                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });

        window.openOrder = function (id){
            var url = getRoot()+"/order/input?id="+id;
            layer.open({
                type:2,
                content: url,
                area: ['1005px', '500px'],
                title:"查看下单记录"
            });
        }
    });

</script>

</body>
</html>