<%@ page import="java.util.Enumeration" %>
<%@ page import="com.teamProject.erp.dto.MemberDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>body tiles test</h1>

<%String id = (String) session.getAttribute("userId");%>

<%=id%>
