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

let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
}