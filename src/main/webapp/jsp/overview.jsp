<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>

<mypage:header/>
<mypage:left-menu/>

<div id="text-content">
    <h2>${categoriesHeader}</h2>
    <c:choose>
        <c:when test="${empty bibleTexts}">
            Nog geen teksten in deze categorie.
        </c:when>
        <c:otherwise>
            <table>
                <c:forEach items="${bibleTexts}" var="bibleText">
                    <tr>
                        <td class="bible-pointer">
                            <a href="${bibleText.url}">${bibleText.textPointer}</a>
                            <span class="bible-email">
                                <c:if test="${allCategories}">
                                    ${bibleText.categoryName}
                                </c:if> <br />
                                Door: ${bibleText.user.name}
                            </span>
                        </td>
                        <td class="bible-text">
                            ${bibleText.textSnippet}
                        </td>
                        <td>
                            <c:if test="${not empty bibleText.comments}">
                                <img src="images/speech_balloon_icon.jpg" width="15"/>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>

<div class='biblija'>
    ${liveBibleText}
</div>

<mypage:footer/>