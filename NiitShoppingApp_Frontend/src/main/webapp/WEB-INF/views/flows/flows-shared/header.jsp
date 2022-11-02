<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="fonts" value="/resources/fonts" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html lang="en">
<head>	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title> Sign Up Page </title>
    
    <script>
    	window.contextRoot = '${contextRoot}';
    </script>
    
    
    <link href="${css }/bootstrap.min.css" rel="stylesheet">
      <link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">
    <!--<link href="${css }/bootstrap-theme.min.css" rel="stylesheet">-->
    
    
	<!-- DataTables CSS -->
	<link href="${css }/dataTables.bootstrap.css" rel="stylesheet">
	 <!--  <link href="${css }/jquery.dataTables.css" rel="stylesheet">-->
	
	
	<!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">-->
    
    <!-- Custom CSS -->
    <link href="${css }/myapp.css" rel="stylesheet">

</head>

<body>
<%@include file="../../shared/navbar.jsp"%>
	