package shortcuts.keyboard.windows.squlite.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import shortcuts.keyboard.windows.squlite.Model.Employee;
import shortcuts.keyboard.windows.squlite.R;
import shortcuts.keyboard.windows.squlite.SQultieDatabase.EmployeeManager;

public class Entry_data_Activity extends AppCompatActivity {

    EditText nameEt,phoneNoEt;
    Button saveBtn;
    EmployeeManager employeeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_);
        nameEt = (EditText) findViewById(R.id.nameEt);
        phoneNoEt = (EditText) findViewById(R.id.phoneEt);
    }

    public void saveData(View view) {
        String name = nameEt.getText().toString();
        String phone = phoneNoEt.getText().toString();
        Employee employee = new Employee(name,phone);
        employeeManager = new EmployeeManager(this);
        long result = employeeManager.addEmployee(employee);
        if(result>0){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "failled", Toast.LENGTH_SHORT).show();
        }

    }
}
