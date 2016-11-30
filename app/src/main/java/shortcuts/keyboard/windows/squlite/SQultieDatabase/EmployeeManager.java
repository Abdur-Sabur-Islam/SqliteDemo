package shortcuts.keyboard.windows.squlite.SQultieDatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Queue;

import shortcuts.keyboard.windows.squlite.Model.Employee;

/**
 * Created by acer on 11/26/2016.
 */

public class EmployeeManager {
    private Activity context;
    DBHelper dbHelper;

    public EmployeeManager(Activity context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }
    public long addEmployee(Employee employee){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_NAME,employee.getEmployeeName());
        contentValues.put(DBHelper.COLUMN_PHONENO,employee.getEmployeePhoneNo());

        long result = sqLiteDatabase.insert(dbHelper.TABLE_EMPLOYEE,null,contentValues);
        sqLiteDatabase.close();
        return result;

    }
    public ArrayList<Employee> viewEmployeeData(){
        ArrayList<Employee> employeeData = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String selectQuery = "select * from "+DBHelper.TABLE_EMPLOYEE;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PHONENO));
                Employee employee = new Employee(name,phoneNo,id);
                employeeData.add(employee);

            }while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return  employeeData;

    }
}















