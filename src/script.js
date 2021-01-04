'use script'

function initialSchedule() {
    let table = document.getElementById("table__body");
    let row = table.insertRow(0);

    let cell;
    for (let i = 0; i < 6; i++) {
        cell = row.insertCell(i);

        let btn = document.createElement('button');
        btn.textContent = '+';

        cell.appendChild(btn);
    }
}
