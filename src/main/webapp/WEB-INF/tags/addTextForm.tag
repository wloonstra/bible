<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="textFormData" required="true" type="nl.wiggertloonstra.bible.ui.form.TextFormData" %>

<form action="tekst-toevoegen.html" method="POST">
    <spring:bind path="textFormInput.*">
        <label for="book">Bijbelboek</label>
        <select name="book">
            <c:forEach items="${textFormData.books}" var="book">
                 <option value="${book.id}">${book.name}</option>
            </c:forEach>
        </select> <br>

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

        <label for="category">Category</label>
        <select name="category">
            <c:forEach items="${textFormData.categories}" var="category">
                 <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select> <br>

        <label for="email">Jouw email</label>
        <input name="email" type="text"/> <br>

        <input type="submit" value="Voeg toe"/>
    </spring:bind>
</form>