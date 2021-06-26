<html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>结存数量</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all">
</head>
<body>
<table id="wlbm" lay-filter="test"></table>
</body>

<script src="${base}/static/layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

      var wlbm =  table.render({
            elem: '#wlbm'
            ,url: '${base!}/wlbm/listApi/' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{field: 'bm', title: '存货编码'}
                ,{field: 'name', title: '存货名称'}
                ,{field: 'size', title: '存货规格'}
                ,{field: 'unit', title: '存货单位'}
                ,{field: 'jzsl', title: '结存数量'}
              ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:130}
            ]]
        });

    });
</script>

</html>