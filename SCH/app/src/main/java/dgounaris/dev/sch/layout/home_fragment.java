package dgounaris.dev.sch.layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import dgounaris.dev.sch.People.Person;
import dgounaris.dev.sch.R;

public class home_fragment extends Fragment {

    private Person activeperson;

    PopupWindow popUpWindow;

    LinearLayout.LayoutParams layoutParams;

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

        final ImageButton button = (ImageButton) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpWindow = new PopupWindow();
                popUpWindow.showAtLocation(getView(), Gravity.BOTTOM, 10, 10);
                popUpWindow.update(50, 50, 320, 90);
                TextView msg = new TextView(getContext());
                msg.setText("Connecting...");

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                LinearLayout containerLayout = new LinearLayout(getContext());

                containerLayout.setOrientation(LinearLayout.VERTICAL);
                containerLayout.addView(msg, layoutParams);
                popUpWindow.setContentView(containerLayout);
                //FrameLayout mainLayout = (FrameLayout) view.findViewById(R.id.frame);



                //mainLayout.removeAllViewsInLayout();
                //mainLayout.addView(button, layoutParams);

            }
        });


        return view;

    }

    private void onBinConnection() {

    }

}
