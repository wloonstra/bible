<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<mypage:header/>
<mypage:left-menu/>

<div id="text-content">
    <h3>Voeg hier je bijbeltekst toe</h3>
    
    <p>Geef de gegevens op.</p>
    <mypage:addTextForm textFormData="${textFormData}"/>
</div>


<mypage:footer/>