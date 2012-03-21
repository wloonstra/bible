<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>

<mypage:header/>
<mypage:left-menu/>

<div id="text-content">
    <h2>${categoriesHeader}</h2>
    <table>
        <c:forEach items="${bibleTexts}" var="bibleText">
            <tr>
                <td class="bible-pointer">
                    ${bibleText.textPointer}
                    <span class="bible-email">
                        Door: ${bibleText.email}
                    </span>
                </td>
                <td class="bible-text">
                    ${bibleText.text}
                    <c:forEach items="${bibleText.comments}" var="biblecomment">
                        <div class="bible-comment">
                            ${biblecomment.user.username} schreef op datum: <br /> 
                            <span class="italic">${biblecomment.comment}</span>
                        </div>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class='biblija'>
    ${liveBibleText}
</div>

<mypage:footer/>