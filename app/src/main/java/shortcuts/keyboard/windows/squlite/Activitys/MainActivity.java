package shortcuts.keyboard.windows.squlite.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import shortcuts.keyboard.windows.squlite.Adapter.CustomAdapter;
import shortcuts.keyboard.windows.squlite.Model.Employee;
import shortcuts.keyboard.windows.squlite.R;
import shortcuts.keyboard.windows.squlite.SQultieDatabase.EmployeeManager;

public class MainActivity extends AppCompatActivity {
    Button addEmployeeBtn;
    ListView employeeListview;
    EmployeeManager employeeManager; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employeeListview  = (ListView) findViewById(R.id.employeeListView);
        addEmployeeBtn = (Button) findViewById(R.id.addBtn);
        employeeManager = new EmployeeManager(this);
        ArrayList<Employee> employees = employeeManager.viewEmployeeData();
        employeeListview.setAdapter(new CustomAdapter(this, employees) {
        });
    }
    public void addEmployee(View view) {
        Intent intent = new Intent(this,Entry_data_Activity.class);
        startActivity(intent);
    }
}
