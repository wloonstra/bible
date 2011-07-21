<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>

<mypage:header/>

<div id="category-menu">
    <ul class="menu">
        <c:forEach items="${categories}" var="category">
            <li><a href="${category.url}">${category.name}</a></li>
        </c:forEach>
    </ul>
</div>

<div id="text-content">
    <h2>${categoriesHeader}</h2>
    <table>
        <c:forEach items="${bibleTexts}" var="bibleText">
            <tr>
                <td class="bible-pointer">${bibleText.textPointer}</td>
                <td class="bible-text">
                    ${bibleText.text}
                    <span class="bible-motivation">${bibleText.motivation}</span>
                </td>
        </c:forEach>
    </table>
</div>

<div class='biblija'>
    ${liveBibleText}
</div>

<mypage:footer/>