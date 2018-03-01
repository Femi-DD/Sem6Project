//    google map start
    (function($) {
        "use strict";

        google.maps.event.addDomListener(window, 'load', init);

        var map;

        function init() {
            var mapOptions = {
                zoom: 24,
                center: new google.maps.LatLng(41.7906594,-88.1567997),
                panControl: false,
                panControlOptions:{
                    position: google.maps.ControlPosition.BOTTOM_LEFT
                },
                zoomControl:true,
                zoomControlOptions: {
                    style: google.maps.ZoomControlStyle.SMALL,
                    position: google.maps.ControlPosition.RIGHT_BOTTOM
                },
                disableDoubleClickZoom: false,
                mapTypeControl: true,
                mapTypeControlOptions: {
                    style: google.maps.MapTypeControlStyle.DEFAULT,
                },
                scaleControl: true,
                scrollwheel: false,
                streetViewControl: true,
                streetViewControlOptions: {
                    position: google.maps.ControlPosition.RIGHT_BOTTOM
                },
                draggable : true,
                overviewMapControl: true,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }

            var mapElement = document.getElementById('propety_location');
            map = new google.maps.Map(mapElement, mapOptions);
            
            var defaultBounds = new google.maps.LatLngBounds(
                new google.maps.LatLng(41.7906594,-88.1567997),
                new google.maps.LatLng(41.7906094,-88.1507997));
                
            map.fitBounds(defaultBounds);
            
            var input = /** @type {HTMLInputElement} */(
                document.getElementById('pac-input'));
            map.controls.push(input);
            //map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

            var searchBox = new google.maps.places.SearchBox((input));
            
            google.maps.event.addListener(searchBox, 'places_changed', function() {
            
                var places = searchBox.getPlaces();

                if (places.length == 0) {
                    return
                }
                for (var i = 0, marker; marker = markers[i]; i++) {
                    marker.setMap(null)
                }

                // For each place, get the icon, place name, and location.
                var markers = [];
                var bounds = new google.maps.LatLngBounds();
                for (var i = 0, place; place = places[i]; i++) {
                  var image = {
                    url: place.icon,
                    size: new google.maps.Size(71, 71),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(25, 25)
                  };

                  // Create a marker for each place.
                  var marker = new google.maps.Marker({
                    map: map,
                    icon: image,
                    title: place.name,
                    position: place.geometry.location
                  });

                  markers.push(marker);

                  bounds.extend(place.geometry.location)
                }
 
                map.fitBounds(bounds)
            });
            google.maps.event.addListener(map, 'bounds_changed', function() {
                var bounds = map.getBounds();
                searchBox.setBounds(bounds)
            })
        }
    })(jQuery)
//    google map end