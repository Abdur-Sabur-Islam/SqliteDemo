package shortcuts.keyboard.windows.squlite.SQultieDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by acer on 11/26/2016.
 */

public class DBHelper extends SQLiteOpenHelper{
    public  static  String DATABASE_NAME = "Employee_DataBase";
    public static  final  int DATABASE_VERSION = 1;

    public  static  String TABLE_EMPLOYEE = "employee";

    public static  String COLUMN_ID = "id";
    public static String COLUMN_NAME = "name";
    public static  String COLUMN_PHONENO = "phoneNo";

   private static String CREATE_TABLE_EMPLOYEE ="create table "+TABLE_EMPLOYEE+"( "+COLUMN_ID+" integer primary key autoincrement, "
           +COLUMN_NAME+" text, "+COLUMN_PHONENO+" text);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_EMPLOYEE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist "+TABLE_EMPLOYEE);
        onCreate(sqLiteDatabase);

    }
}
