package com.example.den.lesson3;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    // ************** Spinner **************


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
//
//        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//
//
//        spinner.setAdapter(adapter);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setOnItemSelectedListener(this);
//    }


//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        Resources res = getResources();
//        CharSequence[] items = res.getTextArray(R.array.car_types);
//
//        Toast toast = Toast.makeText(this, items[pos], Toast.LENGTH_SHORT);
//        toast.show();
//    }

//    public void onNothingSelected(AdapterView<?> parent) {
//        int i = 0;
//    }
//
//    // ************** List View **************
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_streets);
//
//        ListView listView = (ListView) findViewById(R.id.listView);
//
//        Resources res = getResources();
//        final String[] streets = res.getStringArray(R.array.streets_array);
//
//        ArrayAdapter<String> streetsAdapter =
//                new ArrayAdapter<String>(this,
//                        R.layout.item,
//                        R.id.text1,
//                        streets
//                );
//
//        listView.setAdapter(streetsAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView,
//                                    View view, int position, long rowId) {
//
//                // Generate a message based on the position
//                String message = "You clicked on " + streets[position];
//
//                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//    }

  //   ************** Grid View **************

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        final String[] cheeses = {
//                "Parmesan",
//                "Ricotta",
//                "Fontina",
//                "Mozzarella",
//                "Cheddar"
//        };
//
//        ArrayAdapter<String> cheeseAdapter =
//                new ArrayAdapter<String>(this,
//                        R.layout.item,
//                        R.id.text1,
//                        cheeses
//                );
//
//        GridView cheeseGrid = new GridView(this);
//
//        setContentView(cheeseGrid);
//
//        cheeseGrid.setNumColumns(3);
//        cheeseGrid.setColumnWidth(60);
//        cheeseGrid.setVerticalSpacing(20);
//        cheeseGrid.setHorizontalSpacing(20);
//
//        cheeseGrid.setAdapter(cheeseAdapter);
//
//        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView,
//                                    View view, int position, long rowId) {
//
//                // Generate a message based on the position
//                String message = "You clicked on " + cheeses[position];
//
//                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//    }

//
    // ************** Grid View Custom View & View Holder **************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        final String[] carsNameArray = res.getStringArray(R.array.car_types);
        final Cheese[] cheesesAdvanced = new Cheese[carsNameArray.length];
        for (int i = 0; i < carsNameArray.length; i++) {
            String carName = carsNameArray[i];
            int resourceId =  this.getResources().getIdentifier(carName.toLowerCase(), "drawable", getPackageName());
            Drawable carImage = getResources().getDrawable(resourceId);

            cheesesAdvanced[i] = new Cheese(carImage, carName);
        }


        ArrayAdapter<Cheese> cheeseAdapterAdvanced =
                new ArrayAdapter<Cheese>(this, 0, cheesesAdvanced) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {

                        Cheese currentCheese = cheesesAdvanced[position];

                        // Inflate only once
                        if (convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.custom_item, null, false);
                        }

                        if(convertView.getTag() == null) {
                            ViewHolder viewHolder = new ViewHolder();
                            viewHolder.cheeseName = convertView.findViewById(R.id.cheese_name);
                            viewHolder.cheeseImage = convertView.findViewById(R.id.cheese_image);
                            convertView.setTag(viewHolder);
                        }

                        TextView cheeseName = ((ViewHolder) convertView.getTag()).cheeseName;
                        ImageView cheeseDescription = ((ViewHolder) convertView.getTag()).cheeseImage;

                        cheeseName.setText(currentCheese.name);
                        cheeseDescription.setImageDrawable(currentCheese.imageResourceId);

                        return convertView;

                    }
                };

        GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);
        cheeseGrid.setNumColumns(2);
        cheeseGrid.setColumnWidth(60);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(20);
        cheeseGrid.setAdapter(cheeseAdapterAdvanced);

        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                // Generate a message based on the position
                String message = "You clicked on " + cheesesAdvanced[position].name;

                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
