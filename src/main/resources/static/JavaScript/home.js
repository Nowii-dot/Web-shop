// document.addEventListener("DOMContentLoaded", function () {
//     const navbar = document.querySelector(".bar");
//
//     window.addEventListener("scroll", function () {
//         if (window.scrollY > 50) {
//             navbar.classList.add("transparent");
//         } else {
//             navbar.classList.remove("transparent");
//         }
//     });
//
//     const userLink = document.querySelector(".user-link");
//     const dropdown = document.querySelector(".dropdown");
//
//     if (userLink && dropdown) {
//         userLink.addEventListener("click", function (event) {
//             event.preventDefault();
//             dropdown.classList.toggle("show");
//         });
//
//         document.addEventListener("click", function (event) {
//             if (!userLink.contains(event.target) && !dropdown.contains(event.target)) {
//                 dropdown.classList.remove("show");
//             }
//         });
//     }
// });

document.addEventListener("DOMContentLoaded", function () {
    console.log("Plik home.js załadowany!");

    const swiper = new Swiper('.swiper-container', {
        slidesPerView: 1, // Ilość widocznych slajdów
        spaceBetween: 10, // Odstęp między slajdami
        loop: true, // Umożliwia przewijanie w kółko
        navigation: {
            nextEl: ".swiper-button-next", // Przyciski nawigacyjne
            prevEl: ".swiper-button-prev"
        },
        pagination: {
            el: ".swiper-pagination", // Paginacja
            clickable: true // Umożliwia klikanie w kropki paginacji
        },
        autoplay: {
            delay: 3000, // Czas przejścia do kolejnego slajdu (3 sekundy)
            disableOnInteraction: false // Umożliwia ciągłe przewijanie
        },
        breakpoints: {
            768: { slidesPerView: 2 }, // Na tabletach dwa slajdy
            1024: { slidesPerView: 3 } // Na desktopie trzy slajdy
        }
    });

    console.log("Swiper initialized:", swiper);
});

