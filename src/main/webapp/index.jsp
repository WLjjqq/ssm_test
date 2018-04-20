<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <script type="text/javascript"
            src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<!-- 显示的页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12" align="center" >
            <h1>SSM项目的增删改查</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary btn-sm" id="emp_add_modal">新增</button>
            <button type="button" class="btn btn-primary btn-sm btn btn-warning" id="emp_all_del">删除</button>
        </div>
    </div>
    <!-- 表格 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <th>#</th>
                    <th>empName</th>

                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
    <!-- 分页 -->
    <div class="row">
        <div class="col-md-6" align="center" id="page_xinxi"></div>
        <div class="col-md-6" align="center" id="page_fenyetiao"></div>
    </div>
</div>

<script type="text/javascript">

    alert("d")
    //进来后先进入第一页
    $(function(){
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"${APP_PATH }/emps",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                //1:解析并显示员工数据。
                build_emps_table(result);

            }
        });
    }


    //这个方法是显示所有员工数据的。
    function build_emps_table(result){
        //每次构建的时候都要清空数据。
        $("#emps_table tbody").empty();
        var emps=result.map.pageInfo.list;
        $.each(emps,function(index,item){
            var checkBoxTd=$("<td><input type='checkbox' class='check_item'/></td>");
            var empIdTd=$("<td></td>").append(item.empId);
            var empNameTd=$("<td></td>").append(item.empName);

            /**
             <button class="">
             <span class="" aria-hidden="true"></span>
             编辑
             </button>
             */
            var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
                .append("编辑");
            //给编辑按钮添加一个自定义属性。用来表示当前员工的ID。
            editBtn.attr("edit-id",item.empId);
            var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            delBtn.attr("del-id",item.empId);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //先在<tbody>下创建<tr>标签。然后创建的<td>标签追加到<tr>的后面。
            $("<tr></tr>").append(checkBoxTd)
                .append(empIdTd)
                .append(empNameTd)
                .append(btnTd)
                .appendTo("#emps_table tbody");

        });
    }
</script>

<h2>Hello World!订单</h2>
<a href="/emps">显示所有</a>
<h3>上传图片</h3>
<form action="/LI/testFileUpload" enctype="multipart/form-data" method="post">
      上传用户：<input type="text" name="username"><br/>
          上传文件：<input type="file" name="file"><br/>
          描述：<input type="text" name="desc"><br/>
          <input type="submit" value="提交">
</form>
<a href="/LI/testDownload/id">下载文件</a>
</body>
</html>
