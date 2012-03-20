<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="category-menu">
    <ul class="menu">
        <c:forEach items="${categories}" var="category">
            <li><a href="${category.url}">${category.name} (${category.numberOfTexts})</a></li>
        </c:forEach>
    </ul>
</div>
