document.addEventListener("DOMContentLoaded", function () {
    // Element, do którego dodamy ponumerowaną listę
    var listContainer = document.getElementById("numberedList");

    // Tworzenie elementu listy
    var orderedList = document.createElement("ol");

    // Dodawanie elementów listy
    for (var i = 1; i <= 5; i++) {
        var listItem = document.createElement("li");
        listItem.textContent = "Element " + i;
        orderedList.appendChild(listItem);
    }

    // Dodawanie listy do kontenera
    listContainer.appendChild(orderedList);
});