package dgounaris.dev.sch.layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import dgounaris.dev.sch.People.Person;
import dgounaris.dev.sch.R;
import dgounaris.dev.sch.adapter.Trophy;
import dgounaris.dev.sch.adapter.TrophyAdapter;

public class profile_fragment extends Fragment {

    private Person activeperson;

    public profile_fragment() {
        // Required empty public constructor
    }

    public static profile_fragment newInstance() {
        profile_fragment fragment = new profile_fragment();
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
        View view = inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        //SET NAME, BALANCE
        TextView nameText = (TextView) view.findViewById(R.id.name);
        nameText.setText(activeperson.getName() + " " + activeperson.getSurname());
        TextView balance = (TextView) view.findViewById(R.id.balance);
        balance.setText(activeperson.getPoints() + " points");

        ArrayList<Trophy> trophies;
        // SET VALUES TO TROPHIES HERE
        trophies = activeperson.getTrophies();

        TrophyAdapter adapter = new TrophyAdapter(getContext(), trophies);

        ListView listView = (ListView) view.findViewById(R.id.trophy_list);
        // listView.setBackgroundColor(Color.parseColor("#8800A0"));

        listView.setAdapter(adapter);

        return view;
    }
}
