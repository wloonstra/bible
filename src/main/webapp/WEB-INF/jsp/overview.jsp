<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>

<mypage:header/>

<table>
    <c:forEach items="${bibleTexts}" var="bibleText">
        <tr>
            <td>${bibleText.book.name} ${bibleText.startChapter}:${bibleText.startVerse} - ${bibleText.endChapter}:${bibleText.endVerse}</td>
            <td>${bibleText.motivation}</td>
    </c:forEach>
</table>

