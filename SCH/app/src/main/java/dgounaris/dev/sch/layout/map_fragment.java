package dgounaris.dev.sch.layout;

import android.content.Context;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import dgounaris.dev.sch.R;

public class map_fragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    GoogleMap map;

    public map_fragment() {
        // Required empty public constructor
    }

    public static map_fragment newInstance() {
        map_fragment fragment = new map_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_map_fragment, container, false);
        mapView = (MapView) rootview.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.getMapAsync(this);
        return rootview;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng athens = new LatLng(37.97945, 23.71622);
        LatLng ilioupoli = new LatLng(37.930524,23.747831);
        LatLng dafni = new LatLng(37.949654,23.74097);
        LatLng peiraias = new LatLng(37.942986,23.646983);
        LatLng zografou = new LatLng(37.974215,23.784107);
        LatLng egaleo = new LatLng(37.995986,23.681108);
        LatLng panepisthmio = new LatLng(37.980383,23.732884);
        LatLng perama = new LatLng(37.965609,23.567709);
        LatLng athens2 = new LatLng(38.141707, 23.858689);
        LatLng athens3 = new LatLng(37.929079, 23.513327);
        map.addMarker(new MarkerOptions().position(athens).title("Bin #1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(ilioupoli).title("Bin #2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(dafni).title("Bin #3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(peiraias).title("Bin #4").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(zografou).title("Bin #5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(egaleo).title("Bin #6").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(panepisthmio).title("Bin #7").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(perama).title("Bin #8").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(athens2).title("Bin #9").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(athens3).title("Bin #10").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(athens).zoom(12).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        map.getUiSettings();

    }

    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.mapview);
    }
}
