let tableIns;
let tree;
layui.use(['element', 'form', 'table', 'layer', 'laydate','tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = document.documentElement.clientHeight - 160;

    tableIns = table.render({
        elem: '#authorityTable'
        , url: 'workerList'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.total, //解析数据长度
                "rows": data.list //解析数据列表
            };
        }
        , toolbar: '#authorityTableToolbarDemo'
        , title: '门店列表'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'name', title: '车间名称'}
            , {fixed: 'right', title: '操作', toolbar: '#authorityTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        let data = obj.data;
        //删除
        if (obj.event === 'del') {
            layer.confirm('确认删除吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "work/delete/" + data.id, {}, function (data) {
                    obj.del();
                    layer.close(index);
                    tableIns.reload();
                })
            });
        }
        //编辑
        else if (obj.event === 'edit') {
            table.render({
                elem: '#historyTable'
                , url: 'productedHistory/productHistoryList?workId='+data.id
                , method: 'POST'
                //请求前参数处理
                , request: {
                    pageName: 'page' //页码的参数名称，默认：page
                    , limitName: 'rows' //每页数据量的参数名，默认：limit
                }
                , response: {
                    statusName: 'flag' //规定数据状态的字段名称，默认：code
                    , statusCode: true //规定成功的状态码，默认：0
                    , msgName: 'msg' //规定状态信息的字段名称，默认：msg
                    , countName: 'records' //规定数据总数的字段名称，默认：count
                    , dataName: 'rows' //规定数据列表的字段名称，默认：data
                }
                // 响应后数据处理
                , parseData: function (res) { //res 即为原始返回的数据
                    var data = res.data;
                    return {
                        "flag": res.flag, //解析接口状态
                        "msg": res.msg, //解析提示文本
                        "records": data.total, //解析数据长度
                        "rows": data.list //解析数据列表
                    };
                }
                , title: '历史配置'
                , cols: [[
                    {field: 'id', title: 'ID', hide: true}
                    , {field: 'batch', title: '生产批次'}
                    , {field: 'mater', title: '生产物料'}
                    , {field: 'brand', title: '品牌'}
                    , {field: 'createdate', title: '创建时间'}
                    , {field: 'createuser', title: '创建用户'}
                ]]
                , defaultToolbar: ['', '', '']
                , page: true
                , height: height
                , cellMinWidth: 80
            }).reload();

        }
    });


    tableIns = table.render({
        elem: '#historyTable'
        , url: 'productedHistory/productHistoryList'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        // 响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.total, //解析数据长度
                "rows": data.list //解析数据列表
            };
        }
        , title: '历史配置'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'batch', title: '生产批次'}
            , {field: 'mater', title: '生产物料'}
            , {field: 'brand', title: '品牌'}
            , {field: 'createdate', title: '创建时间'}
            , {field: 'createuser', title: '创建用户'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });
});
