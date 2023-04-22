const boxImgA = document.getElementById('box-a-img');
const boxImgB = document.getElementById('box-b-img');
const boxTempA = document.getElementById('box-a-temp');
const boxTempB = document.getElementById('box-b-temp');

fetch("http://api.openweathermap.org/data/2.5/weather?q=Sofia,bg&APPID=f62260d4757e6af8bc90ccf20ff70b1f")
    .then(data => data.json())
    .then(info => {
        console.log(info);

        //Formula Kelvin to Celsius 299K - 273.15 = 25.85C
    boxTempA.innerText = Math.round(info.main.temp - 273.15);
    boxImgA.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
    });

fetch("http://api.openweathermap.org/data/2.5/weather?q=Sozopol,bg&APPID=f62260d4757e6af8bc90ccf20ff70b1f")
    .then(data => data.json())
    .then(info => {
        console.log(info);

        //Formula Kelvin to Celsius 299K - 273.15 = 25.85C
        boxTempB.innerText = Math.round(info.main.temp - 273.15);
        boxImgB.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
    });
