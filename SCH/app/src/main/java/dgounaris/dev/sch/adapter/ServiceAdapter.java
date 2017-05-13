package dgounaris.dev.sch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dgounaris.dev.sch.People.Service;
import dgounaris.dev.sch.R;

/**
 * Created by Rhogarj on 5/13/2017.
 */

public class ServiceAdapter extends ArrayAdapter<Service> {

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.service_list_item, parent, false);
        }

        Service current_service = getItem(position);

        TextView mainname = (TextView) listItemView.findViewById(R.id.service_name);
        mainname.setText(current_service.getName());
        TextView slotstext = (TextView) listItemView.findViewById(R.id.service_slots);
        slotstext.setText(current_service.getSlots() + "");
        TextView pointstext = (TextView) listItemView.findViewById(R.id.points_needed);
        pointstext.setText(current_service.getPoints_needed() + "");
        return listItemView;
    }

    public ServiceAdapter(Context context, ArrayList<Service> arrayList) {
        super(context, 0, arrayList);
    }

}
