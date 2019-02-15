<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>蓝源Eloan-P2P平台</title>
<#include "common/links-tpl.ftl" />
    <link type="text/css" rel="stylesheet" href="/css/account.css"/>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/js/plugins-override.js"></script>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#pagination").twbsPagination({
                totalPages: '${pageResult.totalPage}',
                visiblePages: 7,
                startPage:${pageResult.currentPage},
                first: '首页',
                onPageClick: function (event, page) {
                    $("#currentPage").val(page);
                    $("#searchForm").submit();
                }
            });
            //查看文章
            $(".inputBtn").click(function () {
                //1:先清空模态框的数据,再来做操作
                $("#inputModal input").val("");
                //2:获取当前按钮中的自定义JSON对象
                var obj = $(this).data("json");
                console.log(obj);
                if(obj){
                    $("#editForm input[name='id']").val(obj.id);
                    $("#editForm input[name='workName']").val(obj.workName);
                    $("#editForm input[name='workType']").val(obj.workType);
                    $("#editForm input[name='workNumber']").val(obj.workNumber);
                    $("#editForm input[name='date']").val(obj.date);
                    $("#editForm textarea[name='remark']").text(obj.remark);

                }
                $("#inputModal").modal("show")
            });

            //编辑
            $("#submit").click(function () {
                $("#editForm").ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.confirm("温馨提示", "操作成功", function () {
                            location.reload();
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg);
                    }
                });
            });

            $('.deleteBtn').click(function () {
                var url = $(this).data("url");
                $.messager.confirm("温馨提示","亲,您确定要删除改数据吗?",function () {
                    $.get(url,function () {
                        location.reload();
                    })
                });
            });
        });
    </script>
</head>
<body>

<!-- 网页顶部导航 -->
<#include "common/head-tpl.ftl" />
<!-- 网页导航 -->
<#assign currentNav="ipLog" />
<#include "common/navbar-tpl.ftl" />

<div class="container-fluid">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
            <#assign currentMenu="accountbookinfo"/>
					<#include "common/leftmenu-tpl.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9">
            <form action="/accountBookInfo/list" name="searchForm" id="searchForm" class="form-inline" method="post">
                <input type="hidden" id="currentPage" name="currentPage" value="${qo.currentPage}"/>
                <div class="form-group">
                    <label>时间范围</label>
                    <input type="text" class="form-control beginDate" name="beginDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                           value='${(qo.beginDate?string("yyyy-MM-dd"))!""}'/>
                </div>
                <div class="form-group">
                    <label></label>
                    <input type="text" class="form-control endDate" name="endDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                           value='${(qo.endDate?string("yyyy-MM-dd"))!""}'/>
                </div>
            <#--    <div class="form-group">
                    <label>状态</label>
                    <select class="form-control" name="state" id="state">
                        <option value="-1">全部</option>
                        <option value="0">登录失败</option>
                        <option value="1">登录成功</option>
                    </select>
                </div>
                    <script>
                      $("#state option[value='']").attr("selected",true);
                    </script>-->
                <div class="form-group">
                    <label>工人</label>
                    <input type="text" class="form-control endDate" name="username" value="${qo.username!""}"/>
                </div>
                <div class="form-group">
                    <button type="submit" id="query" class="btn btn-success"><i class="icon-search"></i> 查询</button>
                </div>
                <#--<div>

                </div>-->
                <div class="form-group">
                    <button type="button" class="btn btn-success inputBtn">新增</button>
                    <button type="button" class="btn btn-info">导入</button>
                    <button type="button" class="btn btn-primary">导出</button>
                </div>
            </form>

            <div class="panel panel-default" style="margin-top: 20px;">
               <div class="panel-heading">
                    账本信息

               </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>工人</th>
                        <th>工作类型</th>
                        <th>工号</th>
                        <th>时间</th>
                        <th>备注</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageResult.listData as itme>
                    <tr>
                        <td>${itme.workName}</td>
                        <td>${itme.workType}</td>
                        <td>${itme.workNumber}</td>
                        <td>${itme.date?string("yyyy-MM-dd HH:mm")}</td>
                        <td>${itme.remark}</td>
                        <td>
                            <button type="button" class="btn btn-warning inputBtn" data-json='${itme.json}'>修改</button>
                            <button type="button" class="btn btn-danger" data-url="/accountBookInfo/delete?id=${itme.id}">删除</button>
                        </td>

                    </tr>
                    </#list>
                    </tbody>
                </table>
                <div style="text-align: center;">
                    <ul id="pagination" class="pagination"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="inputModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">编辑/新增</h4>
            </div>
            <div class="modal-body content">
                <form class="form-horizontal" action="/accountBookInfo/saveOrUpdate" method="post" id="editForm">
                    <input id="strategyId" type="hidden" name="id"/>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">工人</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="title" name="workName" placeholder="工人">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">工作类型</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="subTitle" name="workType" placeholder="工作类型">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">工号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="subTitle" name="workNumber" placeholder="工号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">时间</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="subTitle" onclick="WdatePicker()" name="date" placeholder="时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">备注</label>
                        <div class="col-sm-6">
                            <textarea type="text" class="form-control" id="subTitle" name="remark" placeholder="备注"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a href="javascript:void(0);" class="btn btn-success" id="submit" aria-hidden="true">保存</a>
                <a href="javascript:void(0);" class="btn" data-dismiss="modal" aria-hidden="true">关闭</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>