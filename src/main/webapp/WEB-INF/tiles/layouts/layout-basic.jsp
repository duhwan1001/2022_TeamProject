<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- header js, css, CDN -->
    <tiles:insertAttribute name="include"/>
</head>
<body id="page-top">
<div id="wrapper">
    <!-- side -->
    <tiles:insertAttribute name="side"/>
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <tiles:insertAttribute name="header"/>
            <div id="mainContent" class="container-fluid">
               <tiles:insertAttribute name="body"/>
            </div>
        </div>
        <!-- footer -->
        <tiles:insertAttribute name="footer"/>
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<tiles:insertAttribute name="includeUnderJS"/>
</body>
</html>