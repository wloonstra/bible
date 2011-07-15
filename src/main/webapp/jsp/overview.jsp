<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>

<mypage:header/>

<div id="category-menu">
    <ul class="menu">
        <c:forEach items="${categories}" var="category">
            <li>${category.name}</li>
        </c:forEach>
    </ul>
</div>

<div id="text-content">
    <table>
        <c:forEach items="${bibleTexts}" var="bibleText">
            <tr>
                <td>${bibleText.book.name} ${bibleText.startChapter}:${bibleText.startVerse} - ${bibleText.endChapter}:${bibleText.endVerse}</td>
                <td>${bibleText.motivation}</td>
        </c:forEach>
    </table>
</div>

<div class='biblija'>
    ${liveBibleText}
</div>

<mypage:footer/>