const calendarEl = document.getElementById('calendar');
const now = new Date();

function getMonthName(now) {
    const year = now.getFullYear();
    const month = now.getMonth();
    return new Date(year, month).toLocaleString('default', { month: 'long' });
}

function renderCalendar(now) {
    const year = now.getFullYear();
    const month = now.getMonth();
    const todayDate = now.getDate();
    const hour = now.getHours().toString().padStart(2, '0');
    const minute = now.getMinutes().toString().padStart(2, '0');

    const firstDay = new Date(year, month, 1).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    let html = `<div class="calendar-header">${getMonthName(now)} ${year} - ${hour}:${minute}</div>`;
    html += `<div class="calendar-grid">
        <div>Sun</div><div>Mon</div><div>Tue</div><div>Wed</div><div>Thu</div><div>Fri</div><div>Sat</div>
    `;

    for (let i = 0; i < firstDay; i++) {
        html += `<div class="empty"></div>`;
    }
    for (let day = 1; day <= daysInMonth; day++) {
        // Add 'today' class if this is the current day in the current month/year
        const isToday = day === todayDate && month === now.getMonth() && year === now.getFullYear();
        html += `<div class="day${isToday ? ' today' : ''}">${day}</div>`;
    }
    html += `</div>`;
    calendarEl.innerHTML = html;
}

renderCalendar(now);