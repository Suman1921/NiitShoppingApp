<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p class="lead">Niit Shopping Hub</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.categoryId}/products"
			class="list-group-item" id="a_${category.categoryName }">${category.categoryName}</a>
	</c:forEach>



</div>
