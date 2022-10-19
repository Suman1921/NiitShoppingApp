<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="fonts" value="/resources/fonts" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>NiitShoppingApp - ${title}</title>
    
    <script>
		window.menu = '${title}';
	
		window.contextRoot = '${contextRoot}'
	
	</script>

    <!-- Bootstrap Core CSS -->
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
	
	<div class="wrapper">
    	<!-- Navigation -->
    	<%@include file="./shared/navbar.jsp" %>
		<div class="content">
    	<!-- Page Content -->
	    <c:if test="${userClickHome == true }">
	    	<%@include file="home.jsp" %>
	    </c:if>
	    
	    <c:if test="${userClickAbout == true }">
	    	<%@include file="about.jsp" %>
	    </c:if>
	    
	    <c:if test="${userClickContact == true }">
	    	<%@include file="contact.jsp" %>
	    </c:if>
	    
	    <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
	    	<%@include file="listProducts.jsp" %>
	    </c:if>
	    
	    <c:if test="${userClickShowProduct == true}">
	    	<%@include file="singleProduct.jsp" %>
	    </c:if>
	    
	    <c:if test="${userClickManageProducts == true}">
	    	<%@include file="manageProducts.jsp" %>
	    </c:if>
	    
	    
	    <!-- /.container -->
		</div>
	    <%@include file="./shared/footer.jsp" %>
	    <!-- /.container -->
	
    <!-- jQuery -->
    <script src="${js }/jquery.js"></script>
    <script src="${js}/jquery.validate.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js }/bootstrap.min.js"></script>
    
    <!-- Datatable JS -->
    
    <script src="${js }/jquery.dataTables.js"></script>
    
    <script src="${js }/dataTables.bootstrap.js"></script>
    
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js">-->
    
	<script src="${js }/myscript.js"></script>
	
	
	</div>
</body>

</html>