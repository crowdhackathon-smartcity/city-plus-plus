package dgounaris.dev.sch.layout;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import dgounaris.dev.sch.People.Person;
import dgounaris.dev.sch.R;

public class home_fragment extends Fragment {

    private Person activeperson;

    public home_fragment() {
        // Required empty public constructor
    }

    public static home_fragment newInstance() {
        home_fragment fragment = new home_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activeperson = (Person) getArguments().getSerializable("activeperson");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        ImageButton button = (ImageButton) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog myDialog = new Dialog(getActivity());

                final TextView text = new TextView(getContext());
                text.setText("Connecting...");
                text.setPadding(50, 50, 50, 50);
                text.setTextSize(20);
                myDialog.setContentView(text);
                myDialog.show();

                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                        Toast.makeText(getContext(), "Succesfully Connected", Toast.LENGTH_SHORT).show();
                        //FragmentManager fragmentManager = getFragmentManager();
                        //fragmentManager.beginTransaction().replace(R.id.profile_f, profile_fragment.newInstance()).commit();

                    }
                }, 3000);


//                BluetoothAdapter bl = BluetoothAdapter.getDefaultAdapter();
//                Intent bl_intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                startActivityForResult(bl_intent, 0);
//                Set<BluetoothDevice> paired_devices;
//                paired_devices = bl.getBondedDevices();

            }
        });


        return view;
    }

    private void onBinConnection() {

    }

}
