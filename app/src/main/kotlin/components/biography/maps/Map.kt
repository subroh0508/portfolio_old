package components.biography.maps

import org.w3c.dom.Window

inline fun Window.initMap()
    //language=js
    = js("""
        new window.google.maps.Map(
          document.getElementById('googleMap'),
          {
            center: { lat: 34.740864, lng: 139.391152 },
            zoom: 11.3,
            mapTypeId: 'roadmap'
          }
        )
    """)
