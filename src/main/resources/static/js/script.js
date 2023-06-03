function initMap() {
  const selector = document.getElementById("map");
  const center = { lat: 48.854859, lng: 2.347067 };
  const point = { lat: 48.8880668, lng: 2.3087795 };
  const options = {
    center: center,
    zoom: 12,
  };

  const map = new google.maps.Map(selector, options);
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch("http://localhost:8080/all-places", requestOptions)
    .then((response) => response.json())
    .then((result) => {
      result.map((place) => {
        new google.maps.Marker({
          position: { lat: +place.latitude, lng: +place.longitude },
          map: map,
        });
      });
    })
    .catch((error) => console.log("error", error));
}
