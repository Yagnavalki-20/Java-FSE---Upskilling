console.log("Welcome to the Community Portal");
window.onload = () => {
  alert("Page Loaded!");
  const events = [
    { name: "Music Fest", date: "2025-06-15", seats: 5, type: "music" },
    { name: "Tech Talk", date: "2025-05-30", seats: 0, type: "tech" },
    { name: "Food Carnival", date: "2025-07-01", seats: 10, type: "food" }
  ];
  const eventList = document.getElementById("eventList");
  events.forEach(event => {
    const today = new Date().toISOString().split("T")[0];
    if (event.date > today && event.seats > 0) {
      const card = document.createElement("div");
      card.className = "eventCard";
      card.innerHTML = `<h3>${event.name}</h3><p>Date: ${event.date}</p><p>Seats: ${event.seats}</p>`;
      eventList.appendChild(card);
    }
  });
  document.getElementById("regForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = this.elements.name.value;
    const email = this.elements.email.value;
    if (name && email) {
      document.getElementById("formOutput").textContent = `Thank you, ${name}! You've registered successfully.`;
    } else {
      document.getElementById("formOutput").textContent = "Please fill all required fields.";
    }
  });
};
/* Video Message */
document.addEventListener("DOMContentLoaded", () => {
  const video = document.getElementById("eventVideo");
  video.oncanplay = () => {
    document.getElementById("videoStatus").textContent = "Video ready to play";
  };
});
/* localStorage for preferred event type */
const eventTypeSelect = document.querySelector("select[name='eventType']");
if (localStorage.getItem("preferredEvent")) {
  eventTypeSelect.value = localStorage.getItem("preferredEvent");
}
eventTypeSelect.onchange = () => {
  localStorage.setItem("preferredEvent", eventTypeSelect.value);
};
/* Clear Preferences Button */
const clearBtn = document.createElement("button");
clearBtn.textContent = "Clear Preferences";
clearBtn.onclick = () => {
  localStorage.clear();
  sessionStorage.clear();
  alert("Preferences cleared.");
};
document.getElementById("register").appendChild(clearBtn);
/* Geolocation */
const geoBtn = document.createElement("button");
geoBtn.textContent = "Find Nearby Events";
geoBtn.onclick = () => {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        alert(`Your location: Lat ${position.coords.latitude}, Lon ${position.coords.longitude}`);
      },
      (error) => {
        alert("Error: " + error.message);
      },
      { enableHighAccuracy: true, timeout: 5000 }
    );
  } else {
    alert("Geolocation is not supported by this browser.");
  }
};
document.getElementById("events").appendChild(geoBtn);
/* Mock Fetch with Async/Await */
async function mockRegister(data) {
  document.getElementById("formOutput").textContent = "Submitting...";
  await new Promise(resolve => setTimeout(resolve, 1000)); // simulate delay
  document.getElementById("formOutput").textContent = `Submitted successfully for ${data.name}`;
}
document.getElementById("regForm").addEventListener("submit", async function(e) {
  e.preventDefault();
  const name = this.elements.name.value;
  const email = this.elements.email.value;
  if (name && email) {
    await mockRegister({ name, email });
  }
});