<%--
  Created by IntelliJ IDEA.
  User: zhoulei
  Date: 2018/2/17
  Time: 下午3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //清空session
    session.invalidate();

    //重定向到登录页面
    response.sendRedirect(request.getContextPath()+"/login.jsp");
%>
