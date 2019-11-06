<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>附件管理</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function queryList() {
            var pageNo = $("#pagenum").val();
            var reg = /^[1-9]\d*$/;
            if (!reg.test(pageNo)){
                alert("请输入正确的页码");
                return;
            }else {
                window.location.href="${requestURI}?pageNum"+pageNo+"${queryStr}";
            }
        }
    </script>

</head>

<tr align="right" bgcolor="#EEF4EA">
    <td height="36" colspan="12" align="center">
        <div>
            <a href="${requestURI}?pageNum=1${queryStr}">首页</a>
            <a href="${requestURI}?pageNum=${page.pageNum-1}">上一页</a>
            <c:forEach items="${page.navigatepageNums}" var="pageNum">
                <c:if test="${pageNum == page.pageNum}">
                    <span style="color: black;font-weight: bold">${pageNum}</span>
                </c:if>
                <c:if test="${pageNum != page.pageNum}">
                    <a href="${requestURI}?pageNum=${pageNum}"></a>
                </c:if>
            </c:forEach>
            <a href="${requestURI}?pageNum=${page.pageNum+1}">下页</a>
            <a href="${requestURI}?pageNum=${page.pages}">末页</a>
            &nbsp;&nbsp;跳转到<input type="text" size="1px" id="pagenum" onblur="queryList()">页
        </div>
    </td>
</tr>

