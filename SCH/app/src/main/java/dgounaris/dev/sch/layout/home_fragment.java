package dgounaris.dev.sch.layout;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

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
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        ImageButton button = (ImageButton) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog myDialog = new Dialog(getActivity());

                TextView text = new TextView(getContext());
                text.setText("Connecting...");
                text.setPadding(50,50,50,50);
                text.setTextSize(20);
                myDialog.setContentView(text);
                myDialog.show();
            }
        });


        return view;
    }

    private void onBinConnection() {

    }

}
