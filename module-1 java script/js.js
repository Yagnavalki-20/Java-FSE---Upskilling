// main.js

// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");
window.addEventListener('DOMContentLoaded', () => {
    alert("Page fully loaded!");
    renderEvents(events);
});

// 2. Syntax, Data Types, and Operators
const eventName = "Community Music Night";
const eventDate = "2024-07-15";
let availableSeats = 50;
const eventInfo = `${eventName} on ${eventDate} - Seats: ${availableSeats}`;

// 3. Conditionals, Loops, and Error Handling
const today = new Date();
const events = [
    { name: "Community Music Night", date: "2024-07-15", seats: 50, category: "Music", location: "Hall A" },
    { name: "Baking Workshop", date: "2024-06-10", seats: 0, category: "Workshop", location: "Kitchen" },
    { name: "Yoga Morning", date: "2024-08-01", seats: 20, category: "Health", location: "Park" }
];

function isUpcoming(event) {
    return new Date(event.date) > today && event.seats > 0;
}

function displayValidEvents() {
    events.forEach(event => {
        if (isUpcoming(event)) {
            console.log(`${event.name} (${event.category}) - ${event.seats} seats`);
        }
    });
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(event) {
    events.push(event);
}

function registerUser(eventName) {
    try {
        const event = events.find(e => e.name === eventName);
        if (!event) throw new Error("Event not found");
        if (event.seats <= 0) throw new Error("No seats available");
        event.seats--;
        updateUI();
        return true;
    } catch (err) {
        alert(err.message);
        return false;
    }
}

function filterEventsByCategory(category, callback) {
    const filtered = events.filter(e => e.category === category);
    callback(filtered);
}

// Closure to track registrations per category
function createCategoryRegistrationTracker() {
    const counts = {};
    return function(category) {
        counts[category] = (counts[category] || 0) + 1;
        return counts[category];
    };
}
const trackRegistration = createCategoryRegistrationTracker();

// 6. Arrays and Methods
events.push(new Event("Art Fair", "2024-09-01", 30, "Art", "Gallery"));
const musicEvents = events.filter(e => e.category === "Music");
const eventCards = events.map(e => `${e.category} Event: ${e.name}`);

// 7. DOM Manipulation
function renderEvents(eventList) {
    const container = document.querySelector("#eventsContainer");
    if (!container) return;
    container.innerHTML = "";
    eventList.forEach(event => {
        if (!isUpcoming(event)) return;
        const card = document.createElement("div");
        card.className = "event-card";
        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.date} | ${event.location}</p>
            <p>Category: ${event.category}</p>
            <p>Seats: ${event.seats}</p>
            <button onclick="registerUserHandler('${event.name}')">Register</button>
        `;
        container.appendChild(card);
    });
}

function updateUI() {
    renderEvents(events);
}

// 8. Event Handling
window.registerUserHandler = function(eventName) {
    if (registerUser(eventName)) {
        alert("Registration successful!");
    }
};
document.querySelector("#categoryFilter")?.addEventListener("change", function(e) {
    filterEventsByCategory(e.target.value, renderEvents);
});
document.querySelector("#searchInput")?.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
        const val = e.target.value.toLowerCase();
        const filtered = events.filter(ev => ev.name.toLowerCase().includes(val));
        renderEvents(filtered);
    }
});

// 9. Async JS, Promises, Async/Await
function fetchEvents() {
    document.querySelector("#loadingSpinner")?.classList.remove("hidden");
    return fetch("https://mockapi.io/events")
        .then(res => res.json())
        .then(data => {
            document.querySelector("#loadingSpinner")?.classList.add("hidden");
            renderEvents(data);
        })
        .catch(err => {
            document.querySelector("#loadingSpinner")?.classList.add("hidden");
            alert("Failed to fetch events");
        });
}

async function fetchEventsAsync() {
    document.querySelector("#loadingSpinner")?.classList.remove("hidden");
    try {
        const res = await fetch("https://mockapi.io/events");
        const data = await res.json();
        renderEvents(data);
    } catch {
        alert("Failed to fetch events");