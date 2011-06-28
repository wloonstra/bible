<%@ taglib prefix="mypage" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<mypage:header/>

<h3>Voeg hier je bijbeltekst toe</h3>

<p>Geef de gegevens op.</p>

<form action="tekst-toevoegen" method="POST">
    <spring:bind path="textForm.*">
        <label for="book">Bijbelboek</label>
        <input name="book" type="text"/> <br>
        <label for="startChapter">start hoofdstuk</label>
        <input name="startChapter" type="text"/> <br>
        <label for="startVerse">start vers</label>
        <input name="startVerse" type="text"/> <br>
        <label for="endChapter">einde hoofdstuk</label>
        <input name="endChapter" type="text"/> <br>
        <label for="endVerse">einde vers</label>
        <input name="endVerse" type="text"/> <br>
        <label for="motivation">Motivatie</label>
        <textarea name="motivation"></textarea> <br>
        <input type="submit" value="Voeg toe"/>
    </spring:bind>
</form>