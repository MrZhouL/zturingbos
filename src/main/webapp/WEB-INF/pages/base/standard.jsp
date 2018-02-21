<%--
  Created by IntelliJ IDEA.
  User: zhoulei
  Date: 2018/2/19
  Time: 上午12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基础模块-取派标准</title>

    <!-- 导入jquery核心类库 -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <!-- 导入easyui类库 -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/default.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
            type="text/javascript"></script>

    <script type="text/javascript">
        function doAdd(){
            $('#addStandardWindow').attr('title','添加收派标准');
            $('#addStandardWindow').window("open");
        }

        function doView(){
            alert("查看...");
        }

        function doDelete(){
            $.messager.confirm('提示','确认删除？',function(isConfirm){
                if(isConfirm){
                    //1,获取所有选中的id
                    var rows = $("#grid").datagrid('getSelections');
                    var ids = [];
                    for (var i = 0; i<rows.length;i++){
//                console.log(rows[i].id);
                        ids.push(rows[i].id);
                    }
                    console.log(ids.join(","));
                    //2,发送请求"
                    $.post("${pageContext.request.contextPath}/standard_delete.action",{ids:ids.join(",")},function(data){
                        //删除添加成功后重新加载
                        console.log(data);
                        $("#grid").datagrid("reload");
                        $("#grid").datagrid("unselectAll");
                    });

                }
            });


        }
        //双击表格事件，打开修改窗口，对数据进行回显
        function doDblClickRow(rowIndex,rowData){
            console.log(rowIndex);
            console.log(rowData);
            $('#addStandardWindow').attr('title','修改收派标准');
            $("#name").val(rowData.name);
            $('#minweight').numberbox('setValue',rowData.minweight);
            $('#maxweight').numberbox('setValue',rowData.maxweight);

            $('#standardId').val(rowData.id);

            //弹出窗口
            $('#addStandardWindow').window('open');
        }
        //工具栏
        var toolbar = [ {
            id : 'button-view',
            text : '查询',
            iconCls : 'icon-search',
            handler : doView
        }, {
            id : 'button-add',
            text : '增加',
            iconCls : 'icon-add',
            handler : doAdd
        }, {
            id : 'button-delete',
            text : '删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        }];
        // 定义列
        var columns = [ [ {
            field : 'id',
            checkbox : true,
        },{
            field : 'name',
            title : '标准名称',
            width : 120,
            align : 'center'
        }, {
            field : 'minweight',
            title : '最小重量',
            width : 120,
            align : 'center'
        }, {
            field : 'maxweight',
            title : '最大重量',
            width : 120,
            align : 'center'
        }, {
            field : 'user.username',
            title : '操作人',
            width : 120,
            align : 'center',
            formatter : function (value,row,index) {
                return row.userByUserId.username
            }

        }, {
            field : 'updatetime',
            title : '操作时间',
            width : 160,
            align : 'center',
            formatter : function (value,row,index) {
                return value.replace("T",' ');
            }
        }, {
            field : 'user.station',
            title : '操作单位',
            width : 200,
            align : 'center',
            formatter : function (value,row,index) {
                return row.userByUserId.station
            }
        } ] ];

        $(function () {
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({visibility:"visible"});

            // 收派标准数据表格
            $('#grid').datagrid( {
                iconCls : 'icon-forward',
                fit : true,
                border : false,
                rownumbers : true,
                striped : true,
                pageList: [30,50,100],
                pagination : true,
                toolbar : toolbar,
                url : "${pageContext.request.contextPath}/standard_pageQuery.action",
                idField : 'id',
                columns : columns,
                onDblClickRow : doDblClickRow
            });

            // 添加收派标准窗口
            $('#addStandardWindow').window({
                title: '添加收派标准',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false,
                onBeforeClose : function(){
                    // 重置form
                    $('#standardForm').form('reset');
                    // 对form 添加离焦事件
                    $('#standardForm *').trigger('blur');
                }
            });

            //为保存添加点击事件
            $('#save').click(function(){
                if($('#standardForm').form('validate')){
                    // 通过
                    // $("#standardForm").submit();

                    // 第一种
                    //$.post("${pageContext.request.contextPath }/standard_save.action",$("#standardForm").serialize(), function(data){
                    // 回调函数
                    //});

                    // 第二种  使用 easyui 的 form 控件
                    $('#standardForm').form('submit',{
                        url : '${pageContext.request.contextPath }/standard_save.action',
                        success : function(data) {
                            // 回调函数
                            // 这里data，返回"success", 没有转换为 json对象
                            data = eval("("+data+")");
                            if(data == "success"){
                                $.messager.alert("信息","添加标准成功","info");
                            }else{
                                $.messager.alert("信息","添加标准失败","error");
                            }
                            // 窗口关闭
                            $('#addStandardWindow').window("close");
                            // 重置form
                            $('#standardForm').form('reset');
                            // 对form 添加离焦事件
                            $('#standardForm *').trigger('blur');
                            //刷新数据
                            $("#grid").datagrid("reload");
                        }
                    });

                }else{
                    $.messager.alert('信息','您的表单存在非法数据项，请重新填写！','warning');
                }
            });
        });
    </script>
</head>

<body class="easyui-layout" style="visibility:hidden;">
    <div region="center" border="false">
        <table id="grid"></table>
    </div>

    <div class="easyui-window" title="" id="addStandardWindow" collapsible="false" minimizable="false"
         maximizable="false" style="top:100px;left:200px">
        <div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
            <div class="datagrid-toolbar">
                <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
            </div>
        </div>
        <div region="center" style="overflow:auto;padding:5px;" border="false">
            <form action="${pageContext.request.contextPath }/standard_save.action" method="post" id="standardForm">
                <table class="table-edit" width="80%" align="center">
                    <tr class="title">
                        <td colspan="2">收派标准信息</td>
                    </tr>
                    <tr>
                        <td>标准名称</td>
                        <td>
                            <input type="text" class="easyui-validatebox" required="true" name="name" id="name"/>
                            <input type="hidden" name="id" id="standardId">
                        </td>
                    </tr>
                    <tr>
                        <td>最小重量</td>
                        <td><input type="text" class="easyui-numberbox" data-options="required:true" name="minweight" id="minweight"/></td>
                    </tr>
                    <tr>
                        <td>最大重量</td>
                        <td><input type="text" class="easyui-numberbox" data-options="required:true" name="maxweight" id="maxweight"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
