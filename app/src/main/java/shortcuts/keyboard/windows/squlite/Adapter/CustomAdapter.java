package shortcuts.keyboard.windows.squlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import shortcuts.keyboard.windows.squlite.Model.Employee;
import shortcuts.keyboard.windows.squlite.R;

/**
 * Created by acer on 11/26/2016.
 */

public class CustomAdapter  extends BaseAdapter{
    private ArrayList<Employee> employeeInformation;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context,ArrayList<Employee> employeeInformation) {
        this.employeeInformation = employeeInformation;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return employeeInformation.size();
    }

    @Override
    public Object getItem(int i) {
        return employeeInformation.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.row_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.nameTv = (TextView) view.findViewById(R.id.nameTv);
            viewHolder.phoneTv = (TextView) view.findViewById(R.id.phoneTv);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.nameTv.setText(employeeInformation.get(i).getEmployeeName());
        viewHolder.phoneTv.setText(employeeInformation.get(i).getEmployeePhoneNo());
        return view;
    }
    static class ViewHolder{
        TextView nameTv;
        TextView phoneTv;
    }
}
