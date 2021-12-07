// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

var tongnguoidktiem = null;
var tongnguoimui0;
var tongnguoimui1;
var tongnguoimui2;
var tilemui0;
var tilemui1;
var tilemui2;
fetch('/rest/nguoitiem/counttc').then(response => response.json()).then(data => {
	tongnguoidktiem = data;
	fetch('/rest/nguoitiem/countm1').then(response => response.json()).then(data => {
		tongnguoimui1 = data;
		fetch('/rest/nguoitiem/countm2').then(response => response.json()).then(data => {
			tongnguoimui2 = data;
			tongnguoimui0 = tongnguoidktiem - tongnguoimui1;
	
			tilemui0 = (tongnguoimui0 * 100) / tongnguoidktiem;
			tilemui1 = (tongnguoimui1[0] * 100) / tongnguoidktiem;
			tilemui2 = (tongnguoimui2[0] * 100) / tongnguoidktiem;
			

			var ctx = document.getElementById("myPieChart");
			var myPieChart = new Chart(ctx, {
				type: 'doughnut',
				data: {
					labels: ["Chưa tiêm", "Mũi 1", "Mũi 2"],
					datasets: [{
						data: [tilemui0.toFixed(2), tilemui1.toFixed(2), tilemui2.toFixed(2)],
						backgroundColor: ['#ad1515', '#e3e330', '#22d918'],
						hoverBackgroundColor: ['#e60b0b', '#f2e307', '#2ef207'],
						hoverBorderColor: "rgba(234, 236, 244, 1)",
					}],
				},
				options: {
					maintainAspectRatio: false,
					tooltips: {
						backgroundColor: "rgb(255,255,255)",
						bodyFontColor: "#858796",
						borderColor: '#dddfeb',
						borderWidth: 1,
						xPadding: 15,
						yPadding: 15,
						displayColors: false,
						caretPadding: 10,
					},
					legend: {
						display: false
					},
					cutoutPercentage: 80,
				},
			});
		});
	});

});



// Pie Chart Example

