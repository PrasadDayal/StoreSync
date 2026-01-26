const ctx = document.getElementById("stockChart");

if (ctx && window.productNames && window.productNames.length > 0) {
    new Chart(ctx, {
        type: "bar",
        data: {
            labels: window.productNames,
            datasets: [{
                label: "Product Quantity",
                data: window.productQuantities,
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    document.addEventListener("DOMContentLoaded", function () {
    const welcomeMessage = document.getElementById("welcomeMessage");

    if (welcomeMessage) {
        setTimeout(() => {
            welcomeMessage.classList.add("hide");
        }, 10000); // 10 seconds
    }
});
}

