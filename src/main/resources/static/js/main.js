document.addEventListener("submit", function(event) {
    event.preventDefault();
    updateSalary();
}, false);

function updateSalary() {
    let specialization = document.getElementById('specialization').value;
    let experience = document.getElementById('experience').value;
    fetch('/api/salary?specialization=' + specialization + '&experience=' + experience)
        .then(response => response.json())
        .then(report => {
            let currency = 'k руб.';
            document.getElementById('median-salary').textContent = report.salaryStatistic.median + currency;
            document.getElementById('seventy-five-percentile').textContent = report.salaryStatistic.seventyFivePercentile + currency;
            document.getElementById('twenty-five-percentile').textContent = report.salaryStatistic.twentyFivePercentile + currency;
            document.getElementById('max-salary').textContent = report.salaryStatistic.maximum + currency;
            document.getElementById('average-salary').textContent = report.salaryStatistic.average;
            document.getElementById('vacancy-count').textContent = report.vacancyCount;
        });
}
