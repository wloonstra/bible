<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>

<mypage:header/>
<mypage:left-menu/>

<div id="text-content">
    <h2>${bibleText.textPointer}</h2>
       Door: ${bibleText.user.name}
        ${bibleText.text}
        <c:forEach items="${bibleText.comments}" var="biblecomment">
            <div class="bible-comment">
                ${biblecomment.user.name} schreef op datum: ${biblecomment.placeDate }<br /> 
                <span class="italic">${biblecomment.comment}</span>
            </div>
        </c:forEach>
</div>

<mypage:footer/>